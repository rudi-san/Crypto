package de.rudi.crypto;

public class Utilities {

	public static String toHex (byte[] cText) {
		StringBuffer buf	= new StringBuffer();
		for (int i=0;i<cText.length;i++) {
			buf.append			(toHex(cText[i]));
		}
		return buf.toString();
	}

	public static String toHex(byte b) {
		int i = b;
		return toHex(i);
	}

	public static String toHex(int i) {
		String hex = Integer.toHexString(i);
		if (hex.length() < 2)
			return "0" + hex;
		else {
			return hex.substring(hex.length() - 2);
		}
	}

	public static byte toByte(String s) {
		return Byte.decode("0x" + s);
	}

	public static int toInt(String s) {
		return Integer.decode("0x" + s);
	}

	public static String int2String(int[] iArray) {
		int len = iArray.length;
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[i] = toByte(toHex(iArray[i]));
		}
		return new String(b);
	}

	public static void main(String[] args) {
		byte a = 'a';
		System.out.println(a + " " + toHex(a));
		System.out.println(a + " " + toByte(toHex(a)));
	}

	public static int makeInt (String s) {
		return Integer.decode("0x"+s); 
	}

	public static int[] makeIntArray (String s) {
		int[] iArray = new int[s.length()/2];
		for (int i=0;i<iArray.length;i++) {
			String x			= s.substring(i*2,	i*2+2);
			iArray[i]			= makeInt(x);
		}
		return iArray;
	}

	public static String makeString (int[] iArray) {
		char[] c		= new char[iArray.length];
		for (int i=0;i<iArray.length;i++)
			c[i]		= (char)iArray[i];
		return new String(c);
	}

	public static String toHex (int[] cText) {
		StringBuffer buf	= new StringBuffer();
		for (int i=0;i<cText.length;i++) {
			buf.append			(toHex(cText[i]));
		}
		return buf.toString();
	}
}