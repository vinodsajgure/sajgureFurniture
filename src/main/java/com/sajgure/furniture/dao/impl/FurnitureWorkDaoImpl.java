package com.sajgure.furniture.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sajgure.furniture.constant.ExceptionErrorCode;
import com.sajgure.furniture.constant.Status;
import com.sajgure.furniture.dao.FurnitureWorkDao;
import com.sajgure.furniture.dao.GenericDAO;
import com.sajgure.furniture.entity.FurnitureWork;
import com.sajgure.furniture.exceptions.DAOException;

@Repository
public class FurnitureWorkDaoImpl extends GenericDAO implements FurnitureWorkDao {

	@Override
	public List<FurnitureWork> findAll() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<FurnitureWork> furnitureWorks = session.createQuery(" from FurnitureWork").list();
			return furnitureWorks;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void save(FurnitureWork entity) {
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
	public FurnitureWork findById(int id) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			FurnitureWork furnitureWork = (FurnitureWork) session.createQuery(" from FurnitureWork where id = :id")
					.setParameter("id", id).uniqueResult();
			return furnitureWork;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
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
			String hqlUpdate = "update FurnitureWork c set c.status = :status where c.id = :id";
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
			FurnitureWork furnitureWork = (FurnitureWork) session.get(FurnitureWork.class, id);
            session.delete(furnitureWork);
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
	public List<FurnitureWork> findByStatus(Status active) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<FurnitureWork> furnitureWork = session.createQuery(" from FurnitureWork where status = :status")
					.setParameter("status", active).list();
			return furnitureWork;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

}
