package de.rudi.crypto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Week04 {
	
	private static HttpURLConnection	con;
	private static String 				urlString	= "http://crypto-class.appspot.com/po?er=";
	private static String[][] 			hex			= { { "f2","0b","db","a6","ff","29","ee","d7","b0","46","d1","df","9f","b7","00","00" },
														{ "58","b1","ff","b4","21","0a","58","0f","74","8b","4a","c7","14","c0","01","bd" },
														{ "4a","61","04","44","26","fb","51","5d","ad","3f","21","f1","8a","a5","77","c0" },
														{ "bd","f3","02","93","62","66","92","6f","f3","7d","bf","70","35","d5","ee","b4" }
														};
	private static int					i;
	private static int					j;
	private static int					k;
	private static int[][]				target			= new int[4][16];

	public static void main(String[] args) throws IOException {
		
		for (i=3;i>0;i--) {
			String[][] zx		= new String[4][16];
			zx[0] 				= strClone(hex[0]);
			zx[1] 				= strClone(hex[1]);
			zx[2] 				= strClone(hex[2]);
			zx[3] 				= strClone(hex[3]);
			for (j=15;j>=0;j--) {
				for (int v=j+1;v<16;v++) {
					int zw				= Utilities.toInt(hex[i-1][v]);
					zx[i-1][v] 			= Utilities.toHex(zw^target[i][v]^(16-j));
				}
				int zwischen		= Utilities.toInt(zx[i-1][j]);
				for (k=0;k<256;k++) {
					zx[i-1][j]			= Utilities.toHex(zwischen^k^(16-j));
					StringBuffer buf	= new StringBuffer();
					buf.append			(urlString);
					for (int x=0;x<i+1;x++) {
						for (int y=0;y<16;y++) {
							buf.append		(zx[x][y]);
						}
					}
//					System.out.println(buf.toString());
					URL url			= null;
					try {
						url = new URL(buf.toString());
					} catch (MalformedURLException e) {	}
					try {
						con 				= (HttpURLConnection)url.openConnection();
						con.getInputStream	();
					} catch (IOException e) {
						int res 	= con.getResponseCode();
						System.out.print(".");
						if (res != 403 && res != 404) {
							System.out.println(e.getMessage());
							System.exit(0);
						}
						if (res==404) {
							target[i][j]		= k;
							System.out.print	("i="+i+" j="+j+" k="+k);
							k = 256;
						}					}
				}
				System.out.println();
			}
			System.out.println(Utilities.int2String(target[i]));
		}
	}

	private static String[] strClone (String[] s) {
		String[] cl		= new String[s.length];
		for (int i=0;i<s.length;i++) {
			cl[i]			= s[i];
		}
		return cl;
	}
	
}
