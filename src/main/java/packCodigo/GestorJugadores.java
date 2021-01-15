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
		ResultSet res=BD.execSQLC("SELECT correoJugador FROM Jugador WHERE correoJugador='"+email+"'");
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
	
	public void registrarse(String nick, String pass, String email){
		SGBD BD=new SGBD();
		if(comprobarEmail(email)==false && comprobarUsuario(nick, pass)==false){
			BD.execSQLI("INSERT INTO Jugador(correoJugador,nombreUsuario,contraseña) VALUES('"+email+"'"+nick+"'"+pass+"'"+")");
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
		ResultSet res=BD.execSQL("SELECT nombreUsuario FROM Jugador WHERE nombreUsuario='"+usuario+"'"+"AND contraseña='"+pass+"'");
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
}

