package packCodigo;

import java.sql.ResultSet;

public class GestorPuntuacion {

	private static GestorPuntuacion miGestorPuntuacion = new GestorPuntuacion();

	private GestorPuntuacion(){
	}
	
	public static GestorPuntuacion getGestorPuntuacion(){
		return miGestorPuntuacion;
	}
	
	public int getPuntuacionActual(){
		return Buscaminas.getBuscaminas().obtenerPuntuacion();
	}
	public String getPuntuacionMaxima() throws Exception{
		SGBD BD=new SGBD();
		String nombre = Buscaminas.getBuscaminas().obtenerNombreJugador();
		ResultSet res=BD.execSQLC("SELECT puntos FROM Ranking WHERE nombreusuario='"+nombre+"'");
		return res.toString();
	}
}
