package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener {

	public final static String TITULO_MODO_ENCRIPTAR = "MODO ENCRIPTAR ARCHIVOS";
	public final static String TITULO_MODO_DESENCRIPTAR = "MODO DESENCRIPTAR ARCHIVOS";

	public final static String TOGGLE_BUTTON_ENCRIPTAR = "TOGGLE_BUTTON_ENCRIPTAR";
	public final static String TOGGLE_BUTTON_DESENCRIPTAR = "TOGGLE_BUTTON_DESENCRIPTAR";

	public final static String ESCOGER_ARCHIVO = "ESCOGER_ARCHIVO";

	public final static String ESCOGER_ARCHIVO_ORIGINAL = "ESCOGER_ARCHIVO_ORIGINAL";

	public final static String ENCRIPTAR_DESENCRIPTAR = "ENCRIPTAR_DESENCRIPTAR";

	public final static String MENSAJE_NOMBRE_ARCHIVO = "Nombre archivo";

	public final static String MENSAJE_NOMBRE_ARCHIVO_ORIGINAL = "Nombre archivo original";

	public final static String ENCRIPTAR = "ENCRIPTAR";
	public final static String DESENCRIPTAR = "DESENCRIPTAR ";

	private String modo_funcionalidad;

	private JLabel lab_titulo;
	private JLabel lab_fantasma_1;
	private JLabel lab_fantasma_2;
	private JLabel lab_fantasma_3;
	private JLabel lab_fantasma_4;
	private JLabel lab_fantasma_5;
	private JLabel lab_fantasma_6;

	private JButton tb_switch_encriptar;
	private JButton tb_switch_desencriptar;
	private JButton but_escoger_archivo;
	private JLabel lab_nombre_archivo;

	private JLabel lab_ingresar_semilla;
	private JTextField txt_ingresar_semilla;

	private JButton but_escoger_archivo_original;
	private JLabel lab_nombre_archivo_original;

	private JLabel lab_fantasma_7;
	private JLabel lab_fantasma_8;
	private JLabel lab_fantasma_9;

	private JButton but_encriptar_desencriptar;

	private InterfazPrincipal principal;

	// Atributos
	private JFileChooser fc;

	private File file_encriptar_desencriptar;

	private File file_desencriptar_original;

	public PanelOpciones(InterfazPrincipal principal) {

		this.principal = principal;

		setPreferredSize(new Dimension(380, 370));

		TitledBorder border = BorderFactory.createTitledBorder("Panel Opciones");
		setBorder(border);
		setLayout(new GridBagLayout());

		GridBagConstraints gbc;

		gbc = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_titulo = new JLabel(TITULO_MODO_ENCRIPTAR);
		lab_titulo.setFont(new Font("", Font.BOLD, 20));
		add(lab_titulo, gbc);

		gbc = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_1 = new JLabel("");
		add(lab_fantasma_1, gbc);
		gbc = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_2 = new JLabel("");
		add(lab_fantasma_2, gbc);
		gbc = new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_3 = new JLabel("");
		add(lab_fantasma_3, gbc);
		gbc = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_4 = new JLabel("");
		add(lab_fantasma_4, gbc);
		gbc = new GridBagConstraints(0, 5, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_5 = new JLabel("");
		add(lab_fantasma_5, gbc);

		gbc = new GridBagConstraints(0, 6, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_6 = new JLabel("");
		add(lab_fantasma_6, gbc);

		gbc = new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		tb_switch_encriptar = new JButton("Modo Encriptar");
		tb_switch_encriptar.setActionCommand(TOGGLE_BUTTON_ENCRIPTAR);
		tb_switch_encriptar.addActionListener(this);
		tb_switch_encriptar.setBackground(Color.GREEN);
		add(tb_switch_encriptar, gbc);

		gbc = new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		tb_switch_desencriptar = new JButton("Modo Desencriptar");
		tb_switch_desencriptar.setActionCommand(TOGGLE_BUTTON_DESENCRIPTAR);
		tb_switch_desencriptar.addActionListener(this);
		tb_switch_desencriptar.setBackground(Color.WHITE);
		add(tb_switch_desencriptar, gbc);

		gbc = new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		but_escoger_archivo = new JButton("Seleccionar archivo");
		but_escoger_archivo.setActionCommand(ESCOGER_ARCHIVO);
		but_escoger_archivo.addActionListener(this);
		add(but_escoger_archivo, gbc);

		gbc = new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_nombre_archivo = new JLabel(MENSAJE_NOMBRE_ARCHIVO);
		add(lab_nombre_archivo, gbc);

		gbc = new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_ingresar_semilla = new JLabel("Ingrese la clave semilla");
		add(lab_ingresar_semilla, gbc);

		gbc = new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		txt_ingresar_semilla = new JTextField(5);
		add(txt_ingresar_semilla, gbc);

		gbc = new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		but_escoger_archivo_original = new JButton("Seleccionar archivo original");
		but_escoger_archivo_original.setActionCommand(ESCOGER_ARCHIVO_ORIGINAL);
		but_escoger_archivo_original.addActionListener(this);
		but_escoger_archivo_original.setVisible(false);
		add(but_escoger_archivo_original, gbc);

		gbc = new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_nombre_archivo_original = new JLabel("MENSAJE_NOMBRE_ARCHIVO_ORIGINAL");
		lab_nombre_archivo_original.setVisible(false);
		add(lab_nombre_archivo_original, gbc);

		gbc = new GridBagConstraints(0, 11, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_7 = new JLabel("");
		add(lab_fantasma_7, gbc);
		gbc = new GridBagConstraints(0, 12, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_8 = new JLabel("");
		add(lab_fantasma_8, gbc);
		gbc = new GridBagConstraints(0, 13, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_fantasma_9 = new JLabel("");
		add(lab_fantasma_9, gbc);

		gbc = new GridBagConstraints(0, 14, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		but_encriptar_desencriptar = new JButton(ENCRIPTAR);
		but_encriptar_desencriptar.setActionCommand(ENCRIPTAR_DESENCRIPTAR);
		but_encriptar_desencriptar.addActionListener(this);
		add(but_encriptar_desencriptar, gbc);

		// Default modo ENCRIPTAR
		modo_funcionalidad = ENCRIPTAR;

		fc = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();

		switch (comando) {

		case TOGGLE_BUTTON_ENCRIPTAR:

			tb_switch_encriptar.setBackground(Color.GREEN);
			tb_switch_desencriptar.setBackground(Color.WHITE);

			but_escoger_archivo_original.setVisible(false);
			lab_nombre_archivo_original.setVisible(false);

			lab_titulo.setText(TITULO_MODO_ENCRIPTAR);
			but_encriptar_desencriptar.setText(ENCRIPTAR);

			// Pasa a modo ENCRIPTAR
			modo_funcionalidad = ENCRIPTAR;

			reiniciarTodo();
			break;

		case TOGGLE_BUTTON_DESENCRIPTAR:

			tb_switch_desencriptar.setBackground(Color.GREEN);
			tb_switch_encriptar.setBackground(Color.WHITE);

			but_escoger_archivo_original.setVisible(true);
			lab_nombre_archivo_original.setVisible(true);

			lab_titulo.setText(TITULO_MODO_DESENCRIPTAR);
			but_encriptar_desencriptar.setText(DESENCRIPTAR);

			// Pasa a modo DESENCRIPTAR
			modo_funcionalidad = DESENCRIPTAR;

			reiniciarTodo();
			break;

		case ESCOGER_ARCHIVO:
			seleccionarArchivoPrincipal();
			break;

		case ESCOGER_ARCHIVO_ORIGINAL:
			seleccionarArchivoSecundario();
			break;

		case ENCRIPTAR_DESENCRIPTAR:

			if (modo_funcionalidad.equals(ENCRIPTAR)) {

				if(verificarCamposCompletosEncriptar()) {
					principal.encriptarArchivo(file_encriptar_desencriptar, txt_ingresar_semilla.getText());
				}
				
			}

			else if (modo_funcionalidad.equals(DESENCRIPTAR)) {
				
				if(verificarCamposCompletosDesencriptar()) {
					principal.desencriptarArchivo(file_encriptar_desencriptar, txt_ingresar_semilla.getText(), file_desencriptar_original);
				}
				
			}

			break;
		}

	}

	public boolean verificarCamposCompletosEncriptar() {

		boolean completos = true;

		if (file_encriptar_desencriptar == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}

		else if (txt_ingresar_semilla.getText().equals("") || txt_ingresar_semilla.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla para encriptar/desencriptar", "Error", JOptionPane.ERROR_MESSAGE);
			completos = false;
		}

		return completos;
	}

	public boolean verificarCamposCompletosDesencriptar() {

		boolean completos = true;

		if (file_encriptar_desencriptar == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}

		else if (txt_ingresar_semilla.getText().equals("") || txt_ingresar_semilla.getText().trim().equals("")) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla para encriptar/desencriptar", "Error", JOptionPane.ERROR_MESSAGE);
		} 
		
		else if (file_desencriptar_original == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar el archivo original para verificar Hash", "Error", JOptionPane.ERROR_MESSAGE);
		}

		return completos;
	}

	
	//Esto es el archivo principal para encriptarlo o desencriptarlo
	public void seleccionarArchivoPrincipal() {

		int returnVal = fc.showOpenDialog(PanelOpciones.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file_encriptar_desencriptar = fc.getSelectedFile();

			lab_nombre_archivo.setText(file_encriptar_desencriptar.getName());

		} else {
			// System.out.println("Open command cancelled by user.");
		}

	}

	// Esto es el archivo secundario para sacar el hash
	public void seleccionarArchivoSecundario() {

		int returnVal = fc.showOpenDialog(PanelOpciones.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file_desencriptar_original = fc.getSelectedFile();

			lab_nombre_archivo_original.setText(file_desencriptar_original.getName());

		} else {
			// System.out.println("Open command cancelled by user.");
		}

	}

	public void reiniciarTodo() {

		lab_nombre_archivo.setText(MENSAJE_NOMBRE_ARCHIVO);
		txt_ingresar_semilla.setText("");
		lab_nombre_archivo_original.setText(MENSAJE_NOMBRE_ARCHIVO_ORIGINAL);

		file_encriptar_desencriptar = null;
		file_desencriptar_original = null;

	}

}
