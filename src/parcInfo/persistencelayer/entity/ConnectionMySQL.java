package parcInfo.persistencelayer.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	//Objet Connection
	private static Connection con;
	
	
	private static String  driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/gestionparcinformatique";
	private static String user ="root";
	private static String passwd="";
	
	public static Connection getConnection(){
		if (con == null){
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, passwd);
			}catch (Exception e){
				e.printStackTrace();
			}	
		}
		return con;	
	}
}
