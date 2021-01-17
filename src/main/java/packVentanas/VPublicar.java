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
	public VPublicar()  {
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
		if (btnOk == null) {
			btnOk = new JButton("PUBLICAR RESULTADOS ! ");
			btnOk.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					 if (e.getButton() == MouseEvent.BUTTON1) {
							try {
								
								Buscaminas.getBuscaminas().publicar();
							} catch (TwitterException e1 ) {
								 JOptionPane.showMessageDialog(null, "TWITTER NOS DA PROBLEMAS PARA PUBLICARLO, PRUEBA MAS TARDE!!");
							}catch (Exception e2 ) {
								 JOptionPane.showMessageDialog(null, "HEMOS TENIDO UN PROBLEMA PARA PUBLICARLO, PRUEBA DE NUEVO!!");
							}
						 setVisible(false);
						 
					 }
				}
			});
		}
		return btnOk;
	}
	private JButton getBtnFin() {
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
