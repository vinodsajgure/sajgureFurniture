package com.sajgure.furniture.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;

import com.sajgure.furniture.constant.ExceptionErrorCode;
import com.sajgure.furniture.exceptions.DAOException;

public abstract class GenericDAO {

	private static final Logger log = LoggerFactory.getLogger(GenericDAO.class);
	/**
	 * Session factory - to be injected by spring
	 */
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		// return sessionFactory;
		if (sessionFactory == null)
			throw new DataAccessResourceFailureException("sessionFactory has not been set on session DAO before usage");
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	/**
	 * Closing session for each unit transaction
	 * 
	 * @param session
	 */
	public static void close(Session session) {
		if (session != null && session.isOpen()) {
			try {
				session.close();
			} catch (HibernateException ignored) {
				log.error("Couldn't close Session", ignored);
				throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, ignored);
			}
		}
	}

	/**
	 * Rollbacks transaction if exception Occurs
	 * 
	 * @param tx
	 */
	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			log.error("Couldn't rollback Transaction", ignored);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, ignored);
		}
	}

}