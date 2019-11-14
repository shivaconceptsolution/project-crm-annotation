package stu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.Student;
import dao.HiberHelper;
/**
 * Servlet implementation class StudentSer
 */
@WebServlet("/StudentSer")
public class StudentSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSer() {
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
		PrintWriter out = response.getWriter();
		//Configuration cfg = new Configuration();
		//cfg.configure("hibernate.cfg.xml");
		//SessionFactory sf = cfg.buildSessionFactory();
		//Session s = sf.openSession();
		//Query q = s.createQuery("from Student s where s.rno=:a");
		HiberHelper.configure();
		Query q = HiberHelper.dqlOperation("from Student s where s.rno=:a");
		q.setInteger("a",Integer.parseInt( request.getParameter("txtrno")));
		List lst = q.list();
		if(lst.size()==0)
		{	
			
	//	Transaction tx = s.beginTransaction();
		Student stu = new Student();
		stu.setRno(Integer.parseInt( request.getParameter("txtrno")));
		stu.setSname(request.getParameter("txtsname"));
		stu.setBranch(request.getParameter("txtbranch"));
		stu.setFees(Integer.parseInt( request.getParameter("txtfees")));
	    HiberHelper.dmlInsert(stu);
		//  s.save(stu);
	   // tx.commit();
	   // s.close();
	    
	    
		//out.write("Data inserted");
	    RequestDispatcher req= request.getRequestDispatcher("ViewStudent.jsp");
	    req.forward(request, response);
		}
		
		else
		{
			RequestDispatcher req= request.getRequestDispatcher("index.jsp");
			request.setAttribute("error", "rno already exist");
		    req.forward(request, response);
		}
		
		
		
	}

}
