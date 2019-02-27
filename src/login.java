

import java.io.IOException;
import java.io.PrintWriter;

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
/*	static String DRIVER="org.hsqldb.jdbcDriver";
	static String URL="jdbc:hsqldb:hsql://localhost/xdb";
	static Connection conn = null;
    /**
     * @method getConnection
     * @return the Data Base connection
     * * /
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL,"SA","");
			
		}catch(ClassNotFoundException | SQLException e) {
			System.err.println("Error: "+e);
		}
		return conn;
	}*/
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();        
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		
		if (LoginCase.insertUser(user, pass, email) == true) {
			responseWeb(response, "login ok");
		} else {
			responseWeb(response, "invalid login");
		}
	
	}
	private void responseWeb(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
