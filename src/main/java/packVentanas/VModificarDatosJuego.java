package packVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class VModificarDatosJuego extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblUsuario;
	private JComboBox comboBox_1;
	private JButton btnModificarNivel;
	private JLabel lblNumeroDeBombas;
	private JLabel lblNivel;
	private JComboBox comboBox_3;
	private JButton btnModificarDificuldad;
	private JTextField textField;
	private JPanel panel_2;
	private JButton btnModificarDimensiones;
	private JLabel lblDimx;
	private JLabel lblDimy;
	private JTextField textField_1;
	private JTextField textField_2;
	private JEditorPane dtrpnElJuegoConsiste;
	private JLabel lblAyuda;
	private JButton btnModificarAyuda;
	private JButton btnVolvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModificarDatosJuego frame = new VModificarDatosJuego();
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
	public VModificarDatosJuego() {
		initialize();
	}
	private void initialize() {
		setTitle("Modificar datos del juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnVolvar());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getComboBox());
			panel_1.add(getLblUsuario());
			panel_1.add(getComboBox_1());
			panel_1.add(getBtnModificarNivel());
			panel_1.add(getPanel_2());
			panel_1.add(getDtrpnElJuegoConsiste());
			panel_1.add(getLblAyuda());
			panel_1.add(getBtnModificarAyuda());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nivel inicial:");
			lblNewLabel.setBounds(251, 17, 78, 32);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Borja", "Ivan", "Janire", "Jon", "Rodrigo", "Vitor "}));
			comboBox.setBounds(83, 21, 169, 27);
		}
		return comboBox;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(24, 25, 61, 16);
		}
		return lblUsuario;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			comboBox_1.setBounds(337, 21, 64, 27);
		}
		return comboBox_1;
	}
	private JButton getBtnModificarNivel() {
		if (btnModificarNivel == null) {
			btnModificarNivel = new JButton("Modificar nivel");
			btnModificarNivel.setBounds(401, 20, 117, 29);
		}
		return btnModificarNivel;
	}
	private JLabel getLblNumeroDeBombas() {
		if (lblNumeroDeBombas == null) {
			lblNumeroDeBombas = new JLabel("Número de minas:");
			lblNumeroDeBombas.setBounds(115, 29, 137, 32);
		}
		return lblNumeroDeBombas;
	}
	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Nivel:");
			lblNivel.setBounds(11, 32, 36, 27);
		}
		return lblNivel;
	}
	private JComboBox getComboBox_3() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox();
			comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			comboBox_3.setBounds(50, 35, 61, 27);
		}
		return comboBox_3;
	}
	private JButton getBtnModificarDificuldad() {
		if (btnModificarDificuldad == null) {
			btnModificarDificuldad = new JButton("Modificar dificuldad");
			btnModificarDificuldad.setBounds(338, 32, 156, 29);
		}
		return btnModificarDificuldad;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setText("10");
			textField.setBounds(260, 32, 66, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(24, 61, 499, 145);
			panel_2.setLayout(null);
			panel_2.add(getLblNumeroDeBombas());
			panel_2.add(getLblNivel());
			panel_2.add(getComboBox_3());
			panel_2.add(getBtnModificarDificuldad());
			panel_2.add(getTextField_1());
			panel_2.add(getBtnModificarDimensiones());
			panel_2.add(getLblDimx());
			panel_2.add(getLblDimy());
			panel_2.add(getTextField_1_1());
			panel_2.add(getTextField_2());
		}
		return panel_2;
	}
	private JButton getBtnModificarDimensiones() {
		if (btnModificarDimensiones == null) {
			btnModificarDimensiones = new JButton("Modificar dimensiones");
			btnModificarDimensiones.setBounds(326, 97, 167, 29);
		}
		return btnModificarDimensiones;
	}
	private JLabel getLblDimx() {
		if (lblDimx == null) {
			lblDimx = new JLabel("DimX:");
			lblDimx.setBounds(11, 102, 61, 16);
		}
		return lblDimx;
	}
	private JLabel getLblDimy() {
		if (lblDimy == null) {
			lblDimy = new JLabel("DimY:");
			lblDimy.setBounds(115, 102, 44, 16);
		}
		return lblDimy;
	}
	private JTextField getTextField_1_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("10");
			textField_1.setBounds(59, 97, 52, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setText("7");
			textField_2.setBounds(156, 97, 52, 26);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JEditorPane getDtrpnElJuegoConsiste() {
		if (dtrpnElJuegoConsiste == null) {
			dtrpnElJuegoConsiste = new JEditorPane();
			dtrpnElJuegoConsiste.setToolTipText("");
			dtrpnElJuegoConsiste.setText("El juego consiste en despejar todas las casillas de \nuna pantalla que no oculten una mina.\nAlgunas casillas tienen un n�mero, el cual indica la\ncantidad de minas que hay en las casillas\ncircundantes.\nAs�, si una casilla tiene el n�mero 3, significa que de\nlas ocho casillas que hay alrededor (si no es en una\nesquina o borde) hay 3 con minas y 5 sin minas.\nSi se descubre una casilla sin n�mero indica que\nninguna de las casillas vecinas tiene mina y\n�stas se descubren autom�ticamente.\nSi se descubre una casilla con una mina se pierde\nla partida.\nSe puede poner una marca en las casillas que el\njugador piensa que hay minas para ayudar a\ndescubrir las que est�n cerca.");
			dtrpnElJuegoConsiste.setBounds(83, 218, 305, 58);
		}
		return dtrpnElJuegoConsiste;
	}
	private JLabel getLblAyuda() {
		if (lblAyuda == null) {
			lblAyuda = new JLabel("Ayuda:");
			lblAyuda.setBounds(24, 218, 61, 16);
		}
		return lblAyuda;
	}
	private JButton getBtnModificarAyuda() {
		if (btnModificarAyuda == null) {
			btnModificarAyuda = new JButton("Modificar ayuda");
			btnModificarAyuda.setBounds(389, 232, 134, 29);
		}
		return btnModificarAyuda;
	}
	private JButton getBtnVolvar() {
		if (btnVolvar == null) {
			btnVolvar = new JButton("Volver");
		}
		return btnVolvar;
	}
}
