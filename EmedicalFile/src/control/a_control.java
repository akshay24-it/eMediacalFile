package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.a_dao;
import DAO.d_dao;
import DAO.r_dao;
import VO.appoinment;
import VO.doctor;
import VO.e_reg;

/**
 * Servlet implementation class a_control
 */
@WebServlet("/a_control")
public class a_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public a_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("addappoinment")){
			int id=Integer.parseInt(request.getParameter("id"));
			fetchdoctor(request,response);
			HttpSession s=request.getSession();
			s.setAttribute("uid", id);
			response.sendRedirect("insertappoinment.jsp");
		}
		else if(flag.equals("clinic")){
			clinic(request,response);
			response.sendRedirect("dJSON.jsp");
		}
		else if(flag.equals("showappoinmnet")){
			showappoinment(request,response);
			response.sendRedirect("showappoinment.jsp");
		}
		else if(flag.equals("editappoinment")){
			editappoinment(request,response);
			response.sendRedirect("editappoinment.jsp");
		}
		else if(flag.equals("deleteappoinment")){
			deleteappoinment(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void deleteappoinment(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		appoinment a=new appoinment();
		a.setId(id);
		
		a_dao a1=new a_dao();
		a1.deleteappoinmnet(a);
	}

	private void editappoinment(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		appoinment d=new appoinment();
		d.setId(id);
		
		a_dao d1=new a_dao();
		List<appoinment> ls=d1.editdoctor(d);
		HttpSession s=request.getSession();
		s.setAttribute("edita",ls);
		
	
		int rid=Integer.parseInt(request.getParameter("rid"));	
		e_reg e=new e_reg();
		e.setId(rid);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		doctor d3=new doctor();
		d3.setR_id(obj);
		
		d_dao d2=new d_dao();
		List<doctor> doc=d2.showdoctor(d3);
		
		HttpSession s1=request.getSession();
		s1.setAttribute("doctor",doc);
		
		
	}

	private void showappoinment(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		appoinment a=new appoinment();
		a.setR_id(obj);
		
		a_dao d=new a_dao();
		List<appoinment> ls=d.showappoinment(a);
		
		HttpSession s=request.getSession();
		s.setAttribute("showp",ls);
	}

	private void clinic(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int did=Integer.parseInt(request.getParameter("doc"));
		doctor d=new doctor();
		d.setId(did);

		d_dao d1=new d_dao();
		doctor doc=d1.fetchdoctor(d);

		HttpSession s1=request.getSession();
		s1.setAttribute("dd",doc);
	}

	private void fetchdoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		doctor d=new doctor();
		d.setR_id(obj);
		
		d_dao d1=new d_dao();
		List<doctor> doc=d1.showdoctor(d);
		
		HttpSession s1=request.getSession();
		s1.setAttribute("doctor",doc);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertappoinment")){
			insertappoinment(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("updateappoinment")){
			updateappoinment(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void updateappoinment(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("rid"));
		int id=Integer.parseInt(request.getParameter("uid"));
			
			String dname=request.getParameter("doctor");
			
			String a_name=request.getParameter("appoinment");
			String date=request.getParameter("date");
			String time=request.getParameter("time");
			//System.out.println(time);
			
			DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			LocalDate date1=LocalDate.parse(date,f);
			java.sql.Date date2=java.sql.Date.valueOf(date1);
			
			DateTimeFormatter f1=DateTimeFormatter.ofPattern("H:mm", Locale.ENGLISH);
			LocalTime time1=LocalTime.parse(time,f1);
			java.sql.Time time2=java.sql.Time.valueOf(time1);
			
			e_reg e=new e_reg();
			e.setId(rid);
			r_dao r=new r_dao();
			e_reg obj=r.getobj(e);
		
			
			appoinment a=new appoinment();
			a.setA_name(a_name);
			a.setDate(date2);
			a.setDoctor(dname);
			a.setR_id(obj);
			a.setTime(time2);
			a.setId(id);
			
			a_dao a1=new a_dao();
			a1.updateappoinment(a);
			
	}

	private void insertappoinment(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("uid"));
	
		
		String dname=request.getParameter("doctor");
		
		String a_name=request.getParameter("appoinment");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		//System.out.println(time);
		
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date1=LocalDate.parse(date,f);
		java.sql.Date date2=java.sql.Date.valueOf(date1);
		
		DateTimeFormatter f1=DateTimeFormatter.ofPattern("H:mm", Locale.ENGLISH);
		LocalTime time1=LocalTime.parse(time,f1);
		java.sql.Time time2=java.sql.Time.valueOf(time1);
		
		e_reg e=new e_reg();
		e.setId(rid);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
	
		
		appoinment a=new appoinment();
		a.setA_name(a_name);
		a.setDate(date2);
		a.setDoctor(dname);
		a.setR_id(obj);
		a.setTime(time2);
		
		a_dao a1=new a_dao();
		a1.insertappoinment(a);
	}

}
