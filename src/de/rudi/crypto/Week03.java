package de.rudi.crypto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Week03 {

	public static void main(String[] args) {

		File file	= new File ("6 - 1 - Introduction (11 min).mp4");
//		File file	= new File ("6 - 2 - Generic birthday attack (16 min).mp4");

		int len		= (int)file.length();
		byte[] b	= new byte[len];
		
		try {
			FileInputStream stream	= new FileInputStream(file);
			stream.read				(b);
			stream.close			();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		int partlen		= len/1024;
		
		byte[][] filearray = new byte[partlen][1024];
		byte[][] target		= new byte[partlen][1056];
		
		for (int i=0;i<partlen;i++) {
			for (int j=0;j<1024;j++) {
				filearray[i][j] = b[i*1024+j];
			}
		}
	
		int restlen 	= b.length-1024*partlen;
		
		byte[] rest		= new byte[restlen];
		
		for (int i=0;i<rest.length;i++) {
			rest[i]		= b[1024*partlen+i];
		}
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
		}

	    md.update(rest);
	    byte[] digest = md.digest();
	    
	    for (int i=partlen-1;i>-1;i--) {
	    	for (int j=0;j<1024;j++) {
	    		target[i][j] = filearray[i][j];
	    	}
	    	for (int j=0;j<32;j++) {
	    		target[i][j+1024] = digest[j];
	    	}
	    	md.update(target[i]);
	    	digest	= md.digest();
	    }
	 	System.out.print(Utilities.toHex(digest));
	}

}
