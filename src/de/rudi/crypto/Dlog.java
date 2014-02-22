package de.rudi.crypto;


import java.math.BigInteger;

public class Dlog {

	public static void main(String[] args) {

		BigInteger base		= new BigInteger("2");
		BigInteger mod		= new BigInteger("13");

		int x				= 0;
		for (int i=0;i<20;i++) {
			BigInteger exp		= new BigInteger(new Integer(i).toString());
			if (base.modPow(exp, mod).intValue()==5)   {
				System.out.println(i);
				x = i;
				i = 100;
			}
		}
		BigInteger bi2		= new BigInteger(new Integer(x).toString());
		BigInteger bi3		= base.pow(bi2.intValue());
		System.out.println	(bi3.toString());
		BigInteger bi4		= bi3.mod(mod);
		System.out.println	(bi4.toString());
		
		
	}
}
