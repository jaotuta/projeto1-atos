package Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository {
	 public String url_db = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10616959";
	 public String user_db = "sql10616959";
	 public String password_db = "er6ZNSDEUM";
	 
	    public Repository() throws IOException {
	    }

	    public ResultSet consultar(String db_query) throws SQLException {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
            Connection con = DriverManager.getConnection(url_db, user_db, password_db);
	        PreparedStatement ps = con.prepareStatement(db_query);
	        ResultSet resultSet = ps.executeQuery();
	        return resultSet;
	    }

	    
	    public int inserirAlterarExcluir(String db_query) throws SQLException {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
            Connection con = DriverManager.getConnection(url_db, user_db, password_db);
	        PreparedStatement ps = con.prepareStatement(db_query);
	        int result = ps.executeUpdate();
	        return result;
	    }

}
