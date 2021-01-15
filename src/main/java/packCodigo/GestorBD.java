package packCodigo;

import java.sql.ResultSet;

import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

public class GestorBD {

	public static JSONObject getInfoJugadores() {
		ConexionDB mysql = new ConexionDB();
        ResultSet rs = null;
        //Object[][] obj = null;

        mysql.MySQLConnection("root", "admin");

        String sql = "SELECT correoJugador, nombreUsuario\n" + 
        		", nivelPredeterminado FROM Jugador";

        rs = mysql.consultar(sql);

        java.sql.ResultSetMetaData rsmd = null;

        rsmd = rs.getMetaData();
        int columnas = rsmd.getColumnCount();

            while(rs.next()){
                //HashMap row = new HashMap();
                //badeDatos.add(row);

                for(int i=1; i<=columnas;i++){
                 //   row.put(rsmd.getColumnName(i), rsmd.getColumnCount());

                }

            }  

           for(Object o : badeDatos) {
               System.out.println(o.toString());
           }

        }
	}


