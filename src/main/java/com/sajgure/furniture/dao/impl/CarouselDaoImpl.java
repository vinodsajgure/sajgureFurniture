package com.sajgure.furniture.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sajgure.furniture.constant.ExceptionErrorCode;
import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dao.CarouselDao;
import com.sajgure.furniture.dao.GenericDAO;
import com.sajgure.furniture.dto.CountsDTO;
import com.sajgure.furniture.entity.Carousel;
import com.sajgure.furniture.exceptions.DAOException;

@Repository
public class CarouselDaoImpl extends GenericDAO implements CarouselDao {

	@Override
	public List<Carousel> findAll() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<Carousel> carousels = session.createQuery(" from Carousel").list();
			return carousels;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public Carousel findById(int id) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Carousel carousel = (Carousel) session.createQuery(" from Carousel where id = :id").setParameter("id", id)
					.uniqueResult();
			return carousel;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void save(Carousel entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (RuntimeException re) {
			// re.printStackTrace();
			Throwable throwable = re.getCause();
			if (throwable instanceof SQLIntegrityConstraintViolationException) {
				re.printStackTrace();
				// throw new
				// DatabaseConflictException(ExceptionErrorCode.INTEGRITY_VIOLATION_EXCEPTION,
				// re);
			}
			GenericDAO.rollback(transaction);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);

		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public List<Carousel> findByStatus(Status status) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<Carousel> carousels = session.createQuery(" from Carousel where status = :status")
			.setParameter("status", status).list();
			return carousels;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			re.printStackTrace();
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void updateStatus(int id, Status status) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hqlUpdate = "update Carousel c set c.status = :status where c.id = :id";
			session.createQuery( hqlUpdate )
			        .setParameter( "status", status )
			        .setParameter( "id", id )
			        .executeUpdate();
			transaction.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			Throwable throwable = re.getCause();
			if (throwable instanceof SQLIntegrityConstraintViolationException) {
				re.printStackTrace();
			}
			GenericDAO.rollback(transaction);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);

		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void delete(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Carousel carousel = (Carousel) session.get(Carousel.class, id);

            session.delete(carousel);

            session.getTransaction().commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
			Throwable throwable = re.getCause();
			if (throwable instanceof SQLIntegrityConstraintViolationException) {
				re.printStackTrace();
			}
			GenericDAO.rollback(transaction);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}
	
	@Override
	public CountsDTO findAllStatusCounts() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			CountsDTO carousels = (CountsDTO) session.createNativeQuery("SELECT "
					+ "count(status) as total, sum(status='Active') as active, sum(status='Inactive') as inactive "
					+ "FROM carousel c")
					.setResultTransformer(Transformers.aliasToBean(CountsDTO.class))
					.getSingleResult();
			return carousels;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			re.printStackTrace();
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

}
