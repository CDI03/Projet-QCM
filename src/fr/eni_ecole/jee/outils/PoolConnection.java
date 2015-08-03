package fr.eni_ecole.jee.outils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class PoolConnection implements AutoCloseable {

	private static Connection cnx = null;
	private static InitialContext contexte = null;
	
	
	public static Connection getConnection(Map<String, String> paramBDD) throws SQLException
	{
		if(cnx == null || cnx.isClosed())
		{
			DriverManager.registerDriver(new SQLServerDriver());
			cnx = DriverManager.getConnection(paramBDD.get("url"),paramBDD.get("user"),paramBDD.get("mdp"));
		}
		return cnx;
	}
	
	public static Connection getPoolConnection() throws SQLException, NamingException
	{

		contexte = new InitialContext();
		DataSource ds = (DataSource) contexte.lookup("java:comp/env/jdbc/TP_QCM");
		cnx = ds.getConnection();
		
		return cnx;
	}

	@Override
	public void close() throws Exception {
		if(cnx != null)
		{
			cnx.close();
		}
	}

}
