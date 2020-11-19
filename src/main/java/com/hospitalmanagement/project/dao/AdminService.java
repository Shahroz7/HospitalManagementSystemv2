package com.hospitalmanagement.project.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hospitalmanagement.project.model.AdminLogin;

public interface AdminService extends MongoRepository<AdminLogin, Integer>{
	
	
	

}
