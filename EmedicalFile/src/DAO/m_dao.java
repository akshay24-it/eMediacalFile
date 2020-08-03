package DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.current_growth;
import VO.m_info;
import VO.pre_growth;

public class m_dao {
	
	public void m_insert(m_info a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();
	
	}
	
	public void pre_g_insert(pre_growth a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();

	}
	
	public void current_g_insert(current_growth a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(a);
		t.commit();
		s.close();

	}
	

	
	public List<m_info> showminfo(m_info a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from m_info where m_id='"+a.getM_id()+"'");
		@SuppressWarnings("unchecked")
		List<m_info> m=q.list();
		t.commit();
		s.close();
		return m;
	}
	
	public List<current_growth> fetchcgrowth(current_growth a){
		
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from current_growth where id='"+a.getId()+"'");
		@SuppressWarnings("unchecked")
		List<current_growth> m=q.list();
		t.commit();
		s.close();
		return m;
		
		
	}
	
	public void updatepgrowth(pre_growth a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	}
	
	public void updateminfo(m_info a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	}
	
	public void updatecgrowth(current_growth a){
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		s.close();
	}

	public List<pre_growth> fetchpgrowth(pre_growth p) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from pre_growth where id='"+p.getId()+"'");
		@SuppressWarnings("unchecked")
		List<pre_growth> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	

}


