package packCodigo;

public class GestorPremios {

	private static GestorPremios miGestorPremios = new GestorPremios();

	private GestorPremios(){
	}
	
	public static GestorPremios getGestorPremios(){
		return miGestorPremios;
	}
	
	
}
