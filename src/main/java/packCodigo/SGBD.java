package packCodigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SGBD {
	
	 // Librería de MySQL
   public String driver = "com.mysql.cj.jdbc.Driver";
//   com.mysql.jdbc.Driver
   // Nombre de la base de datos
   public String database = "buscaminas";
   // Host
   public String hostname = "localhost";
   // Puerto
   public String port = "3306";
   // Ruta de la base de datos (desactivamos el uso de SSL con "?useSSL=false")
   public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
   // Nombre de usuario
   public String username = "root";
   // Clave de usuario
   public String password = "";
   // Conexion
  
   public Connection conectarMySQL() { //Realiza la conexion
       Connection conn = null;
       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, username, password);
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
       return conn;
   }
   public void execSQLI(String actualiz) {
   	Connection con= this.conectarMySQL();
   	try {
			con.prepareStatement(actualiz).executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }
   public ResultSet execSQLC(String pregunta) {
   	Connection con= this.conectarMySQL();
   	try {
			return con.createStatement().executeQuery(pregunta);
		} catch (SQLException e) {
			return null;
		}
   
   }
   

}