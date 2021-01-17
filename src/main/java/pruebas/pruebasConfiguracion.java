/**
 * 
 */
package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import packCodigo.Buscaminas;
import packCodigo.GestorJugadores;
import twitter4j.JSONObject;

/**
 * @author borja
 *
 */
public class pruebasConfiguracion {

	
	public static void main(String args[]) {
		//CREAMOS UN USUARIO
		GestorJugadores.getMiGestorJugadores().registrarse("Prueba1", "123", "prueba1@gmail.com");
		GestorJugadores.getMiGestorJugadores().login("Prueba1", "123");
		Buscaminas.getBuscaminas().establecerNombreJugador("Prueba1");
		
	
		//COMPROBAR guardarConf CAMBIAR TODOS LOS ELEMENTOS
		System.out.println("-------------PRUEBA 1--------------");
		Buscaminas.getBuscaminas().guardarConf(2, 3, "//NUEVO//");
		org.json.JSONObject ja=Buscaminas.getBuscaminas().getInfo();
		if(ja.getInt("Mina")==2 && ja.getInt("Sonido")==3 &&ja.getString("Icono").compareTo("//NUEVO//")==0) {
			System.out.println("-------------  OK --------------");
		}
		else {
			System.out.println("-------------ERROR 1 --------------");
		}
		
		//COMPROBAR guardarConf CAMBIAR SOLO MINA
				System.out.println("-------------PRUEBA 2--------------");
				Buscaminas.getBuscaminas().guardarConf(1, 3, "//NUEVO//");
				org.json.JSONObject j5=Buscaminas.getBuscaminas().getInfo();
				if(j5.getInt("Mina")==1 && j5.getInt("Sonido")==3 &&j5.getString("Icono").compareTo("//NUEVO//")==0) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 2 --------------");
				}
				
			//COMPROBAR guardarConf CAMBIAR SOLO SONIDO
				System.out.println("-------------PRUEBA 3--------------");
				Buscaminas.getBuscaminas().guardarConf(1, 2, "//NUEVO//");
				org.json.JSONObject j6=Buscaminas.getBuscaminas().getInfo();
				if(j6.getInt("Mina")==1 && j6.getInt("Sonido")==2 &&j6.getString("Icono").compareTo("//NUEVO//")==0) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 3 --------------");
				}
				
		//COMPROBAR guardarConf CAMBIAR SOLO PATH
				System.out.println("-------------PRUEBA 4--------------");
				Buscaminas.getBuscaminas().guardarConf(1, 2, "//NUEVO7.png");
				org.json.JSONObject j7=Buscaminas.getBuscaminas().getInfo();
				if(j7.getInt("Mina")==1 && j7.getInt("Sonido")==2 &&j7.getString("Icono").compareTo("//NUEVO7.png")==0) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 4 --------------");
				}
				
		
				 //COMPROBAR QUE GETINFO FUNCIONA BIEN
				System.out.println("-------------PRUEBA 5 --------------");
				org.json.JSONObject jo=Buscaminas.getBuscaminas().getInfo();
				if(jo.getInt("Mina")==1 && jo.getInt("Sonido")==2 &&jo.getString("Icono").compareTo("//NUEVO7.png")==0) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 5 --------------");
				}
				
				
				
				//COMPROBAR GETMINA TRAS USAR GUARDARCONF
				System.out.println("-------------PRUEBA 6 --------------");
				if(Buscaminas.getBuscaminas().getMina()==1) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 6 --------------");
				}
				
				//COMPROBAR GETSONIDO TRAS USAR GUARDARCONF
				
				System.out.println("-------------PRUEBA 7 --------------");
				
				if(Buscaminas.getBuscaminas().getSonido()==2) {
					System.out.println("-------------  OK --------------");
				}
				else {
					System.out.println("-------------ERROR 7 --------------");
				}
						
		
		//
		
		
	}
	
}