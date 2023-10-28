package com.sajgure.furniture.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sajgure.furniture.constant.ExceptionErrorCode;
import com.sajgure.furniture.dao.GenericDAO;
import com.sajgure.furniture.dao.UserDAO;
import com.sajgure.furniture.dto.UserCountDTO;
import com.sajgure.furniture.entity.User;
import com.sajgure.furniture.exceptions.DAOException;

@Repository
public class UserDaoImpl extends GenericDAO implements UserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			List<User> users = session.createQuery(" from User").list();
			return users;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public User findById(int id) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			User user = (User) session.createQuery("from User where id =:id")
					.setParameter("id", id)
					.uniqueResult();
			return user;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			re.printStackTrace();
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void save(User entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (RuntimeException re) {
			re.printStackTrace();
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
	public User findByEmailId(String email) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			User user = (User) session.createQuery("from User where email = :email")
					.setParameter("email", email)
					.uniqueResult();
			return user;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			re.printStackTrace();
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}
	
	@Override
	public void deleteUserByEmail(String email) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			User user = (User) session.get(User.class, email);
            session.delete(user);
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
	public void updateEnabledStatus(String email, boolean status) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hqlUpdate = "update User u set u.enabled = :enabled where u.email = :email";
			session.createQuery( hqlUpdate )
			        .setParameter( "enabled", status )
			        .setParameter( "email", email )
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
	public UserCountDTO findAllStatusCounts() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			UserCountDTO carousels = (UserCountDTO) session.createNativeQuery("SELECT "
					+ "count(*) as total, "
					+ "sum(enabled=true) as enabled, "
					+ "sum(enabled=false) as disabled "
					+ "FROM user")
					.setResultTransformer(Transformers.aliasToBean(UserCountDTO.class))
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
