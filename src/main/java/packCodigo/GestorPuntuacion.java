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
	public int getPuntuacionMaxima() throws Exception{
		
		String nombre = Buscaminas.getBuscaminas().obtenerNombreJugador();
		ResultSet res=SGBD.getMiSGBD().execSQLC("SELECT puntos FROM ranking WHERE nombre='"+nombre+"'");
		res.next();
		int puntos = res.getInt(1);
		return puntos;
	}
	
}
