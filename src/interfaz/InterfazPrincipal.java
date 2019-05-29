package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame {

	private PanelOpciones panelOpciones;

	public static void main(String[] args) {
		InterfazPrincipal interfazPrincipal = new InterfazPrincipal();
		interfazPrincipal.setVisible(true);
	}

	public InterfazPrincipal() {

		setSize(new Dimension(380, 400));
		setTitle("Proyecto final Ciberseguridad - Ana Arango, Steven Muriel, Jhoan Delgado");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.NORTH);

	}

	// AQUÍ SE LLAMA AL MUNDO
	/**
	 * 
	 * @param archivoParaEncriptar != null. El archivo que se va a encriptar. El
	 *                             archivo resultante (encriptado) se puede dejar en
	 *                             una ruta por defecto para hacer más fácil las
	 *                             cosas.
	 * @param semilla              != null. Semilla con la cual se encripta.
	 */
	public void encriptarArchivo(File archivoParaEncriptar, String semilla) {

	}

	// AQUÍ SE LLAMA AL MUNDO

	/**
	 * 
	 * @param archivoParaDesencriptar != null. Lo debe desencriptar y dejar el
	 *                                archivo resultante (encriptado) en una ruta
	 *                                --> ¿por defecto (una ruta default para
	 *                                hacerlo más facil)?
	 * @param semilla                 != null. Semilla para poner desencriptar el
	 *                                archivo. Debe ser la misma con la que se
	 *                                encripto el archivo.
	 * @param archivoOriginal         != null. Este es el archivo original para de
	 *                                él obtener el hash y poder comparar con el
	 *                                hash obtenido cuando se desencripta. Si son
	 *                                iguales la operación fue un éxito. No errores
	 *                                desencriptando.
	 */
	public void desencriptarArchivo(File archivoParaDesencriptar, String semilla, File archivoOriginal) {
		
	}

}