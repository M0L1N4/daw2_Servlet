

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @class UserValidation.java
 * 
 * Class to control the session user in the application
 */
@WebServlet(description = "User web validation", urlPatterns = { "/UserValidation" })
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession uSESSION;

    public HttpSession getUserSession() {
    	return uSESSION;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");  
		try {
			PrintWriter out = response.getWriter();  

			String uName=request.getParameter("userName");
			
			//COMPROVEM QUE L'USUARI ESTIGUI A LA BASE DE DADES, SI ÉS AIXÍ, SEGUIM AMB EL CODI DE SOTA
			
			uSESSION=request.getSession();  
			uSESSION.setAttribute("userValidatedName",uName); 

			out.println("<!DOCTYPE html><html>");
			out.println("<head><title>Benvingut</title></head>");
			out.println("<body>");
			out.println("<h1>Benvingut: " + uSESSION.getAttribute("userValidatedName") + "</h1>");		
			out.println("</body>");
			out.println("</html>");

			out.close();  
		}
		catch(Exception e){
			System.out.println(e);
		}  	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidation() {
        super();
    }
	
}
