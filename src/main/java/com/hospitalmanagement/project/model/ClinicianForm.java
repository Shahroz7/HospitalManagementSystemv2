package com.hospitalmanagement.project.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ClinicianTable")
public class ClinicianForm {
	
	private String clinicianId;
	private String fullname;
	private String age;
    private String gender;
    private String email;
    private String phone;
    private String specialization;
    private String experience;
    private String address;
    private String availability;
	
    public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public String getClinicianId() {
		return clinicianId;
	}
	public void setClinicianId(String clinicianId) {
		this.clinicianId = clinicianId;
	}
	
	
	public ClinicianForm () {
		
	}
	
	public ClinicianForm(String clinicianId, String fullname, String age, String gender, String email, String phone,
			String specialization, String experience, String address, String availability) {
		super();
		this.clinicianId = clinicianId;
		this.fullname = fullname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.specialization = specialization;
		this.experience = experience;
		this.address = address;
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "ClinicianForm [clinicianId=" + clinicianId + ", fullname=" + fullname + ", age=" + age + ", gender="
				+ gender + ", email=" + email + ", phone=" + phone + ", specialization=" + specialization
				+ ", experience=" + experience + ", address=" + address + ", availability=" + availability + "]";
	}
    

}
