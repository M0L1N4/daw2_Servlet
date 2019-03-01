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
	private static final Logger LOG = Logger.getLogger(ConnectionDB.class.getName());
	public static Connection conn = null;
	
// System DB: /Applications/Eclipse.app/Contents/MacOS/srv_db
// My DB: /Users/alvaro/eclipse-workspace/daw2_Servlet/WebContent/WEB-INF/data_base/srv_db
// My new DB: /Users/alvaro/eclipse-workspace/daw2_Servlet/WebContent/WEB-INF/db/srv_db
	
	public static Connection getConnection(){		
		try {

			input = new FileInputStream("/Users/alvaro/eclipse-workspace/daw2_Servlet/props/dbConnData.properties");
			prop.load(input);
			
			Class.forName(prop.getProperty("DRIVER_HSQLDB"));
			conn = DriverManager.getConnection(prop.getProperty("CONN_HSQLDB"));
		}
		catch(ClassNotFoundException | SQLException e) {
			LOG.log(null,"Error: "+e);
		}
		catch (IOException ex) {
			LOG.log(null,"FILE ERROR: "+ex);
		}
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOG.log(null,"CLOSE ERROR: "+e);
				}
			}
		}	
		return conn;
	}
	
	public static void stopConnection(){
		try {			
			DriverManager.getConnection(prop.getProperty("DRIVER_OFF"),
					prop.getProperty("USER_HSQLDB"),prop.getProperty("PASS_HSQLDB"));
		}
		catch (SQLException e) {
			LOG.log(null,"STOP DB ERROR: "+e);
		}
	}
	
	public static boolean stopConn() {
		try {
			if(conn != null) {
				conn.close();
//				System.err.println("\nCLOSE CONN\n****************\n"+conn);
				logger.log(null, "\nCLOSE CONN\n****************\n",conn);

				//conn = null;
//				ConnectionDB.stopConnection();
//				System.err.println("\nSHUTDOWN DB\n****************\n"+conn);
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