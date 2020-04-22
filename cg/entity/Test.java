package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="test1")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	
	@Column(nullable = false)
	private String testName;
	
	@OneToMany(mappedBy = "test",cascade = CascadeType.ALL)
	List<Appointment>appointmentList;
	

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

    
}
