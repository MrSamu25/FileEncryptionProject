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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import javafx.geometry.Pos;

public class PanelOpciones extends JPanel implements ActionListener {

	/**
	 * Cadena que indica la funcionalidad actual del sistema es encriptar archivos
	 */
	public final static String TITULO_MODO_ENCRIPTAR = "MODO ENCRIPTAR ARCHIVOS";

	/**
	 * Cadena que indica la funcionalidad actual del sistema es desencriptar
	 * archivos
	 */
	public final static String TITULO_MODO_DESENCRIPTAR = "MODO DESENCRIPTAR ARCHIVOS";

	/**
	 * Cadena utilizada para identificar cuando el botón toggle de encriptar fue
	 * presionado
	 */
	public final static String TOGGLE_BUTTON_ENCRIPTAR = "TOGGLE_BUTTON_ENCRIPTAR";

	/**
	 * Cadena utilizada para identificar cuando el botón toggle de encriptar fue
	 * presionado
	 */
	public final static String TOGGLE_BUTTON_DESENCRIPTAR = "TOGGLE_BUTTON_DESENCRIPTAR";

	/**
	 * Cadena utilizada para identificar cuando el botón escoger archivo fue
	 * presionado
	 */
	public final static String ESCOGER_ARCHIVO = "ESCOGER_ARCHIVO";

	/**
	 * Cadena utilizada para identificar cuando el botón escoger archivo hash fue
	 * presionado
	 */
	public final static String ESCOGER_ARCHIVO_ORIGINAL = "ESCOGER_ARCHIVO_ORIGINAL";

	/**
	 * Cadena utilizada para identificar cuando el botón de encriptar/desencriptar
	 * (dependiendo del modo actual) fue presionado
	 */
	public final static String ENCRIPTAR_DESENCRIPTAR = "ENCRIPTAR_DESENCRIPTAR";

	/**
	 * Nombre del archivo que fue seleccionado para encriptar/desencriptar
	 */
	public final static String MENSAJE_NOMBRE_ARCHIVO = "Nombre archivo";

	/**
	 * Nombre del archivo hash usado para desencriptar un archivo seleccionado
	 */
	public final static String MENSAJE_NOMBRE_ARCHIVO_HASH = "Nombre archivo hash";

	/**
	 * Posible funcionalidad actual del sistema - ENCRIPTAR
	 */
	public final static String ENCRIPTAR = "ENCRIPTAR";

	/**
	 * Posible funcionalidad actual del sistema - DESENCRIPTAR
	 */
	public final static String DESENCRIPTAR = "DESENCRIPTAR ";

	/**
	 * Varible donde se guarda la funcionalidad actual del sistema (ENCRIPTAR o
	 * DESENCRIPTAR)
	 */
	private String modo_funcionalidad;

	/**
	 * Componente de interfaz donde se muestra la funcionalidad actual del sistema
	 */
	private JLabel lab_titulo;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_1;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_2;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_3;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_4;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_5;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_6;

	/**
	 * Botón que alterna a modo encriptar archivos
	 */
	private JButton tb_switch_encriptar;

	/**
	 * Botón que alterna a modo desencriptar archivos
	 */
	private JButton tb_switch_desencriptar;

	/**
	 * Botón para escoger el archivo a encriptar/descencriptar
	 */
	private JButton but_escoger_archivo;

	/**
	 * Label donde se muestra el archivo seleccionado para encriptar/descencriptar
	 */
	private JLabel lab_nombre_archivo;

	/**
	 * Label que indica que se debe ingresar la semilla para la clave de
	 * encriptación y desencriptación
	 */
	private JLabel lab_ingresar_semilla;

	/**
	 * Campo de texto donde se ingresa la semilla para la clave de encriptación y
	 * desencriptación
	 */
	private JPasswordField txt_ingresar_semilla;

	/**
	 * Botón para seleccionar el archivo donde se encuentra el hash como resultado
	 * de la encriptación
	 */
	private JButton but_escoger_archivo_hash;

	/**
	 * Label que indica el nombre del arhivo hash escogido
	 */
	private JLabel lab_nombre_archivo_original;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_7;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_8;

