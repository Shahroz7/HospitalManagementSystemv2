package com.hospitalmanagement.project.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.project.dao.AdminService;



@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	
}
