import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionDB{
	
	static Logger logger = Logger.getLogger(LoginCase.class.getName());

	
	private static Properties prop = new Properties();
	private static InputStream input = null;
	public static Connection conn = null;

	@java.lang.SuppressWarnings("squid:S1523")
	public static Connection getConnection(){		
		try {

			input = new FileInputStream("/Users/alvaro/eclipse-workspace/daw2_Servlet/props/dbConnData.properties");
			prop.load(input);
			
			try {
				Class.forName(prop.getProperty("DRIVER_HSQLDB"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(prop.getProperty("CONN_HSQLDB"));
				System.out.println("\n\n*TRY==\n"+conn+"--------\n\n");
			} catch (SQLException e) {
				System.out.println("\n\n***===\n"+conn+"--------\n\n");
				e.printStackTrace();
			}
		}
		catch (IOException ex) {
			System.err.println("\nFILE ERROR: "+ex);
		}
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println("\nCLOSE ERROR: "+e);
				}
			}
		}	
		return conn;
	}
	
	public static void stopConnection(){
		try {			
			conn= DriverManager.getConnection(prop.getProperty("DRIVER_OFF"),
					prop.getProperty("USER_HSQLDB"),prop.getProperty("PASS_HSQLDB"));
			
			System.err.println("\nSHUTDOWN DB\n****************\n"+conn);
		}
		catch (SQLException e) {
			System.err.println("\nSTOP DB ERROR: "+e);
		}
	}
	
	public static boolean stopConn() {
		try {
			if(conn != null) {
				conn.close();
				System.err.println("\nCLOSE CONN\n****************\n"+conn);
				
				return true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	private ConnectionDB() {
        super();        
    }
}