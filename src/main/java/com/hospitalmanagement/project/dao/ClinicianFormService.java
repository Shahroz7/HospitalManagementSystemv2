package com.hospitalmanagement.project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hospitalmanagement.project.model.ClinicianForm;

public interface ClinicianFormService extends MongoRepository<ClinicianForm, String>{

	ClinicianForm findByClinicianId(String clinicianId);

	void deleteByClinicianId(String clinicianId);
	

}
