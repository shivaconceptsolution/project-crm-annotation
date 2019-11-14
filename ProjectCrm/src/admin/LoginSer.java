package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.HiberHelper;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HiberHelper.configure();
		String query="";
		String page="";
		if(request.getParameter("ddlrole").equals("admin"))
		{
			query="from AdminLogin s where username=:a and password=:b";
			page= "AdminDash/index.jsp";
		}
		else if(request.getParameter("ddlrole").equals("ProjectManager"))
		{
			query="from Employee s where username=:a and password=:b and designation=:c";
			page= "PMDash/index.jsp";
			
		}
		else if(request.getParameter("ddlrole").equals("Developer"))
		{
			query="from Employee s where username=:a and password=:b and designation=:c";
			page= "EmployeeDash/index.jsp";
		}
		Query q = HiberHelper.dqlOperation(query);
		
		q.setString("a",request.getParameter("txtuser"));
		q.setString("b",request.getParameter("txtpass"));
		if(!request.getParameter("ddlrole").equals("admin")) {
		q.setString("c",request.getParameter("ddlrole"));
			
		}
		List lst = q.list();
		if(lst.size()>0) {
			HttpSession session=request.getSession();
			session.setAttribute("adminusername",request.getParameter("txtuser"));
			response.sendRedirect(page);
		}
		else
		{
			response.sendRedirect("login.jsp?error=invalid userid and password");
		}
		
		HiberHelper.closeConn();
		
	}

}
