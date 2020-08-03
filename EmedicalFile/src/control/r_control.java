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

import DAO.f_dao;
import DAO.m_dao;
import DAO.r_dao;
import VO.current_growth;
import VO.e_reg;
import VO.e_user;
import VO.fpass;
import VO.m_info;
import VO.pre_growth;

/**
 * Servlet implementation class r_control
 */
@WebServlet("/r_control")
public class r_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public r_control() {
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
		if(flag.equals("showprofile")){
			showprofile(request,response);
			response.sendRedirect("showprofile.jsp");
		}
		else if(flag.equals("editprofile")){
			editprofile(request,response);
			response.sendRedirect("editprofile.jsp");
		}
		else if(flag.equals("changepass")){
			changepass(request,response);
			response.sendRedirect("changepassword.jsp");
			
		}
	}



	private void changepass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int r_id=Integer.parseInt(request.getParameter("id"));
		HttpSession s=request.getSession();
		s.setAttribute("cpassid",r_id);
	}

	private void editprofile(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("id"));
		e_reg e=new e_reg();
		e.setId(uid);
		
		r_dao r=new r_dao();
		List<e_reg> ls=r.showprofile(e);
		
		HttpSession s=request.getSession();
		s.setAttribute("listprofile",ls);
	}

	private void showprofile(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("id"));
		e_reg e=new e_reg();
		e.setId(uid);
		
		r_dao r=new r_dao();
		List<e_reg> ls=r.showprofile(e);
		
		HttpSession s=request.getSession();
		s.setAttribute("listprofile",ls);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		if(flag.equals("reg")){
			
				insert_reg(request,response);
			
			response.sendRedirect("home.jsp");
			
		}
		else if(flag.equals("login")){
			List<e_user> a=login(request,response);
			if(!a.isEmpty()){
				response.sendRedirect("dashboard.jsp");
			}else{
				HttpSession s=request.getSession();
				s.setAttribute("w","Wrong username and password");
				response.sendRedirect("e_login.jsp");
			}
		}
		else if(flag.equals("updateprofile")){
			updateprofile(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		else if(flag.equals("updatepass")){
			boolean b=updatepass(request,response);
			if(b){
				response.sendRedirect("home.jsp");
			}
			else{
				HttpSession s=request.getSession();
				s.setAttribute("wp","please enter valid password");
				response.sendRedirect("changepassword.jsp");
			}
			
		}
	
	}

	

	private boolean updatepass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(request.getParameter("id"));
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		
		e_user u=new e_user();
		u.setUid(uid);
		u.setPassword(opass);
		
		r_dao d=new r_dao();
		List<e_user> b=d.fetchpass(u);
		
		String un = null;
		e_reg reg = null;
		
		for (e_user e_user : b) {
			un=e_user.getUsername();
			reg=e_user.getRid();
		}
		boolean boo=false;
		if(npass.equals(cpass) && !b.isEmpty()){
			e_user p=new e_user();
			p.setPassword(cpass);
			p.setUid(uid);
			p.setUsername(un);
			p.setRid(reg);
			r_dao q=new r_dao();
			q.updatepass(p);
			boo=true;
		}
		
		return boo;
		
	}

	private void updateprofile(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String dob=request.getParameter("dob");
		
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date=LocalDate.parse(dob,f);
		System.out.println(date);
		java.sql.Date d=java.sql.Date.valueOf(date);
		
		
		e_reg e=new e_reg();
		e.setId(id);

		e.setEmail(email);
		e.setFirstname(fn);
		e.setLastname(ln);
		e.setGender(gender);
		e.setMobileno(mobile);
		e.setDate(d);
		
		r_dao r=new r_dao();
		r.updateprofile(e);
		
		
		
	}

	private List<e_user> login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String s1=request.getParameter("user");
		String s2=request.getParameter("pass");
		
		e_user r=new e_user();
		r.setUsername(s1);
		r.setPassword(s2);
		r_dao d=new r_dao();
		List<e_user> b=d.login(r);
		
		HttpSession h=request.getSession();
		h.setAttribute("list",b);
		return b;
		
		
	}

	private void insert_reg(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String un=request.getParameter("un");
		String pw=request.getParameter("pw");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String dob=request.getParameter("dob");
		
		DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
		LocalDate date=LocalDate.parse(dob,f);
		java.sql.Date d=java.sql.Date.valueOf(date);
		
		
		float height=Float.parseFloat(request.getParameter("height"));
		float weight=Float.parseFloat(request.getParameter("weight"));
		String bloodgroup=request.getParameter("bloodgroup");
		String diabetes=request.getParameter("diabetes");
		String hypertention=request.getParameter("hypertention");
		String asthama=request.getParameter("asthama");
		String disability=request.getParameter("disability");
		String allergy=request.getParameter("allergy");
		String sugar_level=request.getParameter("sugar_level");
		String bp=request.getParameter("bp");
//		String question=request.getParameter("security");
//		String ans=request.getParameter("ans");
		

		e_reg e=new e_reg();

		e.setEmail(email);
		e.setFirstname(fn);
		e.setLastname(ln);
		e.setGender(gender);
		e.setMobileno(mobile);
		e.setDate(d);
		
		e_user u=new e_user();
		u.setUsername(un);
		u.setPassword(pw);
		u.setRid(e);
		
		
		m_info m=new m_info();
		m.setAllergy(allergy);
		m.setAsthama(asthama);
		m.setBlood_group(bloodgroup);
		m.setDiabetes(diabetes);
		m.setDisability(disability);
		m.setHeight(height);
		m.setWeight(weight);
		m.setHypertention(hypertention);
		m.setR_id(e);
		m.setSugar_level(sugar_level);
		m.setB_p(bp);
		
		pre_growth p=new pre_growth();
		p.setBloodpressure(bp);
		p.setHeight(height);
		p.setWeight(weight);
		p.setSugar(sugar_level);
		p.setR_id(e);
		
		current_growth c=new current_growth();
		c.setBloodpressure(bp);
		c.setHeight(height);
		c.setWeight(weight);
		c.setSugar(sugar_level);
		c.setR_id(e);
		
		
		r_dao a=new r_dao();
		a.insert_reg(e);
		a.insert_user(u);
		
		m_dao d1=new m_dao();
		d1.m_insert(m);
		d1.pre_g_insert(p);
		d1.current_g_insert(c);
				
//		fpass f1=new fpass();
//		f1.setQuestion(question);
//		f1.setAns(ans);
//		f1.setR_id(e);
//		f1.setEmail(email);
		
//		f_dao fd=new f_dao();
//		fd.insert(f1);
		
				
	}

}
