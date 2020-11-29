package com.hospitalmanagement.project.api;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.project.dao.PatientFormService;
import com.hospitalmanagement.project.model.PatientForm;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
@RestController
public class PatientController {

	@Autowired
	PatientFormService patientFormService;

	@PostMapping("/patient-form")
	public String savePatientForm(@RequestBody PatientForm patientForm) {
		patientFormService.save(patientForm);
		System.out.println("checking patient checking");
		return "User added with name: " + patientForm.getFullname();
	}

	@GetMapping("/patient-form/all")
	public List<PatientForm> getPatientDetails() {
		System.out.println("its getting selected");
		return patientFormService.findAll();
	}

	@GetMapping("/patient-get/{patientId}")
	public ResponseEntity<PatientForm> getEmployeeByPatientId(@PathVariable String patientId) {
		PatientForm patientForm = patientFormService.findByPatientId(patientId);
		System.out.println("Getting the value using patient id" + patientForm);
		return ResponseEntity.ok().body(patientForm);
	}

	@DeleteMapping("/patient-delete/{patientId}")
	public String deletePatientForm(@PathVariable String patientId) {
		System.out.println("Delete is called by angular");
		patientFormService.deleteByPatientId(patientId);
		System.out.println("Patient is deleted ");
		return "Patient deleted by phone";
	}
	
	@PutMapping("/patient-update/{patientId}")
	public ResponseEntity<PatientForm> updatePatientForm(@PathVariable String patientId, 
			@RequestBody PatientForm patientForm) {
	  PatientForm pForm = patientFormService.findByPatientId(patientId);
	  pForm.setPatientId(patientForm.getPatientId());
	  pForm.setAddress(patientForm.getAddress());
      pForm.setAge(patientForm.getAge());
      pForm.setFullname(patientForm.getFullname());
      pForm.setPhone(patientForm.getPhone());
      System.out.println("id value in java "+patientForm.getPatientId());
      pForm.setGender(patientForm.getGender());
      pForm.setEmail(patientForm.getEmail());
      pForm.setAppointment(patientForm.getAppointment());
      patientFormService.deleteByPatientId(patientId);
	    return new ResponseEntity<>(patientFormService.save(pForm), HttpStatus.OK);
	  } 
	
	@GetMapping("/patient-id")
	public String patientId() {
		Random rand = new Random();
	      System.out.println("Random numbers...");
	         int resRandom = rand.nextInt((99999 - 100) + 1) + 10;
	        String patientId = Integer.toString(resRandom);
	         System.out.println("5 didgit id is " + patientId);
		return patientId;
	}
	
		
}	

	
