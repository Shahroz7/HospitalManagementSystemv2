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

	@GetMapping("/patient-get/{phone}")
	public ResponseEntity<PatientForm> getEmployeeByPhone(@PathVariable String phone) {
		PatientForm patientForm = patientFormService.findByPhone(phone);
		System.out.println("Getting the value using phone" + patientForm);
		return ResponseEntity.ok().body(patientForm);
	}

	@DeleteMapping("/patient-delete/{phone}")
	public String deletePatientForm(@PathVariable String phone) {
		System.out.println("Delete is called by angular");
		patientFormService.deleteByPhone(phone);
		System.out.println("Patient is deleted ");
		return "Patient deleted by phone";
	}
	
	@PutMapping("/patient-update/{phone}")
	public ResponseEntity<PatientForm> updatePatientForm(@PathVariable String phone, 
			@RequestBody PatientForm patientForm) {
	  PatientForm pForm = patientFormService.findByPhone(phone);
	  
	  pForm.setAddress(patientForm.getAddress());
      pForm.setAge(patientForm.getAge());
      pForm.setFullname(patientForm.getFullname());
      pForm.setPhone(patientForm.getPhone());
      System.out.println("phone value in java "+patientForm.getPhone());
      pForm.setGender(patientForm.getGender());
      pForm.setEmail(patientForm.getEmail());
      pForm.setAppointment(patientForm.getAppointment());
      patientFormService.deleteByPhone(phone);
	    return new ResponseEntity<>(patientFormService.save(pForm), HttpStatus.OK);
	  } 
	
	@GetMapping("/patient-search/{fullname}")
	public PatientForm searchPatient(@PathVariable String fullname) {
		System.out.println("Seach is running");
		return patientFormService.findByFullname(fullname);
	}
	
	
//	@PostMapping("/filterData")  
//    public List<PatientForm> getFilteredData(@RequestBody PatientForm patientForm) {            
//        return patientFormService.getFilteredData(patientForm);  
//    }  
//	
}	

	
//	@PutMapping("patient-update/{phone}")
//    public String updatePateintForm(@RequestBody PatientForm patientForm) {
//		//System.out.println("phone is "+phone);
//        System.out.println("patientForm details"+ patientForm);
//		patientFormService.updatePatientForm(patientForm);
//        return "{'status:'success'}";
//    }
	
	
//	 @PutMapping("patient-update/{phone}")
//	    public PatientForm update(@PathVariable String phone, @RequestBody PatientForm patientForm) {
//	        return new PatientForm(HttpStatus.OK.value(), "Patient updated successfully.",patientFormService.update(patientForm));
//	    }
//	
//	@PutMapping("/patient-update/{phone}")
//    public ResponseEntity<PatientForm> updatePatientDetails(@PathVariable String phone,@RequestBody PatientForm patientForm){
//		PatientForm patientform = patientFormService.findByPhone(phone);
//		
//
//		patientform.setAddress(patientForm.getAddress());
//		        final PatientForm updatePatientDetails = ((CrudRepository<PatientForm, String>) patientForm).save(patientform);
//		        return ResponseEntity.ok(updatePatientDetails);
//		    }
//    }
	
//	@PutMapping("/patient-update/{phone}")
//	public ResponseEntity<PatientForm> updatePatientDetails(@PathVariable String phone,@RequestBody PatientForm patientForm){
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(new PatientForm(patientFormService.save(patientForm)));
//	}
	

//	@PutMapping("/patient-update/{phone}")  
//    public boolean updatePatientDetails(@RequestBody PatientForm patientForm,@PathVariable String phone) {  
//        patientForm.setPhone(phone);  
//        System.out.println("Patient Data is updated");
//        return patientFormService.update(patientForm);  
//    }  

//	@PutMapping
//    public String modifyPatient(@RequestBody PatientForm patientForm){
//        return patientFormService.update(patientForm);
//    }

//	@GetMapping("/patient-get/{phone}")
//	public String getPatientDetailsById(String phone) {
//		patientFormService.findAllById(phone);
//		System.out.println(phone);
//		return "Patient details by phone:";
//	}

	// http://localhost:8082/api/patient-get/7878787878

//	@GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
//        throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        return ResponseEntity.ok().body(employee);
//    }
//	


