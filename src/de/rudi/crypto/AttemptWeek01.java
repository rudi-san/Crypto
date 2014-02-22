package de.rudi.crypto;

import java.util.HashMap;
import java.util.TreeSet;

public class AttemptWeek01 {

	private static final char[] alpha =   { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
											'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
		  								  	'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
		  								  	'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ' };
	
	private static final String cipher01 =  	"315c4eeaa8b5f8aaf9174145bf43e1784b8fa00dc71d885a80" +
												"4e5ee9fa40b16349c146fb778cdf2d3aff021dfff5b403b510" +
												"d0d0455468aeb98622b137dae857553ccd8883a7bc37520e06" +
												"e515d22c954eba5025b8cc57ee59418ce7dc6bc41556bdb36b" +
												"bca3e8774301fbcaa3b83b220809560987815f65286764703d" +
												"e0f3d524400a19b159610b11ef3e";

	private static final String cipher02 =  	"234c02ecbbfbafa3ed18510abd11fa724fcda2018a1a8342cf" +
												"064bbde548b12b07df44ba7191d9606ef4081ffde5ad46a506" +
												"9d9f7f543bedb9c861bf29c7e205132eda9382b0bc2c5c4b45" +
												"f919cf3a9f1cb74151f6d551f4480c82b2cb24cc5b028aa76e" +
												"b7b4ab24171ab3cdadb8356f";
	
	private static final String cipher03 =		"32510ba9a7b2bba9b8005d43a304b5714cc0bb0c8a34884dd9" +
												"1304b8ad40b62b07df44ba6e9d8a2368e51d04e0e7b207b70b" +
												"9b8261112bacb6c866a232dfe257527dc29398f5f3251a0d47" +
												"e503c66e935de81230b59b7afb5f41afa8d661cb";
	
	private static final String cipher04 =		"32510ba9aab2a8a4fd06414fb517b5605cc0aa0dc91a8908c2" +
												"064ba8ad5ea06a029056f47a8ad3306ef5021eafe1ac01a811" +
												"97847a5c68a1b78769a37bc8f4575432c198ccb4ef63590256" +
												"e305cd3a9544ee4160ead45aef520489e7da7d835402bca670" +
												"bda8eb775200b8dabbba246b130f040d8ec6447e2c767f3d30" +
												"ed81ea2e4c1404e1315a1010e7229be6636aaa";
	
	private static final String cipher05 =		"3f561ba9adb4b6ebec54424ba317b564418fac0dd35f8c08d3" +
												"1a1fe9e24fe56808c213f17c81d9607cee021dafe1e001b21a" +
												"de877a5e68bea88d61b93ac5ee0d562e8e9582f5ef375f0a4a" +
												"e20ed86e935de81230b59b73fb4302cd95d770c65b40aaa065" +
												"f2a5e33a5a0bb5dcaba43722130f042f8ec85b7c2070";
	
	private static final String cipher06 =		"32510bfbacfbb9befd54415da243e1695ecabd58c519cd4bd2" +
												"061bbde24eb76a19d84aba34d8de287be84d07e7e9a30ee714" +
												"979c7e1123a8bd9822a33ecaf512472e8e8f8db3f9635c1949" +
												"e640c621854eba0d79eccf52ff111284b4cc61d11902aebc66" +
												"f2b2e436434eacc0aba938220b084800c2ca4e693522643573" +
												"b2c4ce35050b0cf774201f0fe52ac9f26d71b6cf61a711cc22" +
												"9f77ace7aa88a2f19983122b11be87a59c355d25f8e4";
	
	private static final String cipher07 =		"32510bfbacfbb9befd54415da243e1695ecabd58c519cd4bd9" +
												"0f1fa6ea5ba47b01c909ba7696cf606ef40c04afe1ac0aa814" +
												"8dd066592ded9f8774b529c7ea125d298e8883f5e9305f4b44" +
												"f915cb2bd05af51373fd9b4af511039fa2d96f83414aaaf261" +
												"bda2e97b170fb5cce2a53e675c154c0d9681596934777e2275" +
												"b381ce2e40582afe67650b13e72287ff2270abcf73bb028932" +
												"836fbdecfecee0a3b894473c1bbeb6b4913a536ce4f9b13f1e" +
												"fff71ea313c8661dd9a4ce";
	
	private static final String cipher08 =  	"315c4eeaa8b5f8bffd11155ea506b56041c6a00c8a08854dd2" +
												"1a4bbde54ce56801d943ba708b8a3574f40c00fff9e00fa143" +
												"9fd0654327a3bfc860b92f89ee04132ecb9298f5fd2d5e4b45" +
												"e40ecc3b9d59e9417df7c95bba410e9aa2ca24c5474da2f276" +
												"baa3ac325918b2daada43d6712150441c2e04f6565517f317d" +
												"a9d3";
	
	private static final String cipher09 =		"271946f9bbb2aeadec111841a81abc300ecaa01bd8069d5cc9" +
												"1005e9fe4aad6e04d513e96d99de2569bc5e50eeeca709b50a" +
												"8a987f4264edb6896fb537d0a716132ddc938fb0f836480e06" +
												"ed0fcd6e9759f40462f9cf57f4564186a2c1778f1543efa270" +
												"bda5e933421cbe88a4a52222190f471e9bd15f652b653b7071" +
												"aec59a2705081ffe72651d08f822c9ed6d76e48b63ab15d020" +
												"8573a7eef027";
	
