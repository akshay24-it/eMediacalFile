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
import DAO.n_dao;
import DAO.r_dao;
import VO.e_reg;
import VO.note;

/**
 * Servlet implementation class n_control
 */
@WebServlet("/n_control")
public class n_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public n_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//.requeresponse.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		
		if(flag.equals("addnotes")){
			int uid=Integer.parseInt(request.getParameter("id"));
			HttpSession s=request.getSession();
			s.setAttribute("uid", uid);
			response.sendRedirect("insertnote.jsp");
		}
		else if(flag.equals("shownotes")){
			shownote(request,response);
			response.sendRedirect("shownote.jsp");
		}
		else if(flag.equals("deletenote")){
			deletenote(request,response);
			response.sendRedirect("dashboard.jsp");
		}
	}

	private void shownote(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		e_reg e=new e_reg();
		e.setId(id);
		
		note n=new note();
		n.setR_id(e);
		
		n_dao d=new n_dao();
		List<note> ls=d.shownote(n);
		
		HttpSession s=request.getSession();
		s.setAttribute("shown",ls);
	}


	private void deletenote(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		note n=new note();
		n.setId(id);
		
		n_dao d=new n_dao();
		d.deletenote(n);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertnote")){
			insertnote(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		
	}

	
	private void insertnote(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("uid"));
		
		e_reg e=new e_reg();
		e.setId(id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
		String d=request.getParameter("date");
		String note=request.getParameter("note");
		
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate d1=LocalDate.parse(d,f);
		java.sql.Date date=java.sql.Date.valueOf(d1);
		

		
		note n=new note();
		n.setDate(date);
		n.setNote(note);
		n.setR_id(obj);
		
		n_dao n1=new n_dao();
		n1.insertnote(n);
	}

}
