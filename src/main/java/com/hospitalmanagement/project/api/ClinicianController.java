package com.hospitalmanagement.project.api;

import java.util.List;

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
	
	
	@GetMapping("/clinician-get/{phone}")
	public ResponseEntity<ClinicianForm> getEmployeeByPhone(@PathVariable String phone) {
		ClinicianForm clinicianForm = clinicianFormService.findByPhone(phone);
		System.out.println("Getting the value using phone" + clinicianForm);
		return ResponseEntity.ok().body(clinicianForm);
	}

	@DeleteMapping("/clinician-delete/{phone}")
	public String deletePatientForm(@PathVariable String phone) {
		System.out.println("Delete is called by angular");
		clinicianFormService.deleteByPhone(phone);
		System.out.println("Clinician is deleted ");
		return "Patient deleted by phone";
	}
	
	@PutMapping("/clinician-update/{phone}")
	public ResponseEntity<ClinicianForm> updatePatientForm(@PathVariable String phone, 
			@RequestBody ClinicianForm clinicianForm) {
	  ClinicianForm cForm = clinicianFormService.findByPhone(phone);
	  
	  cForm.setAddress(clinicianForm.getAddress());
      cForm.setAge(clinicianForm.getAge());
      cForm.setFullname(clinicianForm.getFullname());
      cForm.setPhone(clinicianForm.getPhone());
      System.out.println("phone value in java "+clinicianForm.getPhone());
      cForm.setGender(clinicianForm.getGender());
      cForm.setEmail(clinicianForm.getEmail());
      cForm.setAvailability(clinicianForm.getAvailability());
      cForm.setExperience(clinicianForm.getExperience());
      cForm.setSpecialization(clinicianForm.getSpecialization());
      clinicianFormService.deleteByPhone(phone);
	    return new ResponseEntity<>(clinicianFormService.save(cForm), HttpStatus.OK);
	  } 
	
}
