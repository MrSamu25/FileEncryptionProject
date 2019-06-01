package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import java.io.*;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Formatter;

public class FileEncDec {

	public FileEncDec() {

	}

	public void Encrypt(String key, File inputFile, File outputEncrypted) {

		try {
			Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			FileInputStream inputStream = new FileInputStream(inputFile);
			byte[] inputBytes = new byte[(int) inputFile.length()];
			inputStream.read(inputBytes);
			byte[] outputBytes = cipher.doFinal(inputBytes);
			FileOutputStream outputStream = new FileOutputStream(outputEncrypted);
			outputStream.write(outputBytes);
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	
	
	public String getSha1(File file) throws NoSuchAlgorithmException, IOException {
	    final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

	    try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
	      final byte[] buffer = new byte[1024];
	      for (int read = 0; (read = is.read(buffer)) != -1;) {
	        messageDigest.update(buffer, 0, read);
	      }
	    }

	    // Convert the byte to hex format
	    try (Formatter formatter = new Formatter()) {
	      for (final byte b : messageDigest.digest()) {
	        formatter.format("%02x", b);
	      }
	      return formatter.toString();
	    }
	  }
	
	
	
	
	
	
	
	
	

}
