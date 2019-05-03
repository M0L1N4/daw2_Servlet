import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author alvaro
 *
 */
class ConnectionDBTest {

	@Test
	void getConnectionTest() {
		boolean bol;
		ConnectionDB.conn = ConnectionDB.getConnection("/Users/alvaro/eclipse-workspace/daw2_Servlet/props/dbConnData.properties");
		if (ConnectionDB.conn != null) {
			bol = true;
			assertEquals(true, bol);
		}
		else {
			bol = false;
			assertEquals(true, bol);
		}
	}
	
	@Test
	void stopConnTest() {
		boolean bol = ConnectionDB.stopConn();
		assertEquals(true, bol);
	}

}
