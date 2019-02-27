import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionDB{
	
	private static Properties prop = new Properties();
	private static InputStream input = null;
	private static final Logger LOG = Logger.getLogger(ConnectionDB.class.getName());
//	static String driverHSQLDB="org.hsqldb.jdbcDriver";
//	static String urlHSQLDB="jdbc:hsqldb:file:srv_db";
	
/*
	String url = "jdbc:hsqldb:file:srv_db";
	Properties props = new Properties();
	props.setProperty("user", "sa");
	props.setProperty("password", "");
	DriverManager.getConnection(url, props);*/
	
	public static Connection getConnection(){
		Connection conn = null;
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
					LOG.log(null,"FILE ERROR: "+e);
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
	
	private ConnectionDB() {
        super();        
    }
}