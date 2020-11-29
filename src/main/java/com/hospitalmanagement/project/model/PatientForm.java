package com.hospitalmanagement.project.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PatientTable")
public class PatientForm {

	private String patientId;
	private String fullname;
	private String age;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String appointment;
	
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
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	
	public PatientForm(String patientId, String fullname, String age, String gender, String email, String phone,
			String address, String appointment) {
		super();
		this.patientId = patientId;
		this.fullname = fullname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.appointment = appointment;
	}
	public PatientForm() {
		
	}
	
	@Override
	public String toString() {
		return "PatientForm [patientId=" + patientId + ", fullname=" + fullname + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", appointment=" + appointment
				+ "]";
	}
	
}
