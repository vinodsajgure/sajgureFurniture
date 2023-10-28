package com.sajgure.furniture.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sajgure.furniture.entity.Enquiry;

@Repository
public interface EnqiryDataRepository extends CrudRepository<Enquiry, Integer>{

}
