package com.hospitalmanagement.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospitalmanagement.project.model.PatientForm;


public interface PatientFormService extends MongoRepository<PatientForm, String> {

	void deleteByPhone(String phone);

	PatientForm findByPhone(String phone);

	PatientForm findByFullname(String fullname);

}
