package packCodigo;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
 
/**
 * @author raidentrance
 *
 */
public class GestorRedesSociales {
	private static GestorRedesSociales miGestorRedesSociales = new GestorRedesSociales();

	private GestorRedesSociales(){
	}
	
	public static GestorRedesSociales getGestorRedesSociales(){
		return miGestorRedesSociales;
	}
	
    
	public void publicar() throws Exception{ 
		//Pre : Partida Acabada y datos necesarios guardados.
    	//Pos : Datos leidos y enviados al metodo publicar de la clase RedSocial mediante parametro.
			RedSocial controller = new RedSocial();
        	//envia tweet
			int puntuacion = GestorPuntuacion.getGestorPuntuacion().getPuntuacionActual(); //OBTIENE PUNTUACION ACTUAL
			String nombre = Buscaminas.getBuscaminas().obtenerNombreJugador(); // OBTIENE NOMBRE DEL JUGADOR ACTUAL
			int puntuacionHistorica = GestorPuntuacion.getGestorPuntuacion().getPuntuacionMaxima(); // OBTENER PUNTUACION MAXIMA DE LA BASE DE DATOS
        	
			controller.publicarTweet(puntuacion, nombre ,puntuacionHistorica);
        	//enseña ultimo tweet enviado
        	controller.verUltimoTweet();
           
   		}
    }