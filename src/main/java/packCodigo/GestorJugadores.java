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
	
	public boolean comprobarEmail(String email){ //comprueba si el email ya está en la BD
		boolean existe = false;
		String q=("SELECT correo FROM jugador WHERE correo='"+email+"'");
		ResultSet res=SGBD.getMiSGBD().execSQLC(q);
	
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
	public boolean comprobarUsuario (String nick, String pass){//Comprueba si el usuario ya está en la BD
		
		boolean existe=false;
		ResultSet res=SGBD.getMiSGBD().execSQLC("SELECT nombre FROM jugador WHERE nombre='"+nick+"'");
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
		
		boolean correcto = false;
		if(comprobarEmail(email)==false && comprobarUsuario(usuario, pass)==false){//Si el nombre y el email no están ya registrados en la BD
			SGBD.getMiSGBD().execSQLU("INSERT INTO jugador(correo,nombre,password) VALUES('"+email+"','"+usuario+"','"+pass+"'"+")");
			correcto = true;
		}
		return correcto;
	}
	public void cambiarContra(String jugadorActual,String nueva){
		
		SGBD.getMiSGBD().execSQLC("UPDATE jugador SET password='"+nueva+"'"+"WHERE nombre='"+jugadorActual+"'");
		
	}
	public boolean login(String usuario, String pass){
		
		if((usuario==null) || (usuario.equals(""))){ //Comprueba que los campos no estén vacíos
			return false;
		}
		if ((pass==null) || (pass.equals(""))){//Comprueba que los campos no estén vacíos
			return false;
		}
		ResultSet res=SGBD.getMiSGBD().execSQLC("SELECT nombre FROM Jugador WHERE nombre='"+usuario+"'"+"AND password='"+pass+"'");
		try{
			return res.next();
			}
		catch(SQLException e){
			return false;
		}
	}
	public void recuperarContra(String email){
		
		if (comprobarEmail(email)==true){
			ResultSet res=SGBD.getMiSGBD().execSQLC("SELECT contraseña FROM jugador WHERE correo='"+email+"'");
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

		SGBD.getMiSGBD().execSQLU("UPDATE jugador SET pathIconoMina="+pMina+" , pathSonido="+ pSonido +" ,pathIconoUsuario='"+pIcono+"' WHERE nombre='"+ pNombreJugador+"'");		
	}
	public JSONObject getInfo(String usuario) {
		//CAMBIAR CON BD
		int IconoMina = 1;
		int Sonido = 1;
		String Usuario = null;
		ResultSet res = SGBD.getMiSGBD().execSQLC("SELECT pathIconoMina, pathSonido, pathIconoUsuario FROM jugador WHERE nombre='"+usuario+"'");
		try {
			while (res.next())
            {
            IconoMina =  res.getInt(1);
            Sonido=  res.getInt(2);
            Usuario= res.getString(3);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject jo=new JSONObject();
		jo.put("Mina", IconoMina);
		jo.put("Sonido", Sonido);
		jo.put("Icono", Usuario);
		
		return jo;
	
	}
	public int getSonido(String usuario) {
		//Cogemos la configuracion de sonido del usuario
		ResultSet res = SGBD.getMiSGBD().execSQLC("SELECT pathSonido FROM jugador WHERE nombre='"+usuario+"'");
		int result = 1;
		try {
			res.next();
			result = res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	public int getMina(String usuario) {
		ResultSet res = SGBD.getMiSGBD().execSQLC("SELECT pathIconoMina FROM jugador WHERE nombre='"+usuario+"'");
		int result = 1;
		try {
			res.next();
			result = res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}