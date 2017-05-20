
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		PrintWriter pw= response.getWriter();
		pw.append("username="+uname+" and password"+password);
		HttpSession hs=request.getSession();
		hs.setAttribute("dept", "ece");
		ServletContext sc=request.getServletContext();
		ServletContext scc=request.getServletContext();
		request.setAttribute("req1","req1attr");
		scc.setAttribute("sc1","valuesss1");
		scc.setAttribute("scc1","valueccc1");
		sc.setAttribute("sc1","valuesc1");
		sc.setAttribute("sc2","valuesc2");
		Object o;
	if(uname.equalsIgnoreCase("Pandey"))
		{
		response.sendError(123,"<B>LOGGING IN NOT ALLOWED FOR PANDEY</B>");
		}
		else
		{
			
			String path="Welcome.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(path);
			pw.append("Passing to Welcome.jsp");
			pw.println("Passing to to to to ot o");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Random rand = new Random();

		PrintWriter pw=response.getWriter();
		Integer rando  =rand.nextInt((1000 - 23) + 1) + 23;
		Integer ref  =rand.nextInt((5000 - 2000) + 1) + 2000;
		pw.println(rando+"dsssss");
		String rr=rando.toString();
		String reff=ref.toString();

		pw.println("data1");
		String	str="ifsc=";
		str=str+request.getParameter("ifsc");
		str=str+"|acno="+request.getParameter("acno");
		str=str+"|amnt="+request.getParameter("amount");
		str=str+"|merchant_transaction_ref="+rr;
		str=str+"|data="+request.getParameter("date");
		str=str+"|ref="+reff;
		pw.println(str);
		HelloWorld sd=new HelloWorld();
		String key="605bd70efed2c6374823b54bbc560b58";
		String resp=null;
		try {
			resp=sd.encrypt(str, key);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught while calling encryptor");
			pw.flush();
			pw.println("Some error occured.Sorry");
		}
		String path="checkit.java";
		request.setAttribute("rsp", resp);
		response.sendRedirect("/mysample/checkit");
	//	RequestDispatcher rd=request.getRequestDispatcher(path);
	//	rd.forward(request, response);
	}


}
