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

import com.hospitalmanagement.project.dao.ClinicianFormService;
import com.hospitalmanagement.project.model.ClinicianForm;

  
@CrossOrigin(origins = "http://localhost:4200")  
@RequestMapping(value="/api")  
@RestController
public class ClinicianController {

	@Autowired
	ClinicianFormService clinicianFormService;
	
	@GetMapping("/clinician/all")
	public List<ClinicianForm> getUserDetails(){
		return clinicianFormService.findAll();	
	}
	
	@PostMapping("/clinician-form")
	public String saveData(@RequestBody ClinicianForm clinicianForm) {
		System.out.println("What we got: "+clinicianForm);
		clinicianFormService.save(clinicianForm);
		System.out.println("checking checking");
		return "User added with name: "+ clinicianForm.getFullname();
	}
	
	
	@GetMapping("/clinician-get/{clinicianId}")
	public ResponseEntity<ClinicianForm> getEmployeeByClinicianId(@PathVariable String clinicianId) {
		ClinicianForm clinicianForm = clinicianFormService.findByClinicianId(clinicianId);
		System.out.println("Getting the value using clinicianId" + clinicianForm);
		return ResponseEntity.ok().body(clinicianForm);
	}

	@DeleteMapping("/clinician-delete/{clinicianId}")
	public String deletePatientForm(@PathVariable String clinicianId) {
		System.out.println("Delete is called by angular");
		clinicianFormService.deleteByClinicianId(clinicianId);
		System.out.println("Clinician is deleted ");
		return "Patient deleted by clinicianId";
	}
	
	@PutMapping("/clinician-update/{clinicianId}")
	public ResponseEntity<ClinicianForm> updatePatientForm(@PathVariable String clinicianId, 
			@RequestBody ClinicianForm clinicianForm) {
	  ClinicianForm cForm = clinicianFormService.findByClinicianId(clinicianId);
	  cForm.setClinicianId(clinicianForm.getClinicianId());
	  cForm.setAddress(clinicianForm.getAddress());
      cForm.setAge(clinicianForm.getAge());
      cForm.setFullname(clinicianForm.getFullname());
      cForm.setPhone(clinicianForm.getPhone());
      System.out.println("clinicianId value in java "+clinicianForm.getClinicianId());
      cForm.setGender(clinicianForm.getGender());
      cForm.setEmail(clinicianForm.getEmail());
      cForm.setAvailability(clinicianForm.getAvailability());
      cForm.setExperience(clinicianForm.getExperience());
      cForm.setSpecialization(clinicianForm.getSpecialization());
      clinicianFormService.deleteByClinicianId(clinicianId);
	    return new ResponseEntity<>(clinicianFormService.save(cForm), HttpStatus.OK);
	  }
	
	@GetMapping("/clinician-id")
	public String clinicianId() {
		Random rand = new Random();
	      System.out.println("Random numbers...");
	         int resRandom = rand.nextInt((99999 - 100) + 1) + 10;
	        String clinicianId = Integer.toString(resRandom);
	         System.out.println("5 didgit id is " + clinicianId);
		return clinicianId;
	}
	
	
}
