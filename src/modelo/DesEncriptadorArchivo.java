package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Clase que facilita la encriptación y desencriptación de archivos
 * 
 */
public class DesEncriptadorArchivo {
	public final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	
	/**
	 * ruta del archivo que se quiere encriptar o desencriptar
	 */
	private File ruta;
	
	/**
	 * clave con la que se va a encriptar o desencriptar el archivo
	 */
	private SecretKey claveSecreta;
	
	/**
	 * palabra base con la que se va a generar la clave
	 */
	private String clave;
	
	/**
	 * sal utilizada para generar la clave
	 */
	private byte[] salt;

	public DesEncriptadorArchivo(File rutaArchivo, String claveSecreta)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		this.ruta = rutaArchivo;
		generarClave(claveSecreta);

	}
	
	/**
	 * @descripcion genera la clave para comenzar la encriptación, teniendo en cuenta la palabra ingresada como parametro
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @param clave palabra base para generar la clave
	 */

	private void generarClave(String clave) throws NoSuchAlgorithmException, InvalidKeySpecException {
		Random srandom = new Random();
		this.clave = clave;
		salt = new byte[8];
		srandom.nextBytes(salt);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(clave.toCharArray(), salt, 10000, 128);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec skey = new SecretKeySpec(tmp.getEncoded(), "AES");

		this.claveSecreta = skey;

	}

	/**
	 * @descripcion metodo que encripta el archivo especificado en el atributo ruta de la clase
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @pos se crea el archivo encriptado en la misma carpeta donde se encuentra el archivo original
	 */
	public void encriptar() throws Exception {

		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		cipher.init(Cipher.ENCRYPT_MODE, claveSecreta);
		byte[] iv = cipher.getIV();
		FileOutputStream out = new FileOutputStream(ruta + ".enc");
		FileOutputStream outhash = new FileOutputStream(ruta + ".hashValue");
		out.write(salt);
		out.write(iv);
		outhash.write(hashValue(ruta).getBytes());
		try (FileInputStream in = new FileInputStream(ruta)) {
			procesarArchivo(cipher, in, out);
		}

	}
	
	/**
	 * @descripcion metodo que desencripta el archivo especificado en el atributo ruta de la clase
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @param archivo que contiene el hash del archivo original antes de haber sido encriptado
	 * @pos se crea el archivo ya desencriptado en la misma carpeta donde se encuentra el archivo encriptado
	 */

	public void desencriptar(File archivoHash) throws Exception {
		FileInputStream in = new FileInputStream(ruta);
		byte[] salt = new byte[8], iv = new byte[128 / 8];
		in.read(salt);
		in.read(iv);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(clave.toCharArray(), salt, 10000, 128);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec skey = new SecretKeySpec(tmp.getEncoded(), "AES");

		Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
		ci.init(Cipher.DECRYPT_MODE, skey, new IvParameterSpec(iv));
		try (FileOutputStream out = new FileOutputStream(ruta + ".des")) {
			procesarArchivo(ci, in, out);

		}
		File des = new File(ruta + ".des");
		if(!(compararHashes(hashValue(des), archivoHash))){
			throw new Exception("El hash del archivo desencriptado no es igual al hash del archivo original");
		}

	}
	
	/**
	 * @descripcion metodo que lee un archivo que se desea encriptar o desencriptar, y crea otro archivo que contiene la información ya cifrada o descifrada
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @param ci cifrador que permite encriptar o desencriptar la información leída
	 * @param in flujo de entrada de bytes del archivo que se requiere leer
	 * @param out flujo de salida de bytes del archivo que se va a crear
	 * de se encuentra el archivo encriptado
	 */
	private void procesarArchivo(Cipher ci, InputStream in, OutputStream out)
			throws javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, java.io.IOException {
		byte[] ibytes = new byte[1024];
		int len;
		while ((len = in.read(ibytes)) != -1) {
			byte[] obytes = ci.update(ibytes, 0, len);
			if (obytes != null)
				out.write(obytes);
		}
		byte[] obytes = ci.doFinal();
		if (obytes != null)
			out.write(obytes);
	}

	/**
	 * @descripcion metodo que calcula el hash sha1 del contenido del archivo que ingresa como parámetro
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @param archivo al cual se le quiere calcular el hash sha1 que permite encriptar la información leída
	 * de se encuentra el archivo encriptado
	 */
	public String hashValue(File archivo) throws Exception {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		FileInputStream in = new FileInputStream(archivo);

		byte[] data = new byte[1024];
		int read = 0;
		while ((read = in.read(data)) != -1) {
			sha1.update(data, 0, read);
		}
		;
		byte[] hashBytes = sha1.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hashBytes.length; i++) {
			sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		String fileHash = sb.toString();

		return fileHash;
	}

	
	/**
	 * @descripcion metodo que compara el hash contenido en un archivo, con el hash ingresado como parámetro
	 * @author Ana Arango
	 * @fecha 30/05/2019
	 * @param contenido1 hash a comparar
	 * @param contenido2 archivo a comparar
	 */
	public boolean compararHashes(String contenido1, File contenido2) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(contenido2));
		String hash1 = "";
		String linea=br.readLine();

		while (linea!=null&&!linea.equals("")) {
			hash1 += linea;
			linea=br.readLine();
		}
		if(hash1.equals(contenido1)) {
			return true;
		}else {
			return false;
		}


	}
}
