package packCodigo;

import java.text.SimpleDateFormat;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
 
/**
 * @author raidentrance
 *
 */
public class RedSocial {
    private static Twitter twitter;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   
   

	public RedSocial(){
		twitter = TwitterFactory.getSingleton();
	}
	
	
  
    public void publicarTweet (int puntuacion ,String usuario ,int puntuacionHistorica) throws TwitterException { //METODO CON CONTACTO DIRECTO CON TWITTER
    	//Pre : Parametros diferentes de null.
    	//Pos : Tweet publicado en la aplicacion de twitter.
    	twitter.updateStatus("Holaaaa ! " + usuario + " has conseguido " + puntuacion + " puntos. Tu puntuacion historica es : " 
    			+ puntuacionHistorica );
    }
    
    //PRUEBA PARA VER LO QUE PUBLICA *NO NECESARIO*
    public void verUltimoTweet() throws TwitterException {
    	//Pre : Tener al menos un tweet publicado.
    	//Pos : Enseña por pantalla el ultimo tweet publicado.
        List<Status> tweets = twitter.getUserTimeline();
        Status status = tweets.get(0);
        System.out.println("----------------------------------------------------------");
        System.out.println(String.format("User [%s]", status.getUser().getScreenName()));
        System.out.println(status.getText());
        System.out.println(sdf.format(status.getCreatedAt()));
        System.out.println(String.format("RT[%d] FAV[%d]", status.getRetweetCount(), status.getFavoriteCount()));
        System.out.println("----------------------------------------------------------");
    }
    
   
   
}


