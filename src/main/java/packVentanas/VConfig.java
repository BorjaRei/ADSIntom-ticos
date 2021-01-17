package packVentanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import packCodigo.Buscaminas;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JRadioButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.json.*;

public class VConfig extends JFrame {
	private String user;
	private JPanel contentPane;
	private JRadioButton mina1;
	private JRadioButton mina2;
	private JRadioButton mina3;
	private JRadioButton sonido1;
	private JRadioButton sonido2;
	private JRadioButton sonido3;
	private JButton botonSonido1;
	private JButton botonSonido2;
	private JButton botonSonido3;
	private JButton guardarCambios;
	private ButtonGroup mina=new ButtonGroup();
	private ButtonGroup sonido=new ButtonGroup();
	private AudioInputStream ais;
	private Clip clip;
	private JTextField textField;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;
	private JLabel fotomina1;
	private JLabel fotomina2;
	private JLabel fotomina3;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VConfig frame = new VConfig();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(10dlu;min):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(66dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.MIN_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.MIN_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Hacer llamada a BD para coger configuracion actual
		//JSONObject js=gestorBD.getMigestorBD().getConfig("Prueba");
	
		//Insertar los botones y labels 
		//SE PASA LA CONFIGURACION ACTUAL COMO PARAMETRO PARA PRESELECCIONARLO
		/*inciarMinas(js.getInt("Mina"));
		iniciarSonidos(js.getInt("Sonido"));
		iniciarIcono(js.getString("Icono"));
		*/
		inciarMinas(1);
		iniciarSonidos(1);
		iniciarIcono("OA");
		
		guardarCambios = new JButton("Guardar Cambios");
		contentPane.add(guardarCambios, "8, 22, 13, 1");
		guardarCambios.addActionListener(new ControladorGuardar());
	}
	
	private void inciarMinas(int pValor) {
		JLabel lblNewLabel = new JLabel("Personalizar Mina");
		contentPane.add(lblNewLabel, "2, 2, 15, 1");
		
	
		//INSERTANDO LAS IMAGENES
		ImageIcon img1 = new ImageIcon("src/main/resources/mina1.png");
		 
		fotomina1 = new JLabel("");
		fotomina1.setIcon(img1);

		contentPane.add(fotomina1, "8, 4, left, default");
		
		ImageIcon img2 = new ImageIcon("src/main/resources/mina2.png");
		fotomina2 = new JLabel("");
		fotomina2.setIcon(img2);
	
		contentPane.add(fotomina2, "14, 4, center, center");
		
		ImageIcon img3 = new ImageIcon("src/main/resources/mina3.png");
		fotomina3 = new JLabel("");
		fotomina3.setIcon(img3);
		
		contentPane.add(fotomina3, "20, 4, center, center");
		
		
		//INSERTANDO  LOS RADIO BUTTONS
		
		
		//Mina 1
		mina1 = new JRadioButton();
		contentPane.add(mina1, "8, 8, center, default");
		mina1.setName("1");
		
		//Mina 2
		mina2= new JRadioButton();
		contentPane.add(mina2, "14, 8, center, default");
		
		//Mina 3
		mina3= new JRadioButton();
		contentPane.add(mina3, "20, 8, center, default");
		//GRUPO DE BOTONES DE MINA
		mina.add(mina1);
		mina.add(mina2);
		mina.add(mina3);
		
		//ACTIVAR CONFIGURACION ACTUAL
		if(pValor==1) {
			mina1.setSelected(true);
		}
		else if(pValor==2) {
			mina2.setSelected(true);
		}
		else if(pValor==3) {
			mina3.setSelected(true);
		}
	
		

	}

	private void iniciarSonidos(int pValor) {
		JLabel lblNewLabel_2 = new JLabel("Personalizar sonido");
		contentPane.add(lblNewLabel_2, "2, 10, 17, 1");
		
		//S1
		botonSonido1 = new JButton("S1");
		contentPane.add(botonSonido1, "8, 12");
		botonSonido1.addActionListener(new ControladorSonido(1));
		
		//S2
		botonSonido2 = new JButton("S2");
		contentPane.add(botonSonido2, "14, 12");
		botonSonido2.addActionListener(new ControladorSonido(2));
		
		//S3
		botonSonido3= new JButton("S3");
		contentPane.add(botonSonido3, "20, 12");
		botonSonido3.addActionListener(new ControladorSonido(3));
		
		//Sonido 1
		sonido1 = new JRadioButton("");
		contentPane.add(sonido1, "8, 14, center, default");
		
		
		sonido.add(sonido1);
		
		
		//Sonido 2
		sonido2 = new JRadioButton("");
		contentPane.add(sonido2, "14, 14, center, default");
		
		//Sonido 3
		sonido3 = new JRadioButton("");
		contentPane.add(sonido3, "20, 14, center, default");
		sonido.add(sonido2);
		sonido.add(sonido3);
		
		
	/// ACTIVAR CONFIGURACION ACTUAL
		if(pValor==1) {
			sonido1.setSelected(true);
		}
		else if(pValor==2) {
			sonido2.setSelected(true);
		}
		else if(pValor==3) {
			sonido3.setSelected(true);
		}
	}
	
	private void iniciarIcono(String pPath) {
		JLabel lblNewLabel_1 = new JLabel("Personalizar Icono Usuario");
		contentPane.add(lblNewLabel_1, "2, 16, 7, 1");
		
		lblNewLabel_6 = new JLabel("Path:");
		contentPane.add(lblNewLabel_6, "4, 18");
		
		textField = new JTextField();
		contentPane.add(textField, "8, 18, 13, 1, fill, default");
		textField.setColumns(10);
		
		textField.setText(pPath);
		
	}
	
	


private class ControladorSonido implements ActionListener{

	private int numero;
	public ControladorSonido(int i) {
		super();
		numero=i;
	}
	public void actionPerformed(ActionEvent e) {
		String ruta="src/main/resources/sonido"+numero+".wav";
		try {
			clip.close();
		}
		catch(Exception f) {
			
		}
			try {
				ais = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
			} catch (UnsupportedAudioFileException ew) {
				ew.printStackTrace();
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			try {
				clip = AudioSystem.getClip();
			} catch (LineUnavailableException eee) {
				eee.printStackTrace();
			}
			try {
				clip.open(ais);
			} catch (LineUnavailableException eq) {
				eq.printStackTrace();
			} catch (IOException eqq) {
				eqq.printStackTrace();
			}
		
		clip.start();
		
		
	}
}

private class ControladorGuardar implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int pMina;
		int pSonido;
		String pIcono;
		
		//Comrobar que boton esta seleccionado
		if(mina1.isSelected()) {
			pMina=1;
		}
		else if(mina2.isSelected()) {
			pMina=2;
		}
		else {
			pMina=3;
		}
		//Comrobar que boton esta seleccionado
		if(sonido1.isSelected()) {
			pSonido=1;
		}
		else if(sonido2.isSelected()) {
			pSonido=2;
		}
		
		else {
			pSonido=3;
		}
		
		pIcono=textField.getText();
		
		Buscaminas.getBuscaminas().guardarConf( pMina, pSonido, pIcono);
		
	}
}
	
}
