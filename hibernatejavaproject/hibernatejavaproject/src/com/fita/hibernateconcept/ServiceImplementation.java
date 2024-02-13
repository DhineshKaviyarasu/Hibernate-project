package com.fita.hibernateconcept;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class ServiceImplementation {
	
	void insert()  {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fac=cfg.buildSessionFactory();
		Session session= fac.openSession();
		Transaction transaction=session.beginTransaction();
		EmpEntity emp=new EmpEntity();
		emp.setId(2);
		emp.setName("Dhinesh");
		emp.setSalary(20000);
		Address address=new Address("Chennai","Anna nagar","600001");
		emp.setAddress(address);
		session.save(emp);
		transaction.commit();
		System.out.println("Saved sucessfully.");
		fac.close();
		session.close();

	}
	
	void retrive() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fac = cfg.buildSessionFactory();
		Session session = fac.openSession();
		Criteria cr=session.createCriteria(EmpEntity.class);
		cr.add(Restrictions.gt("salary",9000)).add(Restrictions.eq("gender","Female"));

		List<EmpEntity> empEntities=cr.list();

//		for (EmpEntity emp : empEntities) {
//			System.out.println("Name: " + emp.getName()
//					+ ", Salary: " + emp.getSalary() + ", Gender: " + emp.getGender());
//		}
		fac.close();
		session.close();
	}
	
	void delete() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		Transaction trans =session.beginTransaction() ;
		EmpEntity emps = session.get(EmpEntity.class, new Integer(69));
		session.delete(emps);
		trans.commit();
		System.out.println("deleted sucessfully");
		
		session.close();
		fact.close();
		
	}
	
	void update() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		Transaction trans =session.beginTransaction() ;
		EmpEntity emps = session.get(EmpEntity.class, new Integer(71));
		emps.setSalary(9000);
		trans.commit();
		System.out.println("Data updated");
		session.close();
		fact.close();
		
		
	}
	void bulkRetrive() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();
		Query ref = session.createQuery("from EmpEntity e");
		List< EmpEntity> al = ref.list();
		for(EmpEntity emps : al) {
			System.out.println(emps);
		}
		
	}
	public static void main(String[] args) {
		ServiceImplementation service = new ServiceImplementation();
		service.insert();
		//service.retrive();
		//service.delete();
		//service.update();
		//service.bulkRetrive();
	}

}
