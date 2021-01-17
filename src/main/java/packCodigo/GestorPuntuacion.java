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
		SGBD BD=new SGBD();
		String nombre = Buscaminas.getBuscaminas().obtenerNombreJugador();
		ResultSet res=BD.execSQLC("SELECT puntos FROM ranking WHERE nombre='"+nombre+"'");
		res.next();
		int puntos = res.getInt(1);
		return puntos;
	}
	  public static void main(String[] args) 
	    {
	        GestorPuntuacion k = new GestorPuntuacion();
	        try {
				k.getPuntuacionMaxima();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
}