	private static final String cipher10 =		"466d06ece998b7a2fb1d464fed2ced7641ddaa3cc31c9941cf" +
												"110abbf409ed39598005b3399ccfafb61d0315fca0a314be13" +
												"8a9f32503bedac8067f03adbf3575c3b8edc9ba7f537530541" +
												"ab0f9f3cd04ff50d66f1d559ba520e89a2cb2a83";
	
	private static final String cipher11 =  	"32510ba9babebbbefd001547a810e67149caee11d945cd7fc8" +
												"1a05e9f85aac650e9052ba6a8cd8257bf14d13e6f0a803b54f" +
												"de9e77472dbff89d71b57bddef121336cb85ccb8f3315f4b52" +
												"e301d16e9f52f904";
		
	private static HashMap<Integer, TreeSet<Character>> map;
	
	private int[] plain;
	private int[] otp;
	
	public AttemptWeek01 () {
		
		map			= makeMap();
//		printMap();
		
		int[][] c 	= new int[11][];
		
		c[0]		= Utilities.makeIntArray(cipher01);
		c[1]		= Utilities.makeIntArray(cipher02);
		c[2]		= Utilities.makeIntArray(cipher03);
		c[3]		= Utilities.makeIntArray(cipher04);
		c[4]		= Utilities.makeIntArray(cipher05);
		c[5]		= Utilities.makeIntArray(cipher06);
		c[6]		= Utilities.makeIntArray(cipher07);
		c[7]		= Utilities.makeIntArray(cipher08);
		c[8]		= Utilities.makeIntArray(cipher09);
		c[9]		= Utilities.makeIntArray(cipher10);
		c[10]		= Utilities.makeIntArray(cipher11);
		
		int len		= c[10].length;
		otp			= new int[len];
		plain		= new int[len];
		
		for (int i=0;i<len;i++) {
			TreeSet<Integer> result = new TreeSet<Integer>();
			for (int k=1;k<10;k++) {
				int z = c[0][i] ^ c[k][i];
				if (map.containsKey(z)) {
					result.add(z);
				}
			}
//			System.out.print(result.size()+" ");
			if (result.size()>0) {
				Integer[] iArray  			= new Integer[result.size()];
				iArray						= result.toArray(iArray);
//				System.out.print("{ ");
//				for (int zaehl : iArray) { System.out.print(zaehl+" ") ; }
//				System.out.println("}");
				TreeSet<Character> list01 	= map.get(iArray[0]);
//				System.out.print(iArray[0]+" "+list01.size()+ " ");
				Character[] cList			= new Character[list01.size()];
				cList						= list01.toArray(cList);
				@SuppressWarnings("unchecked")
				TreeSet<Character> xList	= (TreeSet<Character>)list01.clone();
				for (int x : result) {
					TreeSet<Character> list02 = map.get(x);
					for (char ch : cList) {
						if (!list02.contains(ch))
							xList.remove(ch);
					}
				}
//				System.out.println(xList.size());
				if (xList.size()>0) {
					plain[i] = xList.first();
				}
				else {
					plain[i] = '_';
				}
			}
		}
		
		for (int i=0;i<plain.length;i++) {
			otp[i] = plain[i] ^ c[0][i];
		}
		
		otp[2] = 'e' ^ c[3][2];
		otp[7] = 'h' ^ c[3][7];
		otp[10] = 't' ^ c[0][10];
		otp[18] = 'n' ^ c[0][18];
		otp[25] = 'y' ^ c[1][25];
		otp[26] = ' ' ^ c[1][26];
		otp[31] = 'h' ^ c[0][31];
		otp[32] = 'k' ^ c[3][32];
		otp[33] = 'q' ^ c[0][33];
		otp[34] = 'u' ^ c[0][34];
		otp[35] = 'a' ^ c[0][35];
		otp[36] = 'n' ^ c[0][36];
		otp[50] = 'c' ^ c[1][50];
		otp[54] = 's' ^ c[1][54];
		otp[56] = 'a' ^ c[0][56];
		otp[81] = 't' ^ c[3][81];
		otp[82] = 'r' ^ c[6][82];

		for (int i=0;i<11;i++) {
//			System.out.print(i+" -->");
			for (int k=0;k<otp.length;k++) {
					System.out.print((char)(otp[k] ^ c[i][k]));
				}
				System.out.println();
		}
		
	}
	
	private HashMap<Integer, TreeSet<Character>> makeMap () {
		
		HashMap<Integer, TreeSet<Character>> map = new HashMap<Integer, TreeSet<Character>>();	
		int len		= alpha.length;
		for (int i=0; i<len; i++) {
			for (int k=0; k<len; k++) {
				int z	= alpha[i] ^ alpha[k];
				TreeSet<Character> list = null;
				if (map.containsKey(z)) {
					list = map.get(z);
				}
				else {
					list = new TreeSet<Character>();
				}
				list.add(alpha[i]);
				list.add(alpha[k]);
				map.put(z, list);
			}
		}
		return map;
	}
	

	public static void main(String[] args) {
		new AttemptWeek01();
	}

}
