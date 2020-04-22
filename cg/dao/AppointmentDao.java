package com.cg.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Appointment;
import com.cg.entity.DiagnosticCenter;
import com.cg.entity.Test;
import com.cg.entity.User;

@Transactional
@Repository
public class AppointmentDao implements AppointmentDaoI{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	Appointment appointment;
	
	@Override
	public int  makeAppointment(User user, DiagnosticCenter center, Test test, LocalDateTime datetime) 
	{
		
		appointment.setUser(user);
		appointment.setCenter(center);
		appointment.setTest(test);;
		appointment.setDatetime(datetime);
		entityManager.persist(appointment);
		center.getAppointmentList().add(appointment);
		return appointment.getAppointmentId(); 
	}

	@Override
	public List viewAppointmentDetails() {
		Query q=entityManager.createQuery("from Appointment a");
		return q.getResultList();
	}

	@Override
	public Test findByTestName(DiagnosticCenter diagnosticCenter, String testName) 
	{
		
		Test test = diagnosticCenter.getListOfTests().stream().filter(t->testName.equals(t.getTestName())).findFirst().get();
		return test;
	}
	public DiagnosticCenter findByCenterName(String centerName)
	{
		String queryStr = "select center from DiagnosticCenter center where center.centerName=:centerName";
		TypedQuery<DiagnosticCenter> query = entityManager.createQuery(queryStr,DiagnosticCenter.class);
		DiagnosticCenter diagnosticCenter = query.setParameter("centerName", centerName).getSingleResult();
		return diagnosticCenter;
	}
	public User findByUserId(int userId)
	{
		String queryStr = "select users from User users where users.userId=:userId";
		TypedQuery<User> query = entityManager.createQuery(queryStr,User.class);
		User user = query.setParameter("userId", userId).getSingleResult();
		return user;
	}

}
