package com.cg.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.AppointmentDaoI;
import com.cg.entity.Appointment;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.Test;
import com.cg.entity.User;

@Service
public class AppointmentService implements AppointmentServiceI {
	
	@Autowired
	AppointmentDaoI appdao;


	@Override
	public int makeAppointment(User user, DiagnosticCenter center, Test test, LocalDateTime datetime) {
		return appdao.makeAppointment(user, center, test, datetime);
	}
	
	@Override
	public List viewAppointmentDetails() {
		return appdao.viewAppointmentDetails();
	}

	
	@Override
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) {
		
		return appdao.findByTestName(diagnosticCenter, testName);
	}

	public DiagnosticCenter findByCenterName(String centerName) {
		
		return appdao.findByCenterName(centerName);
	}

	public User findByUserId(int userId) {
		
		return appdao.findByUserId(userId);
	}
}
