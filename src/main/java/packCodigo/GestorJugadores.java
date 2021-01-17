package packCodigo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*;

import org.json.JSONObject;

import net.ucanaccess.jdbc.Session;
import packCodigo.SGBD;
import vista.gestorBD;
//e
public class GestorJugadores {
	private static GestorJugadores miGestorJugadores=new GestorJugadores();
	
	private GestorJugadores(){}
	
	public static GestorJugadores getMiGestorJugadores(){
		if (miGestorJugadores==null){
			miGestorJugadores=new GestorJugadores();
		}
		return miGestorJugadores;
	}
	
	public boolean comprobarEmail(String email){
		SGBD BD=new SGBD();
		boolean existe=false;
		String q=("SELECT correoJugador FROM Jugador WHERE correoJugador='"+email+"'");
		ResultSet res=BD.execSQLC(q);
		if (res!=null){
			existe=true;
		}
		return existe;
	}
	public boolean comprobarUsuario (String nick, String pass){
		SGBD BD=new SGBD();
		boolean existe=false;
		ResultSet res=BD.execSQLC("SELECT nombreUsuario FRROM Jugador WHERE nombreUsuario='"+nick+"'");
		if (res!=null){
			existe=true;
		}
		return existe;
	}
	
	public void registrarse(String usuario, String pass, String email){
		SGBD BD=new SGBD();
		if(comprobarEmail(email)==false && comprobarUsuario(usuario, pass)==false){
			BD.execSQLI("INSERT INTO Jugador(correoJugador,nombreUsuario,contraseña) VALUES('"+email+"'"+usuario+"'"+pass+"'"+")");
		}
	}
	public void cambiarContra(String jugadorActual,String nueva){
		SGBD BD=new SGBD();
		BD.execSQLI("UPDATE Jugador SET contraseña='"+nueva+"'"+"WHERE nombreUsuario='"+jugadorActual+"'");
		
	}
	public boolean login(String usuario, String pass){
		SGBD BD=new SGBD();
		if((usuario==null) || (usuario.equals(""))){
			return false;
		}
		if ((pass==null) || (pass.equals(""))){
			return false;
		}
		ResultSet res=BD.execSQLC("SELECT nombreUsuario FROM Jugador WHERE nombreUsuario='"+usuario+"'"+"AND contraseña='"+pass+"'");
		try{
			return res.next();
			}
		catch(SQLException e){
			return false;
		}
	}
	public void recuperarContra(String email){
		SGBD BD=new SGBD();
		if (comprobarEmail(email)==true){
			ResultSet res=BD.execSQLC("SELECT contraseña FROM Jugador WHERE correoJugador='"+email+"'");
		    String destinatario =  email; //A quien le quieres escribir.
		    String asunto = "Recuperación de contraseña";
		    String cuerpo = "Su contraseña es: " + res;

		    enviarConGMail(destinatario, asunto, cuerpo);
		}
	}
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    //Sacado de https://bit.ly/3sudmHq
	    String remitente = "adsintomaticos";  

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "ElOrtuzi15");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "ElOrtuzi15");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	public void guardarConf(String pNombreJugador, int pMina, int pSonido, String pIcono) {

		String insSQL="UPDATE jugador SET pathIconoMinas="+pMina+" , pathSonido="+ pSonido +" ,pathIconoUsuario="+pIcono+" WHERE nombreUsuario="+ pNombreJugador;
		System.out.println(insSQL);
		//SGBD.getMigestorBD().execSQL(insSQL);
	}
	
	public JSONObject getInfo(String usuario) {
		String insSQL="SELECT pathIconoMina, pathSonido, pathIconoUsuario FROM Jugador WHERE nombre='"+usuario+"'";
		//CAMBIAR CON BD
		JSONObject jo=new JSONObject();
		jo.put("Mina", 3);
		jo.put("Sonido", 2);
		jo.put("Icono", "PATH");
		
		return jo;
	
	}
	public int getSonido(String usuario) {
		//Cogemos la configuracion de sonido del usuario
		String insSQL="SELECT pathSonido FROM Jugador WHERE nombre='"+usuario+"'";
		
		return 1;
	}
	public int getMina(String usuario) {
		//Cogemos la configuracion de mina del usuario
		String insSQL="SELECT pathIconoMina FROM Jugador WHERE nombre='"+usuario+"'";
		return 1;
	}
}
