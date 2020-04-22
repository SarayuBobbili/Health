package com.cg.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="appointment1")
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	@Column
	private LocalDateTime datetime;
	@Column
	private boolean approved;
	
    @ManyToOne
  	private Test test;
	
	@ManyToOne
	private DiagnosticCenter center;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
//	public Appointment(User user, DiagnosticCenter center, Test test, LocalDateTime datetime) 
//	{
//		super();
//		this.datetime = datetime;
//		this.test = test;
//		this.center = center;
//		this.user = user;
//	}
//	
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	} 
	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
