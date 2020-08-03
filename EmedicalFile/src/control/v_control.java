package control;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.r_dao;
import DAO.v_dao;
import VO.e_reg;
import VO.vaccine;

/**
 * Servlet implementation class v_control
 */
@WebServlet("/v_control")
public class v_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public v_control() {
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
		
		if(flag.equals("addvaccine")){
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession s=request.getSession();
			s.setAttribute("vaccine",id);
			response.sendRedirect("insertvaccine.jsp");
		}
		else if(flag.equals("showvaccine")){
			showvaccine(request,response);
			response.sendRedirect("showvaccine.jsp");
		}
		else if(flag.equals("editvaccine")){
			editvaccine(request,response);
			response.sendRedirect("updatevaccine.jsp");
		}
		else if(flag.equals("deletevaccine")){
			deletevaccine(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		
	}

	private void deletevaccine(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		vaccine v=new vaccine();
		v.setId(id);
		
		v_dao d=new v_dao();
		d.deletevaccine(v);
	}

	private void editvaccine(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		vaccine c=new vaccine();
		c.setId(id);
		
		v_dao d=new v_dao();
		List<vaccine> v=d.fetchvaccine(c);
		
		HttpSession s=request.getSession();
		s.setAttribute("editv",v);
	}

	private void showvaccine(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		vaccine c=new vaccine();
		c.setR_id(obj);
		
		v_dao d=new v_dao();
		List<vaccine> li=d.showvaccine(c);
		
		HttpSession s=request.getSession();
		s.setAttribute("showv",li);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertvaccine")){
			insertvaccine(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("updatevaccine")){
			updatevaccine(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void updatevaccine(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("rid"));
		int id=Integer.parseInt(request.getParameter("uid"));
		System.out.println("a");
		e_reg e=new e_reg();
		e.setId(rid);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		System.out.println("b");
		String vname=request.getParameter("vaccine");
		String disease=request.getParameter("disease");
		String date=request.getParameter("date");
		String d_date=request.getParameter("d_date");
		System.out.println("c");
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date1=LocalDate.parse(date,f);
		java.sql.Date date2=java.sql.Date.valueOf(date1);
		
		System.out.println("d");
		DateTimeFormatter f1=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate d_date1=LocalDate.parse(d_date,f1);
		java.sql.Date d_date2=java.sql.Date.valueOf(d_date1);
		
		vaccine v=new vaccine();
		v.setD_date(d_date2);
		v.setDate(date2);
		v.setDisease(disease);
		v.setR_id(obj);
		v.setVname(vname);
		v.setId(id);
		
		v_dao d=new v_dao();
		d.updatevaccine(v);
	}

	private void insertvaccine(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		String vname=request.getParameter("vaccine");
		String disease=request.getParameter("disease");
		String date=request.getParameter("date");
		String d_date=request.getParameter("d_date");
		
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date1=LocalDate.parse(date,f);
		java.sql.Date date2=java.sql.Date.valueOf(date1);
		
		
		DateTimeFormatter f1=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate d_date1=LocalDate.parse(d_date,f1);
		java.sql.Date d_date2=java.sql.Date.valueOf(d_date1);
		
		vaccine v=new vaccine();
		v.setD_date(d_date2);
		v.setDate(date2);
		v.setDisease(disease);
		v.setR_id(obj);
		v.setVname(vname);
		
		v_dao d=new v_dao();
		d.insertvaccine(v);
	}

}
