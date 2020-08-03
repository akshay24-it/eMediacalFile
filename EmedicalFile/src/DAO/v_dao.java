package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.vaccine;

public class v_dao {

	public void insertvaccine(vaccine v) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(v);
		t.commit();
		s.close();
	}

	public List<vaccine> showvaccine(vaccine c) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from vaccine where r_id='"+c.getR_id().getId()+"'");
		@SuppressWarnings("unchecked")
		List<vaccine> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public vaccine getobj(vaccine c) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		vaccine v=(vaccine) s.get(vaccine.class,c.getId());
		t.commit();
		s.close();
		return v;
	}

	public void updatevaccine(vaccine v) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(v);
		t.commit();
		s.close();
	}

	public List<vaccine> fetchvaccine(vaccine c) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from vaccine where id='"+c.getId()+"'");
		@SuppressWarnings("unchecked")
		List<vaccine> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public void deletevaccine(vaccine v) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.delete(v);
		t.commit();
		s.close();

	}

}
