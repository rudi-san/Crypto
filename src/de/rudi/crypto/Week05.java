package de.rudi.crypto;

import java.math.BigInteger;

public class Week05 {

	public static void main(String[] args) {
		
		BigInteger p 		= new BigInteger("134078079299425970995740249982058461274793658205923933" +
				"77723561443721764030073546976801874298166903427690031" +
				"858186486050853753882811946569946433649006084171");
		BigInteger g		= new BigInteger("11717829880366207009516117596335367088558084999998952205" +
				"59997945906392949973658374667057217647146031292859482967" +
				"5428279466566527115212748467589894601965568");
		BigInteger h		= new BigInteger("323947510405045044356526437872806578864909752095244" +
				"952783479245297198197614329255807385693795855318053" +
				"2878928001494706097394108577585732452307673444020333");
		int x0				= 0;
		int x1				= 0;
		
		BigInteger bigB		= new BigInteger("2").pow(20);
		int b				= bigB.intValue();
		BigInteger[] left	= new BigInteger[b];
		for (int i=0;i<b;i++) {
			BigInteger exp		= new BigInteger(new Integer(i).toString());
			BigInteger gx1		= g.modPow(exp, p);
			BigInteger div		= gx1.modInverse(p);
			BigInteger mult		= h.multiply(div);
			left[i]				= mult.mod(p);
			if (i%10000==0)
				System.out.println (i+" Einträge erstellt");
		}
		
		BigInteger gx0			= g.modPow(bigB, p);
		for (int j=1;j<b;j++) {
			BigInteger exp		= new BigInteger(new Integer(j).toString());
			BigInteger right	= gx0.modPow(exp, p);
			for (int k=0;k<b;k++) {
				if (left[k].compareTo(right) == 0) {
					x1			= k;
					x0			= j*b;
					System.out.println ("x1="+x1+"/x0="+j);
					j			= b;
				}
			}
			if (j%10000==0)
				System.out.println (j+" Potenzen überprüft");
		}
		int x				= x1+x0;
		System.out.println	("x="+x);
		BigInteger bigX		= new BigInteger(new Integer(x).toString());
		BigInteger gx		= g.modPow(bigX, p);
		System.out.println	("h=="+h);
		System.out.println	("gx="+gx);
	}

}
