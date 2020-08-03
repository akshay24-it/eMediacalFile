package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.r_dao;
import DAO.s_dao;
import VO.e_reg;
import VO.store;

/**
 * Servlet implementation class s_control
 */
@WebServlet("/s_control")
public class s_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_control() {
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
		
		if(flag.equals("addstore")){
			int uid=Integer.parseInt(request.getParameter("id"));
			HttpSession s=request.getSession();
			s.setAttribute("uid", uid);
			response.sendRedirect("insertstore.jsp");
		}
		else if(flag.equals("showstore")){
			showstore(request,response);
			response.sendRedirect("showstore.jsp");
		}
		else if(flag.equals("deletestore")){
			deletestore(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("editstore")){
			editstore(request,response);
			response.sendRedirect("updatestore.jsp");
		}
	}

	private void editstore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		store e=new store();
		e.setId(id);
		
		s_dao d=new s_dao();
		List<store> ls=d.editstore(e);
		HttpSession s=request.getSession();
		s.setAttribute("edits",ls);
	}

	private void deletestore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		store e=new store();
		e.setId(id);
		
		s_dao d=new s_dao();
		d.deletestore(e);
		
	}

	private void showstore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("id"));
		
		e_reg e=new e_reg();
		e.setId(uid);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		store s=new store();
		s.setR_id(obj);
		
		
		s_dao d1=new s_dao();
		List<store> ls1=d1.showstore(s);
		System.out.println(ls1.size());
		HttpSession s1=request.getSession();
		s1.setAttribute("store",ls1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertstore")){
			insertstore(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("updatestore")){
			updatestore(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void updatestore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
				e_reg e=new e_reg();
				e.setId(rid);
				r_dao r=new r_dao();
				e_reg obj=r.getobj(e);
		String store=request.getParameter("store");
		String on=request.getParameter("on");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String address=request.getParameter("address");
		
		store e1=new store();
		e1.setAddress(address);
		e1.setEmail(email);
		e1.setId(id);
		e1.setR_id(obj);
		e1.setMob(mob);
		e1.setOwner(on);
		e1.setStore(store);
		
		s_dao d=new s_dao();
		d.updatestore(e1);
	}

	private void insertstore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		String store=request.getParameter("store");
		String on=request.getParameter("on");
		String email=request.getParameter("email");
		String mob=request.getParameter("mob");
		String address=request.getParameter("address");
		
		store s=new store();
		s.setAddress(address);
		s.setEmail(email);
		s.setMob(mob);
		s.setOwner(on);
		s.setR_id(obj);
		s.setStore(store);
		
		s_dao d=new s_dao();
		d.insertstore(s);
		
	
	}

}
