package com.sajgure.furniture.dao.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sajgure.furniture.constant.EnquiryStatus;
import com.sajgure.furniture.constant.ExceptionErrorCode;
import com.sajgure.furniture.dao.EnquiryDao;
import com.sajgure.furniture.dao.GenericDAO;
import com.sajgure.furniture.dto.EnquiryCountsDTO;
import com.sajgure.furniture.entity.Enquiry;
import com.sajgure.furniture.exceptions.DAOException;

@Repository
public class EnquiryDaoImpl extends GenericDAO implements EnquiryDao {

	@Override
	public List<Enquiry> findAll() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			@SuppressWarnings("unchecked")
			List<Enquiry> enquiries = session.createQuery(" from Enquiry").list();
			return enquiries;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void save(Enquiry entity) {
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
	public Enquiry findById(int id) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Enquiry enquiry = (Enquiry) session.createQuery(" from Enquiry where id = :id").setParameter("id", id)
					.uniqueResult();
			return enquiry;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, re);
		} finally {
			GenericDAO.close(session);
		}
	}

	@Override
	public void changeEnquiryStatus(int id, EnquiryStatus status) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hqlUpdate = "update Enquiry e set e.status = :status where e.enquiryId = :enquiryId";
			// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
			session.createQuery( hqlUpdate )
			        .setParameter( "status", status )
			        .setParameter( "enquiryId", id )
			        .executeUpdate();
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
	public EnquiryCountsDTO findAllStatusCounts() {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			EnquiryCountsDTO carousels = (EnquiryCountsDTO) session.createNativeQuery("SELECT "
					+ "count(status) as total, "
					+ "sum(status='New') as inNew, "
					+ "sum(status='INPROGRESS') as inProgress, "
					+ "sum(status='COMPLETED') as completed "
					+ "FROM enquiry")
					.setResultTransformer(Transformers.aliasToBean(EnquiryCountsDTO.class))
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
