package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import VO.appoinment;



public class a_dao {

	public void insertappoinment(appoinment a) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	}

	public List<appoinment> showappoinment(appoinment a) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from appoinment where r_id='"+a.getR_id().getId()+"'");
		@SuppressWarnings("unchecked")
		List<appoinment> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public List<appoinment> editdoctor(appoinment d) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from appoinment where id='"+d.getId()+"'");
		@SuppressWarnings("unchecked")
		List<appoinment> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public void updateappoinment(appoinment a) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	}

	public void deleteappoinmnet(appoinment a) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.delete(a);
		t.commit();
		s.close();
	}

}
