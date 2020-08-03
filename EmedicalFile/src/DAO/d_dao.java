package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.doctor;
import java.util.*;

public class d_dao {

	public void insertdoctor(doctor d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(d);
		t.commit();
		s.close();
	}

	
	public List<doctor> showdoctor(doctor d) {
		// TODO Auto-generated method stub
		System.out.println(d.getR_id().getFirstname());
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from doctor where r_id='"+d.getR_id().getId()+"'");
		@SuppressWarnings("unchecked")
		List<doctor> m=q.list();
		t.commit();
		s.close();
		return m;
	}


	public void deletedoctor(doctor d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.delete(d);
		t.commit();
		s.close();
	}


	public List<doctor> editdoctor(doctor d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from doctor where id='"+d.getId()+"'");
		@SuppressWarnings("unchecked")
		List<doctor> m=q.list();
		t.commit();
		s.close();
		return m;
		
	}


	public void updatedoctor(doctor d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(d);
		t.commit();
		s.close();
	}


	public doctor fetchdoctor(doctor d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		doctor e=(doctor)s.get(doctor.class,d.getId());
		t.commit();
		s.close();
		return e;
	}

	

	

}
