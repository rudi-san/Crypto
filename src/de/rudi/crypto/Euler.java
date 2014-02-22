package de.rudi.crypto;


import java.math.BigInteger;

public class Euler {

	public static void main(String[] args) {

		BigInteger base		= new BigInteger("2");
		BigInteger mod		= new BigInteger("35");

		BigInteger bi2		= new BigInteger("245");
		BigInteger bi3		= base.pow(bi2.intValue());
		System.out.println	(bi3.toString());
		BigInteger bi4		= bi3.mod(mod);
		System.out.println	(bi4.toString());
		
		
	}
}
