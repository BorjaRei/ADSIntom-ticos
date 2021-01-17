package pruebas;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packCodigo.GestorJugadores;
import packCodigo.Jugador;

public class pruebasIdentificacion {
	Jugador j;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testComprobarEmail() {
		GestorJugadores.getMiGestorJugadores().registrarse("prueba","123","mailPrueba");
		//prueba1
		assertTrue(GestorJugadores.getMiGestorJugadores().comprobarEmail("mailPrueba"));
		//prueba2
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarEmail("noExiste"));
		//prueba3
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarEmail("tampocoExiste"));

	}

	@Test
	public void testComprobarUsuario() {
		GestorJugadores.getMiGestorJugadores().registrarse("prueba2", "123", "mailPrueba2");
		//prueba1
		assertTrue(GestorJugadores.getMiGestorJugadores().comprobarUsuario("prueba2", "123"));
		//prueba2
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarUsuario("pruebad2", "1d23"));
		//prueba3
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarUsuario("prusebad2", "123"));

	}

	@Test
	public void testRegistrarse() {
		GestorJugadores.getMiGestorJugadores().registrarse("pruebaR","123","mailPruebaR");
		//prueba1
		assertTrue(GestorJugadores.getMiGestorJugadores().comprobarEmail("mailPruebaR"));
		assertTrue(GestorJugadores.getMiGestorJugadores().comprobarUsuario("pruebaR", "123"));
		//prueba2
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarUsuario("pruebad2", "1d23"));
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarEmail("noExiste"));
		//prueba3
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarUsuario("prusebad2", "123"));
		assertFalse(GestorJugadores.getMiGestorJugadores().comprobarEmail("tampocoExiste"));
		
	}

}


