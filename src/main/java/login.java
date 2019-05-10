package main.java;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class second
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();        
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("squid:S4784")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		
		String strRegEx = ".+";
        
        if(user.matches(strRegEx)){
            System.out.println(user + " is valid");
        }else{
            System.out.println(user + " is not valid");
        }
		
		if (LoginCase.insertUser(user, pass, email) == true) {
			responseWeb(response, "login ok");
		} else {
			responseWeb(response, "invalid login");
		}
	
	}
	private void responseWeb(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head/><body>");
		out.println("<t1>" + msg + "</t1>");		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
