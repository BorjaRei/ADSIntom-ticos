package packCodigo;

import java.lang.reflect.Array;

import twitter4j.TwitterException;

public class ResultadoPartida {
	
	private int puntuacion;
	private int puntuacionHistorica;
	private String nombreJugador ;
	private String premios[];
	
	
	public ResultadoPartida(){
		this.nombreJugador =  Buscaminas.getBuscaminas().obtenerNombreJugador();
	}
	
	public void setPuntuacionActual(){
		this.puntuacion = GestorPuntuacion.getGestorPuntuacion().getPuntuacionActual();
	}
	public void setPuntuacionHistorica(){
		this.puntuacionHistorica = Integer.parseInt(GestorPuntuacion.getGestorPuntuacion().getPuntuacionMaxima());
	}
	public void publicar() throws TwitterException{
		GestorRedesSociales.getGestorPremios().publicar(puntuacion, nombreJugador, puntuacionHistorica);
		
	}

}
