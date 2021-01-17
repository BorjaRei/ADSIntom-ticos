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
import packCodigo.SGBD;

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
		boolean existe = false;
		SGBD BD=new SGBD();
		String q=("SELECT correo FROM jugador WHERE correo='"+email+"'");
		ResultSet res=BD.execSQLC(q);
	
		try {
			if (res.next()!=false){
				existe=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existe;
	}
	public boolean comprobarUsuario (String nick, String pass){
		SGBD BD=new SGBD();
		boolean existe=false;
		ResultSet res=BD.execSQLC("SELECT nombre FROM jugador WHERE nombre='"+nick+"'");
		try {
			if (res.next()!=false){
				existe=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return existe;
	}
	
	public boolean registrarse(String usuario, String pass, String email){
		SGBD BD=new SGBD();
		boolean correcto = false;
		if(comprobarEmail(email)==false && comprobarUsuario(usuario, pass)==false){
			BD.execSQLU("INSERT INTO jugador(correo,nombre,contraseña) VALUES('"+email+"','"+usuario+"','"+pass+"'"+")");
			correcto = true;
		}
		return correcto;
	}
	public void cambiarContra(String jugadorActual,String nueva){
		SGBD BD=new SGBD();
		BD.execSQLC("UPDATE jugador SET contraseña='"+nueva+"'"+"WHERE nombre='"+jugadorActual+"'");
		
	}
	public boolean login(String usuario, String pass){
		SGBD BD=new SGBD();
		if((usuario==null) || (usuario.equals(""))){
			return false;
		}
		if ((pass==null) || (pass.equals(""))){
			return false;
		}
		ResultSet res=BD.execSQLC("SELECT nombre FROM Jugador WHERE nombre='"+usuario+"'"+"AND contraseña='"+pass+"'");
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
			ResultSet res=BD.execSQLC("SELECT contraseña FROM jugador WHERE correo='"+email+"'");
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
}