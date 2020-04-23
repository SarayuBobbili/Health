package com.cg.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.DiagnosticCenter;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentservice;
	

	@PostMapping(value="HealthCareSystem/users/make-appointment/{userId}/{centerName}/{testName}/{dateTimeStr}")
	public int makeAppointment(@PathVariable int userId,@PathVariable String centerName ,@PathVariable String testName,@PathVariable String dateTimeStr)
	{
		User user =appointmentservice.findByUserId(userId);
		DiagnosticCenter diagnosticCenter =appointmentservice.findByCenterName(centerName);
		Test test=appointmentservice.findByTestName(diagnosticCenter, testName);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

		//LocalDateTime datetime= LocalDateTime.parse(dateTime);
		appointmentservice.makeAppointment(user, diagnosticCenter, test, dateTime);
		return 1;
	} 

