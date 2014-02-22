package de.rudi.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AttemptWeek02 {

//	private static final String keyString		= "wk2Söl]0u3k§\"!²9";
	
	/** Verschlüsseln des übergebenen Klartextes (s) und Rückgabe des verschlüsselten
	 * Textes
	 * @param s Klartext
	 * @return verschlüsselter Text
	 */
	public static String encode (byte[] keyArray, String s) {
		
		String retString	= null;
		
		try {
			Key key				= new SecretKeySpec (keyArray, "AES");
			Cipher cipher		= Cipher.getInstance("AES");
			cipher.init			(Cipher.ENCRYPT_MODE, key);
			byte[] secret		= cipher.doFinal(s.getBytes());
	
			StringBuffer sBuf	= new StringBuffer();
			for (int i=0;i<secret.length;i++) {
				String hex		= Integer.toHexString(secret[i]);
				if (hex.length()<2)
					hex				= "0"+hex;
				sBuf.append			(hex.substring(hex.length()-2).toUpperCase());
			}
			retString			= sBuf.toString();
		} catch (NoSuchAlgorithmException e) {
			return				e.toString();
		} catch (NoSuchPaddingException e) {
			return				e.toString();
		} catch (InvalidKeyException e) {
			return				e.toString();
		} catch (IllegalBlockSizeException e) {
			return				e.toString();
		} catch (BadPaddingException e) {
			return				e.toString();
		}

		return 				retString;
	}
	
	/** Entschlüsseln eines verschlüsselten Textes und Rückgabe des Klartextes
	 * @param s verschlüsselter Text
	 * @return Klartext
	 */
	public static String decode (byte[] iv, byte[] keyArray, byte[] ct, String mode) {

		String retString	= null;
			
		try {
			Key key				= new SecretKeySpec (keyArray, "AES");
			
			Cipher cipher		= Cipher.getInstance("AES/"+mode);
			AlgorithmParameters para = AlgorithmParameters.getInstance("AES");
			para.init			(new IvParameterSpec(iv));
			cipher.init			(Cipher.DECRYPT_MODE, key, para);
			retString			= new String(cipher.doFinal(ct));
		} catch (NoSuchAlgorithmException e) {
			return				"Fehler:"+e.toString();
		} catch (NoSuchPaddingException e) {
			return				"Fehler:"+e.toString();
		} catch (InvalidKeyException e) {
			return				"Fehler:"+e.toString();
		} catch (IllegalBlockSizeException e) {
			return				"Fehler:"+e.toString();
		} catch (BadPaddingException e) {
			return				"Fehler:"+e.toString();
		} catch (InvalidAlgorithmParameterException e) {
			return				"Fehler:"+e.toString();
		} catch (InvalidParameterSpecException e) {
			return				"Fehler:"+e.toString();
		}

		return 			retString;
	}

	private static byte[] makeByteArray (String s) {
		byte[] iArray = new byte[s.length()/2];
		for (int i=0;i<iArray.length;i++) {
			String x			= s.substring(i*2,	i*2+2);
			int y				= Byte.decode("0x0"+x.substring(0,1));
			if (y > 7) {
				int z			= 16*y+Byte.decode("0x0"+x.substring(1));
				iArray[i]			= (byte)((256-z)*-1);
			}
			else
				iArray[i]			= Byte.decode("0x"+x);
		}
		return iArray;
	}

	public static void main(String[] args) {

		byte[] key		= makeByteArray("140b41b22a29beb4061bda66b6747e14");
		byte[] iv		= makeByteArray("4ca00ff4c898d61e1edbf1800618fb28");
		byte[] ct		= makeByteArray("28a226d160dad07883d04e008a7897ee" +
										"2e4b7465d5290d0c0e6c6822236e1daafb94ffe0c5da05d9476be028ad7c1d81"); 
		System.out.println(decode(iv,key,ct,"CBC/PKCS5Padding"));

		byte[] key1		= makeByteArray("140b41b22a29beb4061bda66b6747e14");
		byte[] iv1		= makeByteArray("5b68629feb8606f9a6667670b75b38a5");
		byte[] ct1		= makeByteArray("b4832d0f26e1ab7da33249de7d4afc48" +
										"e713ac646ace36e872ad5fb8a512428a6e21364b0c374df45503473c5242a253"); 
		System.out.println(decode(iv1,key1,ct1,"CBC/PKCS5Padding"));

		byte[] key2		= makeByteArray("36f18357be4dbd77f050515c73fcf9f2");
		byte[] iv2		= makeByteArray("69dda8455c7dd4254bf353b773304eec");
		byte[] ct2		= makeByteArray("0ec7702330098ce7f7520d1cbbb20fc3" +
										"88d1b0adb5054dbd7370849dbf0b88d393f252e764f1f5f7ad97ef79d59ce29f5f51eeca32eabedd9afa9329"); 
		System.out.println(decode(iv2,key2,ct2,"CTR/NoPadding"));

		byte[] key3		= makeByteArray("36f18357be4dbd77f050515c73fcf9f2");
		byte[] iv3		= makeByteArray("770b80259ec33beb2561358a9f2dc617");
		byte[] ct3		= makeByteArray("e46218c0a53cbeca695ae45faa8952aa" +
										"0e311bde9d4e01726d3184c34451"); 
		System.out.println(decode(iv3,key3,ct3,"CTR/NoPadding"));
	}
}
