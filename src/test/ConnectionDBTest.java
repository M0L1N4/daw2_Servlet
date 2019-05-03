package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ConnectionDB;

class ConnectionDBTest {
	
	@Test
	void testGetConnection() {
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
	void testStopConnection() {
		fail("Not yet implemented");
	}

	@Test
	void testStopConn() {
		boolean bol = ConnectionDB.stopConn();
		assertEquals(true, bol);	}

}
