package de.rudi.crypto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AttemptWeek04 {

	private static	final	String 				urlString	= "http://crypto-class.appspot.com/po?er=";
	private static			URL					url			= null;	
	private static			HttpURLConnection 	con			= null;	
	private static 	final	String[]			cipher		= { "f20bdba6ff29eed7b046d1df9fb70000", 
																"58b1ffb4210a580f748b4ac714c001bd", 
																"4a61044426fb515dad3f21f18aa577c0",
																"bdf302936266926ff37dbf7035d5eeb4"
															  };
	private static			int[][]				iC			= new int[4][16];
	private static			int[][]				iP			= new int[4][16];
	
	public static void main(String[] args) throws IOException {

		System.setProperty( "proxySet", "true" );
		System.setProperty( "proxyHost", "proxyhv1http1" );
		System.setProperty( "proxyPort", "9090" );
		
		int num				= 2;
				
		for (int zeile=num-1;zeile>0;zeile--) {
			for (int spalte=15;spalte>=0;spalte--) {
				makeIC					();
				System.out.println		();
				System.out.print		("Zeile "+(zeile+1)+" / Spalte "+(spalte+1));
				int pad					= 16-spalte;
				for (int j=spalte+1;j<16;j++) {
					iC[zeile-1][j] 		= iP[zeile][j]^pad;
				}
				for (int i=0;i<256;i++) {
					iC[zeile-1][spalte]		= i^pad;
					String s				= getUrlString(urlString, iC, num);
					url						= new URL(s);
					try {
						con						= (HttpURLConnection)url.openConnection();
						int ret					= con.getResponseCode();
						switch (ret) {
						case 200:	System.out.print		("+"); 
									break;
						case 403:	System.out.print		("."); 
									break;
						case 404:	System.out.println		();
									System.out.println		("Plain="+i); 
									iP[zeile][spalte]		= i;
									i						= 256;
									break;
						default:	System.out.println		();
									System.out.println		("ABBRUCH: "+ret);
									System.exit(0);
									break;
						}
					} catch (IOException e) {}
				}
			}
			System.out.println				(Utilities.makeString(iP[zeile]));
		}
	}

	private static void		makeIC		() {
		for (int i=0;i<cipher.length;i++) {
			iC[i]					= Utilities.makeIntArray(cipher[i]);
		}
	}

	private static String	getUrlString (String str, int[][] iC, int num ) {
		StringBuffer buf			= new StringBuffer();
		buf.append					(str);
		for (int i=0;i<num;i++) 
			buf.append					(Utilities.toHex(iC[i]));
		return buf.toString			();
	}

}
