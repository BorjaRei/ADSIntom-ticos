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
    private Twitter twitter;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   
   

	public RedSocial(){
		twitter = TwitterFactory.getSingleton();
	}
	
	
  
    public void publicarTweet (int puntuacion ,String usuario ,int puntuacionHistorica) throws TwitterException{
    	twitter.updateStatus("Hola! " + usuario + " has conseguido " + puntuacion + " puntos. Tu puntuacion historica es : " + puntuacionHistorica );
    }
 
    public List<Status> query() throws TwitterException {
        List<Status> tweets = twitter.getUserTimeline();
        return tweets;
    }
    
    //PRUEBA PARA VER LO QUE PUBLICA *
    public void printStatusActual(Status status) {
        System.out.println("----------------------------------------------------------");
        System.out.println(String.format("User [%s]", status.getUser().getScreenName()));
        System.out.println(status.getText());
        System.out.println(sdf.format(status.getCreatedAt()));
        System.out.println(String.format("RT[%d] FAV[%d]", status.getRetweetCount(), status.getFavoriteCount()));
        System.out.println("----------------------------------------------------------");
    }
    // *
 
    public void printStatus(List<Status> status) {
        printStatusActual(status.get(0));
     
    }
 
}


