package com.cg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="center1")
public class DiagnosticCenter {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int centerId;
	
	@Column(nullable=false)
	private String centerName;
	
	@Column(nullable=false)
	private long contactNumber;
	
	@Column(nullable=false)
	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="centerId")	
	private List<Test> listOfTests;
	

	@OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
	List<Appointment>appointmentList;
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Test> getListOfTests() 
	{
		return listOfTests;
	}

	public void setListOfTests(List<Test> listOfTests) {
		this.listOfTests = listOfTests;
	}

}
