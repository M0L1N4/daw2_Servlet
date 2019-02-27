
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * 
 * 
 * @class loginCase
 * */
public class LoginCase {
	
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
			String consulta = "insert into USERS (NICK,PASS,EMAIL) VALUES(?,?,?);";
			ps = con.prepareStatement(consulta);
			
			System.err.println("\n*****************\n****************\n"+ps);
			ps.setString(1,uName);
			ps.setString(2,uPass);
			ps.setString(3,uEmail);
			System.err.println("\nASSIGNATION\n****************\n"+ps);
			
			if(ps.executeUpdate() == 1) {
				System.err.println("\nTRUE\n****************\n");
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
				if(con != null) {
					con.close();
					System.err.println("\nCLOSE CON\n****************\n"+con);
					ConnectionDB.stopConnection();
					System.err.println("\nSHUTDOWN DB\n****************\n"+con);
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
