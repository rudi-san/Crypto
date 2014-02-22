package de.rudi.crypto;

import java.math.BigInteger;
import java.util.HashMap;

public class AttemptWeek05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BigInteger p	= new BigInteger(	"134078079299425970995740249982058461274793658205923933" +
											"77723561443721764030073546976801874298166903427690031" +
											"858186486050853753882811946569946433649006084171");
		BigInteger g	= new BigInteger(	"11717829880366207009516117596335367088558084999998952205" +
											"59997945906392949973658374667057217647146031292859482967" +
											"5428279466566527115212748467589894601965568");
		BigInteger h	= new BigInteger(	"323947510405045044356526437872806578864909752095244" +
											"952783479245297198197614329255807385693795855318053" +
											"2878928001494706097394108577585732452307673444020333");
		BigInteger b	= new BigInteger(	"2").pow(20);
		BigInteger one	= new BigInteger(	"1");	
//		BigInteger x	= new BigInteger(	"0");
		BigInteger y	= new BigInteger(	"0");
		BigInteger res	= new BigInteger(	"0");
		
		HashMap<BigInteger, Integer> t	= new HashMap<BigInteger, Integer>();

		//Left-hand table
		for (int x=0;x<b.intValue();x++) {
			BigInteger bigX			= new BigInteger(new Integer(x).toString());
			t.put					(h.multiply(g.modPow(bigX, p).modInverse(p)), x);
			if (x%10000 == 0) {
				System.out.println	("10000 Einträge verarbeitet: "+x);
			}
		}
		
		//Compare
		BigInteger gb	= g.modPow(b, p);
		int i				= 10000;
		while (y.compareTo(b)<0) {
			y				= y.add(one);
			BigInteger z 	= gb.modPow(y, p);
			if (t.containsKey(z)) {
				System.out.println ("h/g_x1 = "+z);
				System.out.println ("x_0 = "+y);
				res				= new BigInteger(new Integer(t.get(z)).toString());
				System.out.println ("x_1 = "+res);
				res				= res.add(y.multiply(b));
				y 				= b;
			}
			if (i == 10000) {
				System.out.println	("Nochma 10000 Einträge verarbeitet: "+y.toString());
				i 					= 0;
			}
			i++;
		}
		
		test(g, p, res);
	}
	
	private static void test (BigInteger g, BigInteger p, BigInteger x) {
		System.out.println	("Resultat: "+x);
		BigInteger gx		= g.modPow(x, p);
		System.out.println	("g_hoch_x mod"+p+": ");
		System.out.println 	(gx);
	}

}
