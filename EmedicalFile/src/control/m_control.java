package control;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.m_dao;
import DAO.r_dao;
import VO.current_growth;
import VO.e_reg;
import VO.m_info;
import VO.pre_growth;

/**
 * Servlet implementation class m_control
 */
@WebServlet("/m_control")
public class m_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public m_control() {
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
		
		if(flag.equals("showminfo")){
			showminfo(request,response);
			response.sendRedirect("showmedicalinfo.jsp");
		}
		else if(flag.equals("editminfo")){
			editminfo(request,response);
			response.sendRedirect("editminfo.jsp");
		}
		else if(flag.equals("current")){
			current(request,response);
			response.sendRedirect("showcgrowth.jsp");
		}
		else if(flag.equals("pre")){
			pre(request,response);
			response.sendRedirect("showpgrowth.jsp");
		}
	}
	
	private void pre(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		pre_growth p=new pre_growth();
		p.setId(id);
		
		m_dao m=new m_dao();
		List<pre_growth> ls=m.fetchpgrowth(p);
		HttpSession s=request.getSession();
		s.setAttribute("pre",ls);
	}

	private void current(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		current_growth c=new current_growth();
		c.setId(id);
		
		m_dao m=new m_dao();
		List<current_growth> ls=m.fetchcgrowth(c);
		HttpSession s=request.getSession();
		s.setAttribute("current",ls);
		
		
	}

private void editminfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
	
		m_info m = new m_info();
		m.setM_id(id);
		
		m_dao d=new m_dao();
		List<m_info> ls=d.showminfo(m);
		
		HttpSession s=request.getSession();
		s.setAttribute("editminfo",ls);
		
	}

private void showminfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		
		m_info i1=new m_info();
		i1.setM_id(id);
		
		m_dao j=new m_dao();
		List<m_info> l=j.showminfo(i1);
		HttpSession s=request.getSession();
		s.setAttribute("minfolist",l);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("updateminfo")){
			updateminfo(request,response);
			response.sendRedirect("dashboard.jsp");
		}
		
	}

	

	private void updateminfo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int r_id=Integer.parseInt(request.getParameter("uid"));
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
		
		e_reg e=new e_reg();
		e.setId(r_id);
		r_dao r=new r_dao();
		e_reg obj=r.getobj(e);
		
	
		
		m_info m=new m_info();
		m.setM_id(r_id);
		m.setAllergy(allergy);
		m.setAsthama(asthama);
		m.setBlood_group(bloodgroup);
		m.setDiabetes(diabetes);
		m.setDisability(disability);
		m.setHeight(height);
		m.setWeight(weight);
		m.setHypertention(hypertention);
		m.setR_id(obj);
		m.setSugar_level(sugar_level);
		m.setB_p(bp);
		
		
		m_dao f=new m_dao();
		current_growth c=new current_growth();
		c.setId(r_id);

		List<current_growth> l1=f.fetchcgrowth(c);
		
		
		pre_growth p=new pre_growth();
	
		for (current_growth current_growth : l1) {
			p.setId(current_growth.getId());
			p.setR_id(current_growth.getR_id());
			p.setBloodpressure(current_growth.getBloodpressure());
			p.setHeight(current_growth.getHeight());
			p.setWeight(current_growth.getWeight());
			p.setSugar(current_growth.getSugar());
		}
		
		
		f.updatepgrowth(p);
		
		current_growth c1=new current_growth();
		c1.setBloodpressure(bp);
		c1.setHeight(height);
		c1.setId(r_id);
		c1.setR_id(obj);
		c1.setSugar(sugar_level);
		c1.setWeight(weight);
		
		f.updateminfo(m);
		f.updatecgrowth(c1);
		
	}


	
}
