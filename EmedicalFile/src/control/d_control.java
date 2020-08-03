package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.d_dao;
import DAO.r_dao;
import VO.doctor;
import VO.e_reg;

/**
 * Servlet implementation class d_control
 */
@WebServlet("/d_control")
public class d_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d_control() {
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
		
		if(flag.equals("adddoctor")){
			int uid=Integer.parseInt(request.getParameter("id"));
			HttpSession s=request.getSession();
			s.setAttribute("uid", uid);
			response.sendRedirect("insertdoctor.jsp");
		}
		else if(flag.equals("showdoctor")){
			showdoctor(request,response);
			response.sendRedirect("showdoctor.jsp");
		}
		else if(flag.equals("deletedoctor")){
			deletedoctor(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("editdoctor")){
			editdoctor(request,response);
			response.sendRedirect("updatedoctor.jsp");
		}
	}

	

	private void editdoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		doctor d=new doctor();
		d.setId(id);
		
		d_dao d1=new d_dao();
		List<doctor> ls=d1.editdoctor(d);
		HttpSession s=request.getSession();
		s.setAttribute("editd",ls);
	}

	private void deletedoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		doctor d=new doctor();
		d.setId(id);
		
		d_dao d1=new d_dao();
		d1.deletedoctor(d);
	}

	private void showdoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("id"));
		
		e_reg e=new e_reg();
		e.setId(uid);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		doctor d=new doctor();
		d.setR_id(obj);
		
		//System.out.println(obj.getLastname());
		
		d_dao d1=new d_dao();
		List<doctor> ls1=d1.showdoctor(d);
		System.out.println(ls1.size());
		HttpSession s=request.getSession();
		s.setAttribute("doctor",ls1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertdoctor")){
			insertdoctor(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("updatedoctor")){
			updatedoctor(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void updatedoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
				e_reg e=new e_reg();
				e.setId(rid);
				r_dao r=new r_dao();
				e_reg obj=r.getobj(e);
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String degree=request.getParameter("degree");
		String specialist=request.getParameter("specialist");
		int exp=Integer.parseInt(request.getParameter("exp"));
		String clinic=request.getParameter("clinic");
		
		doctor d=new doctor();
		d.setId(id);
		d.setAddress(address);
		d.setDegree(degree);
		d.setEmail(email);
		d.setExperience(exp);
		d.setFn(fn);
		d.setGender(gender);
		d.setLn(ln);
		d.setMob(mob);
		d.setR_id(obj);
		d.setSpecialist(specialist);
		d.setClinic(clinic);
		
		d_dao d1=new d_dao();
		d1.updatedoctor(d);
	}

	private void insertdoctor(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String degree=request.getParameter("degree");
		String specialist=request.getParameter("specialist");
		int exp=Integer.parseInt(request.getParameter("exp"));
		String clinic =request.getParameter("clinic");
		
		doctor d=new doctor();
		d.setAddress(address);
		d.setDegree(degree);
		d.setEmail(email);
		d.setExperience(exp);
		d.setFn(fn);
		d.setGender(gender);
		d.setLn(ln);
		d.setMob(mob);
		d.setR_id(obj);
		d.setSpecialist(specialist);
		d.setClinic(clinic);
		
		d_dao d1=new d_dao();
		d1.insertdoctor(d);
		
		
		
	}

}
