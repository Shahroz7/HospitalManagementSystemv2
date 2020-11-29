package com.hospitalmanagement.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospitalmanagement.project.model.PatientForm;


public interface PatientFormService extends MongoRepository<PatientForm, String> {

	void deleteByPatientId(String patientId);

	PatientForm findByPatientId(String patientId);

	PatientForm findByFullname(String fullname);

}
