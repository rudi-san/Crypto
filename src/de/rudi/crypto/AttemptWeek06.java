package de.rudi.crypto;

import java.math.BigInteger;

public class AttemptWeek06 {

	private static  BigInteger multiplicand	= new BigInteger("2");
	private static  BigInteger upper, lower;

	public static void main(String[] args) {
		
		BigInteger n1 = new BigInteger ("17976931348623159077293051907890247336179769789423065727343008115" +
					  "77326758055056206869853794492129829595855013875371640157101398586" +
					  "47833778606925583497541085196591615128057575940752635007475935288" +
					  "71082364994994077189561705436114947486504671101510156394068052754" +
					  "0071584560878577663743040086340742855278549092581");
		BigInteger[] pq			= getQ(n1);
		System.out.println		("p="+pq[0]);
		System.out.println		("q="+pq[1]);
		System.out.println		(n1.compareTo(pq[0].multiply(pq[1])));
		System.out.println		(pq[0].isProbablePrime(Integer.MAX_VALUE));
		System.out.println		(pq[1].isProbablePrime(Integer.MAX_VALUE));

		BigInteger pPlus		= pq[0].subtract(BigInteger.ONE);
		BigInteger qPlus		= pq[1].subtract(BigInteger.ONE);
		BigInteger pqPlus		= pPlus.multiply(qPlus);
		BigInteger e			= new BigInteger("65537");
		System.out.println		("e="+e);
		BigInteger d			= e.modInverse(pqPlus);
		System.out.println		("d="+d);
//		System.out.println		("d[1]="+d[1]);

		
		BigInteger c  = new BigInteger ("22096451867410381776306561134883418017410069787892831071731839143" +
					  "67613560012053800428232965047350942434394621975151225646583996794" +
					  "28894607645420405815647489880137348641204523252293201764879166664" +
					  "02997509188729971690526083222067771600019329260870009579993724077" +
					  "458967773697817571267229951148662959627934791540");
		
		BigInteger pkcs1 		= c.modPow(d, n1);
		byte[] b				= pkcs1.toByteArray();
		
		System.out.println		(Utilities.toHex(b));
		
		
//		BigDecimal n2 = new BigDecimal ("6484558428080716696628242653467722787263437207069762630604390703787" +
//	    "9730861808111646271401527606141756919558732184025452065542490671989" +
//	    "2428844841839353281972988531310511738648965962582821502504990264452" +
//	    "1008852816733037111422964210278402893076574586452336833570778346897" +
//	    "15838646088239640236866252211790085787877");
//		System.out.println(getQ(n2));
	}
	
	private static BigInteger[] getQ (BigInteger n) {
		BigInteger sqrtN	= sqrt(n);
		BigInteger nn		= BigInteger.ZERO;
		BigInteger x		= BigInteger.ZERO;
		BigInteger p		= BigInteger.ZERO;
		BigInteger q		= BigInteger.ZERO;

		while (nn.compareTo(n)<0) {
//			System.out.println(sqrtN);
			x				= sqrt(sqrtN.pow(2).subtract(n));
			q				= sqrtN.subtract(x);
			p				= sqrtN.add(x);
			nn				= q.multiply(p);
			sqrtN			= sqrtN.add(BigInteger.ONE);
		}
		BigInteger[] pq		= new BigInteger[2];
		pq[0]				= p;
		pq[1]				= q;
		return				pq;
	}
	
	private static BigInteger sqrt (BigInteger wert) {
		String str				= wert.toString();
		BigInteger	wurzel		= new BigInteger(str.substring(str.length()/2));
		upper 					= wurzel.pow(2);
		lower 					= new BigInteger("100");
		return 					sqrt(new BigInteger(str), wurzel);
	}

	private static BigInteger sqrt (BigInteger wert, BigInteger wurzel) {
//		System.out.println(wurzel);
		if (upper.subtract(lower).compareTo(BigInteger.ZERO)==0) {
			return upper;
		}
		if (upper.subtract(lower).compareTo(BigInteger.ONE)==0) {
			return upper;
		}
		BigInteger change	= upper.subtract(lower).divide(multiplicand);
//		System.out.println("wurzel="+wurzel);
//		System.out.println("upper= "+upper);
//		System.out.println("lower= "+lower);
//		System.out.println("change="+change);
//		if (change.compareTo(BigDecimal.ZERO)<0) {
//			System.exit(0);
//		}
		if (wurzel.pow(2).compareTo(wert)<0) {
			lower		= wurzel;
			wurzel		= wurzel.add(change); 
			return 		(sqrt(wert, wurzel));
		}
		else {
			if (wurzel.pow(2).compareTo(wert)>0) {
				upper 		= wurzel;
				wurzel		= (wurzel.compareTo(change)>0) ? wurzel.subtract(change) : change; 
				return 		(sqrt(wert, wurzel));
			}
			else {
				return wurzel;
			}
		}
	}
}
