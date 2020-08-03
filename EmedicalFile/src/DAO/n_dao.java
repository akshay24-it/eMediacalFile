package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import VO.note;

public class n_dao {

	public void insertnote(note n) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(n);
		t.commit();
		s.close();
	}

	public List<note> shownote(note n) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		org.hibernate.Query q=s.createQuery("from note where r_id='"+n.getR_id().getId()+"'");
		@SuppressWarnings("unchecked")
		List<note> m=q.list();
		t.commit();
		s.close();
		return m;
	}

	public void deletenote(note n) {
		// TODO Auto-generated method stub
		SessionFactory factory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.delete(n);
		t.commit();
		s.close();
	}

}
