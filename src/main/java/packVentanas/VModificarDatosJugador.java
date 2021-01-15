package packVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class VModificarDatosJugador extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblUsuarios;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JEditorPane dtrpnPepitoGrillo;
	private JLabel lblNivelInicial;
	private JComboBox comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VModificarDatosJugador frame = new VModificarDatosJugador();
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
	public VModificarDatosJugador() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
		contentPane.add(getPanel_2(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLblUsuarios());
			panel.add(getComboBox());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getDtrpnPepitoGrillo());
			panel_1.add(getLblNivelInicial());
			panel_1.add(getComboBox_1());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.add(getBtnNewButton());
			panel_2.add(getBtnNewButton_1());
			panel_2.add(getBtnNewButton_2());
		}
		return panel_2;
	}
	private JLabel getLblUsuarios() {
		if (lblUsuarios == null) {
			lblUsuarios = new JLabel("Usuarios:");
		}
		return lblUsuarios;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"email1@server.com", "email2@server.com", "email3@server.com", "email4@server.com", "email5@server.com", "email6@server.com", "email7@server.com", "email8@server.com"}));
		}
		return comboBox;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Volver");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Editar datos");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Borrar jugador");
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre usuario:");
			lblNewLabel.setBounds(72, 51, 108, 23);
		}
		return lblNewLabel;
	}
	private JEditorPane getDtrpnPepitoGrillo() {
		if (dtrpnPepitoGrillo == null) {
			dtrpnPepitoGrillo = new JEditorPane();
			dtrpnPepitoGrillo.setText("Pepito grillo");
			dtrpnPepitoGrillo.setBounds(203, 51, 157, 23);
		}
		return dtrpnPepitoGrillo;
	}
	private JLabel getLblNivelInicial() {
		if (lblNivelInicial == null) {
			lblNivelInicial = new JLabel("Nivel inicial:");
			lblNivelInicial.setBounds(72, 90, 78, 16);
		}
		return lblNivelInicial;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
			comboBox_1.setBounds(203, 86, 67, 27);
		}
		return comboBox_1;
	}
}
