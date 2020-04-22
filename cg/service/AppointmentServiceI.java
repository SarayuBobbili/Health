package com.cg.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Appointment;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.Test;
import com.cg.entity.User;

public interface AppointmentServiceI {
	
	public int makeAppointment(User user,DiagnosticCenter center, Test test ,LocalDateTime datetime);
	public List viewAppointmentDetails();
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName);
	public DiagnosticCenter findByCenterName(String centerName);
	public User findByUserId(int userId);

}
