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
		RedSocial controller = new RedSocial();
        	//envia tweet
			int puntuacion = GestorPuntuacion.getGestorPuntuacion().getPuntuacionActual();
			String nombre = Buscaminas.getBuscaminas().obtenerNombreJugador();
			int puntuacionHistorica = GestorPuntuacion.getGestorPuntuacion().getPuntuacionMaxima();
        	
			controller.publicarTweet(puntuacion, nombre ,puntuacionHistorica);
        	//enseña ultimo tweet enviado
        	controller.verUltimoTweet();
           
   		}
    }