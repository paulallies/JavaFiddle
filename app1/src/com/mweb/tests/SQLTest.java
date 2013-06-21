package com.mweb.tests;

import java.sql.Connection;
import java.sql.SQLException;
import app1.Bank;
import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter;
import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;

public class SQLTest extends BasicJDBCTestCaseAdapter {

	private Connection jdbcConnection;
	
    private void prepareRS() {
    	MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
    	StatementResultSetHandler resultSetHandler = connection.getStatementResultSetHandler(); 
    	jdbcConnection = connection;
        
        MockResultSet result = resultSetHandler.createResultSet();
        result.addRow(new Object[] {"1000"});
        //statementHandler.prepareGlobalResultSet(result);
        resultSetHandler.prepareResultSet("SELECT * from macs", result);
}

	public void testGetAllForecasts() throws SQLException{
		prepareRS();
		Bank b = new Bank(jdbcConnection);
		boolean result = b.select("100");
		verifySQLStatementExecuted("select * from macs");
		verifyAllResultSetsClosed();

	}

}
