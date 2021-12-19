package trinhtruong2k1.io.seller.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect  {
	private final String serverName = "DESKTOP-ZTANK";
	private final String dbName = "BanDoGiaDung";
	private final String portNumber = "1433";
	private final String instance="";
	private final String UserID = "sa";
	private final String password="123456";
	
	public  Connection getConnection()throws Exception{
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,UserID,password);

    }
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnect().getConnection());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
