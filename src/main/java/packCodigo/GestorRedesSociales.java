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
	
	public static GestorRedesSociales getGestorPremios(){
		return miGestorRedesSociales;
	}
	
    
	public void publicar(int puntuacion , String nombre ,int puntuacionHistorica) throws TwitterException{ 
		RedSocial controller = new RedSocial();
        	//envia tweet
        	controller.publicarTweet(puntuacion, nombre ,puntuacionHistorica);
        	//enseña ultimo tweet enviado
        	controller.verUltimoTweet();
           
   		}
    }