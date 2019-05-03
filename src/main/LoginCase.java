package main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Logger;

/**
 * 
 * 
 * 
 * @class loginCase
 * */
public class LoginCase {
	static Logger logger = Logger.getLogger(LoginCase.class.getName());
	/**
	 * 
	 * CREATE TABLE Users (
		cod_user int NOT NULL IDENTITY,
		nick varchar(25),
		pass varchar(20),
		email varchar(50),
		PRIMARY KEY (cod_user)
		);
	 * 
	 * insert into "PUBLIC"."USERS" ("NICK","PASS","EMAIL") VALUES('ariel','ariel','ariel@gmail.com');
	 * insert into USERS ("NICK","PASS","EMAIL") VALUES('aa','bb','cc');
	 * */
	
	public static boolean insertUser(String uName, String uPass, String uEmail){

		ConnectionDB.conn = ConnectionDB.getConnection("/Users/alvaro/eclipse-workspace/daw2_Servlet/props/dbConnData.properties");
		PreparedStatement ps = null;
		
		try {
			String consulta = "insert into USERS (\"NICK\",\"PASS\",\"EMAIL\") VALUES(?,?,?);";

			ps = ConnectionDB.conn.prepareStatement(consulta);
			
			ps.setString(1,uName);
			ps.setString(2,uPass);
			ps.setString(3,uEmail);
			System.err.println("\nASSIGNATION\n****************\n"+ps);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				System.err.println("\nFINALLY\n****************\n"+ps);
				if(ps != null) {
					ps.close();
					System.err.println("\nCLOSE PS\n****************\n"+ps);

				}
				if(ConnectionDB.conn != null) {
					ConnectionDB.conn.close();
					System.err.println("\nCLOSE CON\n****************\n"+ConnectionDB.conn);
					System.err.println("\nIS CON CLOSED?\n****************\n"+ConnectionDB.conn.isClosed());
					ConnectionDB.stopConnection();

					System.err.println("\nSHUTDOWN DB\n****************\n"+ConnectionDB.conn);
					if(ConnectionDB.stopConn()) {
						System.err.println("\nALL IS OK\n****************\n"+ConnectionDB.conn);

					}
					else {
						System.err.println("\nMMMEEEEEEKKKKKKK!!!\n****************\n"+ConnectionDB.conn);
					}
						
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	private LoginCase() {
        throw new IllegalStateException("Utility class");
    }
}
