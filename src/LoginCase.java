
import java.sql.Connection;
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
		Connection con;
		con = ConnectionDB.getConnection();
		PreparedStatement ps = null;
		
		try {
			String consulta = "insert into USERS (\"NICK\",\"PASS\",\"EMAIL\") VALUES(?,?,?);";
//			System.err.println("\nINSERT CON\n****************\n"+con);
			ps = con.prepareStatement(consulta);
//			System.err.println("\nCON INSERT\n****************\n"+con);
//			System.err.println("\n*****************\n****************\n"+ps);
			
			ps.setString(1,uName);
			ps.setString(2,uPass);
			ps.setString(3,uEmail);
//			System.err.println("\nASSIGNATION\n****************\n"+ps);
			logger.log(null, "\nASSIGNATION\n****************\n",ps);
			
			if(ps.executeUpdate() == 1) {
//				System.err.println("\nTRUE\n****************\n");
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
//				System.err.println("\nFINALLY\n****************\n"+ps);
				logger.log(null, "\nFINALLY\n****************\n",ps);
				if(ps != null) {
					ps.close();
//					System.err.println("\nCLOSE PS\n****************\n"+ps);
					logger.log(null, "\nCLOSE PS\n****************\n",ps);
					logger.log(null, "\nCLOSE PS\n****************\n",ps.isClosed());

				}
				if(con != null) {
					con.close();
					logger.log(null, "\nCLOSE CON\n****************\n",con.isClosed());
//					System.err.println("\nCLOSE CON\n****************\n"+con);
//					System.err.println("\nIS CON CLOSED?\n****************\n"+con.isClosed());
					//con = null;
					ConnectionDB.stopConnection();
					logger.log(null, "\nSHUTDOWN DB\n****************\n",ConnectionDB.conn);
//					System.err.println("\nSHUTDOWN DB\n****************\n"+ConnectionDB.conn);
					if(ConnectionDB.stopConn()) {
//						System.err.println("\nALL IS OK\n****************\n"+ConnectionDB.conn);
						logger.log(null, "\nALL IS OK\n****************\n",ConnectionDB.conn);
					}
					else {
//						System.err.println("\nMMMEEEEEEKKKKKKK!!!\n****************\n"+ConnectionDB.conn);
						logger.log(null, "\nMMMEEEEEEKKKKKKK!!!\n****************\n",ConnectionDB.conn);
					}
						
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
//			return ConnectionDB.stopConn();
		}
		return false;
	}
	private LoginCase() {
        throw new IllegalStateException("Utility class");
    }
}
