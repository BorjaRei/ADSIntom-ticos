package packVentanas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import packCodigo.Buscaminas;
import packCodigo.GestorJugadores;
import packCodigo.NoArchivoAudioException;
import packCodigo.Ranking;

import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;


public class VLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Choice choice;
	private JButton btnOk;
	private JLabel lblNombre;
	private Clip clip;
	private AudioInputStream ais;
	private Image fondo;
	private JLabel lblNewLabel;
	private JLabel lblDireccinDeCorreo;
	private JTextField textField_2;
	private JButton btnRegistrarse;
	private JButton btnRecuperarContrasea;
	private JPasswordField passwordField;
	private JLabel lblIntroducirUsuarioY;
	private JLabel lblIntroducirTambinEmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin frame = new VLogin();
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
	public VLogin() throws NoArchivoAudioException {
		Image icon = new ImageIcon(getClass().getResource("/icono.png")).getImage();
		setIconImage(icon);
		fondo = new ImageIcon(getClass().getResource("/Logo1.jpg")).getImage();
		//SONIDO-INICIO		
		if (new File("sources/login.wav").getAbsoluteFile() != null){
			try {
				ais = AudioSystem.getAudioInputStream(new File("src/main/resources/login.wav").getAbsoluteFile());
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			throw new NoArchivoAudioException();
		}
		clip.start();
		//SONIDO FIN
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 291);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(fondo,0,0,getWidth(),getHeight(),this);
			}
		};	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[188.00,grow][][224.00,grow]", "[][][20.00][20.00][20][][50][50]"));
		contentPane.add(getLblIntroducirUsuarioY(), "cell 0 0");
		contentPane.add(getLblNombre(), "cell 0 1,alignx left");
		contentPane.add(getTextField(), "cell 2 1,alignx center");
		contentPane.add(getLblNewLabel(), "cell 0 2");
		contentPane.add(getPasswordField(), "cell 2 2,alignx center");
		contentPane.add(getBtnOk(), "cell 2 3,alignx center,aligny top");
		contentPane.add(getLblIntroducirTambinEmail(), "cell 0 5");
		contentPane.add(getLblDireccinDeCorreo(), "cell 0 6,aligny bottom");
		contentPane.add(getTextField_2(), "cell 2 6,growx,aligny bottom");
		contentPane.add(getBtnRegistrarse(), "flowx,cell 2 7,aligny top");
		contentPane.add(getBtnRecuperarContrasea(), "cell 2 7,aligny top");
		setTitle("Identificaci\u00F3n");
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setMaximumSize(new Dimension(200,50));
		}
		return textField;
	}
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			String arr [] = {"1","2","3"};
			for(int i=0; i<arr.length; i++){
				choice.add(arr[i]);
			}
		}
		
		return choice;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Login");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnOk.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					 if (e.getButton() == MouseEvent.BUTTON1) {
						 String usuario=textField.getText();
						 String pass=passwordField.getText();
						 boolean login=Buscaminas.getBuscaminas().login(usuario, pass);
						 if (login){
							 JOptionPane.showMessageDialog(null, "Login CORRECTO!!");
						 Ranking.getRanking().cargarLista();
						 if(getTextField().getText().toString().equals("")){
							 Buscaminas.getBuscaminas().establecerNombreJugador("Desconocido");
						 }else{
							 Buscaminas.getBuscaminas().establecerNombreJugador(getTextField().getText());
						 }
						 VBuscaminas vB = new VBuscaminas(Integer.parseInt(getChoice().getSelectedItem()));
						 vB.setVisible(true);
						 setVisible(false);
						 clip.stop();
					 }
						 else{
							 JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO!!");
						 }
					 }
				}
			});
		}
		return btnOk;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre de usuario:");
			lblNombre.setForeground(Color.WHITE);
			
		}
		return lblNombre;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Contrase\u00F1a:");
			lblNewLabel.setForeground(Color.WHITE);
		}
		return lblNewLabel;
	}
	private JLabel getLblDireccinDeCorreo() {
		if (lblDireccinDeCorreo == null) {
			lblDireccinDeCorreo = new JLabel("Direcci\u00F3n de correo electr\u00F3nico:");
			lblDireccinDeCorreo.setForeground(Color.WHITE);
		}
		return lblDireccinDeCorreo;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){}
			});
			btnRegistrarse.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if (e.getButton()==MouseEvent.BUTTON1){
						String usuario=textField.getText();
						String pass=passwordField.getText();
						String email=textField_2.getText();
						boolean correcto = Buscaminas.getBuscaminas().registrarse(usuario, pass, email);
						if (correcto == true){
							JOptionPane.showMessageDialog(null, "REGISTRO CORRECTO!!");
							Ranking.getRanking().cargarLista();
							 if(getTextField().getText().toString().equals("")){
								 Buscaminas.getBuscaminas().establecerNombreJugador("Desconocido");
							 }else{
								 Buscaminas.getBuscaminas().establecerNombreJugador(getTextField().getText());
							 }
							 VBuscaminas vB = new VBuscaminas(Integer.parseInt(getChoice().getSelectedItem()));
							 vB.setVisible(true);
							 setVisible(false);
							 clip.stop();
						}else{
							JOptionPane.showMessageDialog(null, "REGISTRO INCORRECTO , RELLEBA BIEN LOS CAMPOS!!");
						}
						
					}
				}
			});
		}

		return btnRegistrarse;
	}
	private JButton getBtnRecuperarContrasea() {
		if (btnRecuperarContrasea == null) {
			btnRecuperarContrasea = new JButton("Recuperar contrase\u00F1a");
			btnRecuperarContrasea.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){}
			});
			btnRecuperarContrasea.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						if (e.getButton()==MouseEvent.BUTTON1){
							String email=textField_2.getText();
							Buscaminas.getBuscaminas().recuperarContra(email);
						}
					}
			});
		}
					
		return btnRecuperarContrasea;
	}
	
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
		}
		return passwordField;
	}
	private JLabel getLblIntroducirUsuarioY() {
		if (lblIntroducirUsuarioY == null) {
			lblIntroducirUsuarioY = new JLabel("Introducir usuario y contrase\u00F1a para iniciar sesi\u00F3n");
			lblIntroducirUsuarioY.setForeground(Color.WHITE);
			lblIntroducirUsuarioY.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblIntroducirUsuarioY;
	}
	private JLabel getLblIntroducirTambinEmail() {
		if (lblIntroducirTambinEmail == null) {
			lblIntroducirTambinEmail = new JLabel("Introducir tambi\u00E9n email para registrarse");
			lblIntroducirTambinEmail.setForeground(Color.WHITE);
			lblIntroducirTambinEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		return lblIntroducirTambinEmail;
	}
}
