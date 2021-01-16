package pruebas;
import packCodigo.RedSocial;
import twitter4j.TwitterException;
public class pruebasPublicar {
	
	public static void main(String args[]) {
		String nombreJugador = "prueba";
		RedSocial Twitter = new RedSocial();
		
		System.out.println("-------------PRUEBA 1 --------------");
		
		//prueba 1 :  Si tiene internet. Se termina la partida con 0 puntos y pulsa compartir Resultados.
		try {
			Twitter.publicarTweet(0, nombreJugador, 0);
			Twitter.verUltimoTweet();
		} catch (TwitterException e3) {
			// TODO Auto-generated catch block
			System.out.println("Caso 1 FALLO");
		}
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 2 --------------");
		
		//prueba 2 : Si tiene internet. Se termina la partida con 10 puntos y pulsa compartir Resultados.
		try {
			Twitter.publicarTweet(10, nombreJugador, 500);
			Twitter.verUltimoTweet();
		} catch (TwitterException e2) {
			// TODO Auto-generated catch block
			System.out.println("Caso 2 FALLO ");
		}
		
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 3 --------------");
		//prueba 3 : Si tiene internet. Se termina la partida con 10000 puntos y pulsa compartir Resultados.
		try {
			Twitter.publicarTweet(10000, nombreJugador, 10000);
			Twitter.verUltimoTweet();
		} catch (TwitterException e1) {
			// TODO Auto-generated catch block
			System.out.println("Caso 3 FALLO ");
		}
		
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 4 --------------");
		
		//prueba 4 : Si tiene internet. No ha podido terminar la partida por un fallo inesperado, y pulsa compartir Resultados.
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 5 --------------");
		
		//prueba 5 : Si NO tiene internet. Se termina la partida con 0 puntos y pulsa compartir Resultados.
		//Ponemos MODO AVION
		try{
			Twitter.publicarTweet(0, nombreJugador, 500);
			Twitter.verUltimoTweet();
		} catch (TwitterException e) {System.out.println("Caso 5 FALLO DE CONEXION");}
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 6 --------------");
		
		//prueba 6 : Si NO tiene internet. Se termina la partida con 10 puntos y pulsa compartir Resultados.
		//Ponemos MODO AVION
		try{
			Twitter.publicarTweet(10, nombreJugador, 500);
			Twitter.verUltimoTweet();
		} catch (TwitterException e) {System.out.println("Caso 6 FALLO DE CONEXION");}
		System.out.println("------------------------------------");
		
		System.out.println("-------------PRUEBA 7 --------------");
		
		//prueba 7 : Si NO tiene internet. Se termina la partida con 10000 puntos y pulsa compartir Resultados.
		//Ponemos MODO AVION
		try{
			Twitter.publicarTweet(10000, nombreJugador, 10000);
			Twitter.verUltimoTweet();
		} catch (TwitterException e) {System.out.println("Caso 7 FALLO DE CONEXION");}		



	}
}
