package de.rudi.crypto;

import java.math.BigDecimal;

public class Week06 {

	private static  BigDecimal multiplicand	= new BigDecimal("2");
	private static  BigDecimal upper, lower;

	public static void main(String[] args) {
		
		BigDecimal n1 = new BigDecimal ("17976931348623159077293051907890247336179769789423065727343008115" +
					  "77326758055056206869853794492129829595855013875371640157101398586" +
					  "47833778606925583497541085196591615128057575940752635007475935288" +
					  "71082364994994077189561705436114947486504671101510156394068052754" +
					  "0071584560878577663743040086340742855278549092581");
		System.out.println(getQ(n1));
		
		BigDecimal n2 = new BigDecimal ("6484558428080716696628242653467722787263437207069762630604390703787" +
	    "9730861808111646271401527606141756919558732184025452065542490671989" +
	    "2428844841839353281972988531310511738648965962582821502504990264452" +
	    "1008852816733037111422964210278402893076574586452336833570778346897" +
	    "15838646088239640236866252211790085787877");
		System.out.println(getQ(n2));
	}
	
	private static String getQ (BigDecimal n) {
		BigDecimal sqrtN	= sqrt(n);
		BigDecimal nn		= BigDecimal.ZERO;
		BigDecimal x		= BigDecimal.ZERO;
		BigDecimal p		= BigDecimal.ZERO;
		BigDecimal q		= BigDecimal.ZERO;

		while (nn.compareTo(n)<0) {
//			System.out.println(sqrtN);
			x				= sqrt(sqrtN.pow(2).subtract(n));
			q				= sqrtN.subtract(x);
			p				= sqrtN.add(x);
			nn				= q.multiply(p);
			sqrtN			= sqrtN.add(BigDecimal.ONE);
		}
		return				(n.compareTo(nn)+"q="+q);
	}
	
	private static BigDecimal sqrt (BigDecimal wert) {
		String str				= wert.toString();
		BigDecimal	wurzel		= new BigDecimal(str.substring(str.length()/2));
		upper 					= wurzel.pow(2);
		lower 					= new BigDecimal(100);
		return 					sqrt(new BigDecimal(str), wurzel);
	}

	private static BigDecimal sqrt (BigDecimal wert, BigDecimal wurzel) {
//		System.out.println(wurzel);
		if (upper.subtract(lower).compareTo(BigDecimal.ZERO)==0) {
			return upper;
		}
		if (upper.subtract(lower).compareTo(BigDecimal.ONE)==0) {
			return upper;
		}
		BigDecimal change	= upper.subtract(lower).divide(multiplicand, BigDecimal.ROUND_CEILING);
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
