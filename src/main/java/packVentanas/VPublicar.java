package packVentanas;

import java.awt.EventQueue;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import packCodigo.Buscaminas;
import packCodigo.NoArchivoAudioException;
import twitter4j.TwitterException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VPublicar extends JFrame {

	private JPanel contentPane;
	private JButton btnOk;
	private Image fondo;
	private JButton btnFin ;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPublicar frame = new VPublicar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NoArchivoAudioException 
	 */
	public VPublicar()  { //INTERFAZ PARA LA PUBLICACION EN REDES SOCIALES
		Image icon = new ImageIcon(getClass().getResource("/icono.png")).getImage();
		setIconImage(icon);
		fondo = new ImageIcon(getClass().getResource("/twitter-portadas-01.png")).getImage();
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(fondo,0,0,getWidth(),getHeight(),this);
			}
		};	
		contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[180.00][][224.00]", "[70.00][70.00][25][25][25]"));
		contentPane.add(getBtnOk(), "cell 0 2,alignx center");
		contentPane.add(getBtnFin(), "cell 2 2,alignx right");
		setTitle("Publicar Resultados");
	}
	
	private JButton getBtnOk() {
		//Pre : Partida Finalizada
    	//Pos : Enviar tweet 
		if (btnOk == null) {
			btnOk = new JButton("PUBLICAR RESULTADOS ! ");
			btnOk.addMouseListener(new MouseAdapter(){ 
				public void mouseClicked(MouseEvent e){
					 if (e.getButton() == MouseEvent.BUTTON1) { //CUANDO PULSAMOS EL BOTON "PUBLICAR RESULTADOS"
							try {
								
								Buscaminas.getBuscaminas().publicar();
							} catch (TwitterException e1 ) { //EXCEPCION CUANDO LAS CLAVES DE TWITTER ESTAN MAL O ALGUN OTRO TIPO DE PROBLEMA EXTERNO A LA APLICACION
								 JOptionPane.showMessageDialog(null, "TWITTER NOS DA PROBLEMAS PARA PUBLICARLO, PRUEBA MAS TARDE!!");
							}catch (Exception e2 ) { //EXCEPCION CUANDO NO HAY RED O ALGUN ERROR RELACIONADO CON LOS DATOS DE LA APLICACION
								 JOptionPane.showMessageDialog(null, "HEMOS TENIDO UN PROBLEMA PARA PUBLICARLO, PRUEBA DE NUEVO!!");
							}
						 setVisible(false);
						 
					 }
				}
			});
		}
		return btnOk;
	}
	private JButton getBtnFin() { //BOTON PARA VOLVER AL JUEGO Y JUGAR OTRA PARTIDA O CERRAR EL JUEGO
		//Pre : Partida Finalizada.
    	//Pos : Cerrar Interfaz Publicar.
		if (btnFin  == null) {
			btnFin = new JButton("VOLVER");
			btnFin.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					 if (e.getButton() == MouseEvent.BUTTON1) {
						 setVisible(false);
						 
					 }
				}
			});
		}
		return btnFin;
	}
	
	
}
