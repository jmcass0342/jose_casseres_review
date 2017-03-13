package edu.uga.cs4300.persistlayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class performs database operations.
 * @author durandal, Haseeb Yousaf
 */
public class DbAccessImpl implements DbAccessInterface {


    /**
     * Establish a JDBC connection to the database.
     * @return  a database connection object
     * @throws  GVException
     */
    public Connection connect() 
            throws SQLException 
    {
        try {
            Class.forName(DbAccessConfig.DB_DRIVE_NAME);
        } 
        catch (ClassNotFoundException ex) {
            // log.error( "DbUtils.connect:  unable to find JDBC Driver", ex );
            throw new SQLException( "DbUtils.connect: Unable to find Driver" );
        }
        try {
            return DriverManager.getConnection( DbAccessConfig.DB_CONNECTION_URL,
                                                DbAccessConfig.DB_CONNECTION_USERNAME,
                                                DbAccessConfig.DB_CONNECTION_PWD );
        } 
        catch (SQLException ex) {
            // log.error( "DbUtils.connect: Unable to connect to database", ex );
            throw new SQLException( "DbUtils.connect: Unable to connect to database " + ex.getMessage() );
        }
    }

	@Override
	public int create(Connection con, String query) {
		// insert insert query here
		
		Statement stmt;
		int result = new Integer(null);
		try {
			stmt = con.createStatement();
			
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated  catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int update(Connection con, String query) {
		// insert update query here

		Statement stmt;
		int result = new Integer(null);
		try {
			stmt = con.createStatement();
			
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated  catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int delete(Connection con, String query) {
		// insert delete from query here
		Statement stmt;
		int result = new Integer(null);
		try {
			stmt = con.createStatement();
			
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated  catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public void disconnect(Connection con) {
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet retrieve(Connection con, String query) {
		// insert select to query here
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}

}