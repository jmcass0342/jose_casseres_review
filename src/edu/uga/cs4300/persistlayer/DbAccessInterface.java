package edu.uga.cs4300.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbAccessInterface {

	public Connection connect() throws SQLException;
	
	public ResultSet retrieve (Connection con, String query);

	public int create (Connection con, String query);
	
	public int update (Connection con, String query);
	
	public int delete (Connection con, String query);
	
	public void disconnect(Connection con);
	
}
