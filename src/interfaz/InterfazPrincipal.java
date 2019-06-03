package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.DesEncriptadorArchivo;

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
		try {

			DesEncriptadorArchivo encriptador = new DesEncriptadorArchivo(archivoParaEncriptar, semilla);
			encriptador.encriptar();
			JOptionPane.showMessageDialog(this, "Se encripto correctante el archivo "+ archivoParaEncriptar.getName());
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, e);
		}

	}


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
	public void desencriptarArchivo(File archivoParaDesencriptar, String semilla, File archivoHash) {
		DesEncriptadorArchivo encriptador;
		try {
			encriptador = new DesEncriptadorArchivo(archivoParaDesencriptar, semilla);
			encriptador.desencriptar(archivoHash);
			JOptionPane.showMessageDialog(this, "Se desencripto correctante el archivo "+ archivoParaDesencriptar.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e);
		}

	}

}