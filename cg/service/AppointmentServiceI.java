package com.cg.service;

import com.cg.entity.Appointment;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;

public interface AppointmentServiceI {
	
	  public String addCenter(DiagnosticCenter diagnosticCenter);
		
			public DiagnosticCenter findByCenterName(String centerName) throws ResourceNotFoundException;
			
			public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) throws ResourceNotFoundException;
			
			public boolean isCenterNameExist(String centerName);
			
			public String createUser(User user);

			public User findByUserId(int userId);
			
			public String makeAppointment(Appointment appointment);
			
			public Appointment findByAppointmentId(int appointmentId);

			public String viewAppointment(int userId);
}
