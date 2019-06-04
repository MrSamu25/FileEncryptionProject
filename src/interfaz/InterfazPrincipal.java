package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.DesEncriptadorArchivo;

public class InterfazPrincipal extends JFrame {

	/**
	 * Panel donde se encuentras las funcionalidades de encriptación y
	 * desencriptación.
	 */
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

	/**
	 * @descripcion Conecta los componentes e información de la interfaz de
	 *              encriptación, con las funcionades de encriptación del mundo.
	 * @fecha 29/05/2019.
	 * @param archivoParaEncriptar != null. El archivo que se va a encriptar.
	 * @param semilla              != null. Semilla con la cual se genera una clave
	 *                             para la encripción.
	 * @author Steven M.
	 */
	public void encriptarArchivo(File archivoParaEncriptar, String semilla) {
		try {

			DesEncriptadorArchivo encriptador = new DesEncriptadorArchivo(archivoParaEncriptar, semilla);
			encriptador.encriptar();
			JOptionPane.showMessageDialog(this, "Se encriptó correctamente el archivo " + archivoParaEncriptar.getName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

	}

	/**
	 * @descripcion Conecta los componentes e información de la interfaz de
	 *              desencriptación, con las funcionades de desencriptación del mundo.
	 * @fecha 29/05/2019.
	 * @param archivoParaDesencriptar != null. archivo que se va a desencriptar
	 * @param semilla                 != null. Semilla para poner desencriptar el
	 *                                archivo. Debe ser la misma con la que se
	 *                                encripto el archivo.
	 * @param archivoOriginal         != null. Este es el archivo que contiene el
	 *                                hash con el cual se encriptó el archivo que se
	 *                                va a desencriptar.
	 * @author Steven M.
	 */
	public void desencriptarArchivo(File archivoParaDesencriptar, String semilla, File archivoHash) {
		DesEncriptadorArchivo encriptador;

			try {
				encriptador = new DesEncriptadorArchivo(archivoParaDesencriptar, semilla);
				encriptador.desencriptar(archivoHash);
				JOptionPane.showMessageDialog(this,
						"Se desencriptó correctamente el archivo " + archivoParaDesencriptar.getName());
			} catch (NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException e ) {
				JOptionPane.showMessageDialog(this,
						"La clave semilla ingresada no es correcta o no se adjuntaron los archivos correspondientes");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,
						e.getMessage());
				
			}

			


	}

}