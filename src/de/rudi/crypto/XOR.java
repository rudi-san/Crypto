package de.rudi.crypto;

import java.math.BigInteger;

public class XOR {

	public static void main(String[] args) {

		BigInteger exp		= new BigInteger("11");
		BigInteger mod		= new BigInteger("19");

		int x				= 0;
		for (int i=0;i<20;i++) {
			BigInteger bi1		= new BigInteger(new Integer(i).toString());
			if (bi1.modPow(exp, mod).intValue()==2)   {
				System.out.println(i);
				x = i;
				i = 100;
			}
		}
		BigInteger bi2		= new BigInteger(new Integer(x).toString());
		BigInteger bi3		= bi2.pow(exp.intValue());
		System.out.println	(bi3.toString());
		BigInteger bi4		= bi3.mod(mod);
		System.out.println	(bi4.toString());
		
		
	}
}
