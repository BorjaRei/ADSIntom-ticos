package packCodigo;
import java.sql.*;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SGBD {
	
	private static SGBD miSGBD = new SGBD();
	private SGBD (){}
	
	public static SGBD  getMiSGBD (){
		if (miSGBD ==null){
			miSGBD =new SGBD ();
		}
		return miSGBD ;
	}
	
		public ResultSet execSQLC(String q) {
			 // Se mete todo en un try por los posibles errores de MySQL
			 ResultSet rs = null;
	        try
	        {
	            // Se registra el Driver de MySQL
	            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
	            
	            // Se obtiene una conexión con la base de datos. Hay que
	            // cambiar el usuario "root" y la clave "la_clave" por las
	            // adecuadas a la base de datos que estemos usando.
	            Connection conexion = DriverManager.getConnection (
	                "jdbc:mysql://localhost/buscaminas","root", "");
	            
	            // Se crea un Statement, para realizar la consulta
	            java.sql.Statement s = conexion.createStatement();
	            
	            // Se realiza la consulta. Los resultados se guardan en el 
	            // ResultSet rs
	             rs = s.executeQuery(q);
	            
	            // Se cierra la conexión con la base de datos.
	            
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
			return rs;
		}
		public void  execSQLU(String q) {
			 // Se mete todo en un try por los posibles errores de MySQL
			 ResultSet rs = null;
	        try
	        {
	            // Se registra el Driver de MySQL
	            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
	            
	            // Se obtiene una conexión con la base de datos. Hay que
	            // cambiar el usuario "root" y la clave "la_clave" por las
	            // adecuadas a la base de datos que estemos usando.
	            Connection conexion = DriverManager.getConnection (
	                "jdbc:mysql://localhost/buscaminas","root", "");
	            
	            // Se crea un Statement, para realizar la consulta
	            java.sql.Statement s = conexion.createStatement();
	            
	            // Se realiza la consulta. Los resultados se guardan en el 
	            // ResultSet rs
	             s.execute(q);
	            
	            
	            // Se cierra la conexión con la base de datos.
	            conexion.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
			
		}
	    
	}
	   

