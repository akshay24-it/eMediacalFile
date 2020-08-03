package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import VO.e_reg;
import VO.e_user;

public class r_dao {
	
	public void insert_reg(e_reg a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	
	}
	
	public void insert_user(e_user a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	
	}
	
	
	public List<e_user> login(e_user a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from e_user where username='"+a.getUsername()+"' and password='"+a.getPassword()+"' ");
		@SuppressWarnings("unchecked")
		List<e_user> l=q.list();
		t.commit();
		s.close();
		return l;
	}
	
	public List<e_reg> showprofile(e_reg a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from e_reg where id='"+a.getId()+"'");
		@SuppressWarnings("unchecked")
		List<e_reg> l=q.list();
		t.commit();
		s.close();
		return l;
	}
	
	public void updateprofile(e_reg a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	
	}
	
	public List<e_user> fetchpass(e_user a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from e_user where uid='"+a.getUid()+"'");
		@SuppressWarnings("unchecked")
		List<e_user> l=q.list();
		t.commit();
		s.close();
		
		return l;
	}
	
	public void updatepass(e_user a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	
	}
	
	public e_reg getobj(e_reg a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		e_reg e=(e_reg)s.get(e_reg.class,a.getId());
		t.commit();
		s.close();
		return e;
	}
	
	
	
	
}
