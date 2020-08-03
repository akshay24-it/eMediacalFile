package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.store;

public class s_dao {

	public void insertstore(store e) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(e);
		t.commit();
		s.close();
	}

	public List<store> showstore(store a) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from store where r_id='"+a.getR_id().getId()+"'");
		@SuppressWarnings("unchecked")
		List<store> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public void deletestore(store e) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.delete(e);
		t.commit();
		s.close();
	}

	public List<store> editstore(store e) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from store where id='"+e.getId()+"'");
		@SuppressWarnings("unchecked")
		List<store> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public void updatestore(store e1) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(e1);
		t.commit();
		s.close();
	}

}