	/**
	 * Componente secundario de la interfaz utilizado para ordernar otros elementos
	 */
	private JLabel lab_fantasma_9;

	/**
	 * Botón que inicia la funcionalidad de encriptar/desencriptar dependiendo del
	 * modo actual del sistema
	 */
	private JButton but_encriptar_desencriptar;

	/**
	 * Referencia a la interfaz principal
	 */
	private InterfazPrincipal principal;

	/**
	 * FileChooser con el cual se selecciona archivos del sistema
	 */
	private JFileChooser fc;

	/**
	 * Archivo que se va a encriptar/desencriptar
	 */
	private File file_encriptar_desencriptar;

	/**
	 * Archivo que contiene el hash de encriptación
	 */
	private File file_hash;

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
		txt_ingresar_semilla = new JPasswordField(5);
		add(txt_ingresar_semilla, gbc);

		gbc = new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		but_escoger_archivo_hash = new JButton("Seleccionar archivo hash");
		but_escoger_archivo_hash.setActionCommand(ESCOGER_ARCHIVO_ORIGINAL);
		but_escoger_archivo_hash.addActionListener(this);
		but_escoger_archivo_hash.setVisible(false);
		add(but_escoger_archivo_hash, gbc);

		gbc = new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0);
		lab_nombre_archivo_original = new JLabel(MENSAJE_NOMBRE_ARCHIVO_HASH);
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

	/**
	 * @descripcion Identifica cual de los componentes activo un evento en la interfaz.
	 * @fecha 29/05/2019.
	 * @pos Se realizan las funcionalidades asociadas al componente que generó un evento en la interfaz.
	 * @author Steven M.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();

		switch (comando) {

		case TOGGLE_BUTTON_ENCRIPTAR:

			cambiarFuncionalidadEncriptar();
			reiniciarTodo();
			break;

		case TOGGLE_BUTTON_DESENCRIPTAR:

			cambiarFuncionalidadDesencriptar();
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

				if (verificarCamposCompletosEncriptar()) {
					principal.encriptarArchivo(file_encriptar_desencriptar, txt_ingresar_semilla.getText());
					reiniciarTodo();
				}
			}

			else if (modo_funcionalidad.equals(DESENCRIPTAR)) {

				if (verificarCamposCompletosDesencriptar()) {
					principal.desencriptarArchivo(file_encriptar_desencriptar, txt_ingresar_semilla.getText(),
							file_hash);
					reiniciarTodo();
				}
			}

			break;
		}

	}

	/**
	 * @descripcion método que cambia la interfaz a modo encriptación.
	 * @fecha 29/05/2019.
	 * @pos Se ocultan los componentes que no son necesarios para el modo de
	 *      encriptar y se visibilian aquellos que si.
	 * @author Steven M.
	 */
	public void cambiarFuncionalidadEncriptar() {
		tb_switch_encriptar.setBackground(Color.GREEN);
		tb_switch_desencriptar.setBackground(Color.WHITE);

		but_escoger_archivo_hash.setVisible(false);
		lab_nombre_archivo_original.setVisible(false);

		lab_titulo.setText(TITULO_MODO_ENCRIPTAR);
		but_encriptar_desencriptar.setText(ENCRIPTAR);

		// Pasa a modo ENCRIPTAR
		modo_funcionalidad = ENCRIPTAR;
	}

	/**
	 * @descripcion método que cambia la interfaz a modo desencriptación.
	 * @fecha 29/05/2019.
	 * @pos Se ocultan los componentes que no son necesarios para el modo de
	 *      desencriptar y se visibilizan aquellos que si.
	 * @author Steven M.
	 */
	public void cambiarFuncionalidadDesencriptar() {

		tb_switch_desencriptar.setBackground(Color.GREEN);
		tb_switch_encriptar.setBackground(Color.WHITE);

		but_escoger_archivo_hash.setVisible(true);
		lab_nombre_archivo_original.setVisible(true);

		lab_titulo.setText(TITULO_MODO_DESENCRIPTAR);
		but_encriptar_desencriptar.setText(DESENCRIPTAR);

		// Pasa a modo DESENCRIPTAR
		modo_funcionalidad = DESENCRIPTAR;
	}

	/**
	 * @descripcion Verifica que los campos necesarios para encriptar un archivo
	 *              esten completos.
	 * @fecha 29/05/2019.
	 * @pos Todos los campos necesarios para la encriptación de un archivo están
	 *      completos.
	 * @return true si todos los campos están completos, false en caso contrario.
	 * @author Steven M.
	 */
	public boolean verificarCamposCompletosEncriptar() {

		boolean completos = true;

		if (file_encriptar_desencriptar == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}

		else if (txt_ingresar_semilla.getText().equals("") || txt_ingresar_semilla.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla para encriptar/desencriptar", "Error",
					JOptionPane.ERROR_MESSAGE);
			completos = false;
		}

		return completos;
	}

	/**
	 * @descripcion Verifica que los campos necesarios para desencriptar un archivo
	 *              esten completos.
	 * @fecha 29/05/2019
	 * @pos Todos los campos necesarios para la desencriptación de un archivo están
	 *      completos.
	 * @return true si todos los campos están completos, false en caso contrario.
	 * @author Steven M.
	 */
	public boolean verificarCamposCompletosDesencriptar() {

		boolean completos = true;

		if (file_encriptar_desencriptar == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo", "Error", JOptionPane.ERROR_MESSAGE);
		}

		else if (txt_ingresar_semilla.getText().equals("") || txt_ingresar_semilla.getText().trim().equals("")) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe ingresar una semilla para encriptar/desencriptar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		else if (file_hash == null) {
			completos = false;
			JOptionPane.showMessageDialog(null, "Debe seleccionar el archivo hash de encriptación ", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return completos;
	}

	/**
	 * @descripcion Permite seleccionar el archivo que va a ser
	 *              encriptado/desencriptado.
	 * @fecha 29/05/2019.
	 * @pos El archivo que va a ser encriptado/desencriptado es almacenado en la
	 *      variable file_encriptar_desencriptar. El nombre del archivo seleccionado
	 *      aparece en la interfaz.
	 * @author Steven M.
	 */
	public void seleccionarArchivoPrincipal() {

		int returnVal = fc.showOpenDialog(PanelOpciones.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file_encriptar_desencriptar = fc.getSelectedFile();

			lab_nombre_archivo.setText(file_encriptar_desencriptar.getName());

		} else {
			// System.out.println("Open command cancelled by user.");
		}

	}

	/**
	 * @descripcion Permite seleccionar el archivo que contiene el hash para
	 *              comprobar la desencriptación.
	 * @fecha 29/05/2019.
	 * @pos El archivo hash es almacenado en la variable file_hash. El nombre del
	 *      archivo hash seleccionado aparece en la interfaz.
	 * @author Steven M.
	 */
	public void seleccionarArchivoSecundario() {

		int returnVal = fc.showOpenDialog(PanelOpciones.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file_hash = fc.getSelectedFile();

			lab_nombre_archivo_original.setText(file_hash.getName());

		} else {
			// System.out.println("Open command cancelled by user.");
		}

	}

	/**
	 * @descripcion Permite limpiar todos los campos ingresados para que el usuario
	 *              pueda nuevamente usar la funcionalidad de encriptar o
	 *              desencriptar.
	 * @fecha 29/05/2019.
	 * @pos Los campos del nombre del archivo seleccionado, semilla para la clave y
	 *      nombre hash están limpias. Las variables file_encriptar_desencriptar y
	 *      file_hash quedan vacias a esperan de una nueva selección de archivos.
	 * @author Steven M.
	 */
	public void reiniciarTodo() {

		lab_nombre_archivo.setText(MENSAJE_NOMBRE_ARCHIVO);
		txt_ingresar_semilla.setText("");
		lab_nombre_archivo_original.setText(MENSAJE_NOMBRE_ARCHIVO_HASH);

		file_encriptar_desencriptar = null;
		file_hash = null;

	}

}
