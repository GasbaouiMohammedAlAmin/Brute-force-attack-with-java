/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;


import java.security.MessageDigest;


/**
 *
 * @author amine gasa
 */
public class BruteForce {

    /**
     * @param args the command line arguments
     */
    private static String hash = "2dc0371e782114d45b015fa45cc0d40b";
    static String alg="MD2";
	private static StringBuilder str = new StringBuilder("");
	private static int min = 32, max = 127;
	
	
	public static void loop(int index) {

		for(int i = min; i < max; i++) {
			str.setCharAt(index, (char) i);
			if(index < str.length() - 1){
				loop(index + 1);}
			System.out.println(str);
                        String S=getHash(str.toString().getBytes(), alg);
			if(verification(S, hash)) {
				System.out.println("password found: " + str);
				
				System.exit(0);
			}
		}
	}
    public static void main(String[] args) {
    
    
        System.out.println("\tOriginal video : https://www.youtube.com/watch?v=0PM10vOtd6o");
        System.out.println("\tUpdated by:Gasbaoui Mohammed al amine");
       // System.out.println("this script breaks cryptographic hash functions using brute force technique ");
        System.out.println("Available cryptographic hash functions:MD2,MD5,SHA-1,SHA-224,SHA-256,SHA-384,SHA-512");
        System.out.println("exemple : java BruteForce.java MD2 2dc0371e782114d45b015fa45cc0d40b ");
        if(args.length>1)
        {alg=args[0];
        hash=args[1];
        
		while(true) {
			str.append((char) min);
		                  
			for(int i = 0; i < str.length() - 1; i++) {
				for(int j = min; j  < max; j++) {
					str.setCharAt(i, (char) j);
                                       
					loop(i + 1);
				}
			}
		}
        }
        
    }
    static String getHash(byte []inputByte,String Algo){
        String result="";
        try{
          MessageDigest msd=MessageDigest.getInstance(Algo);
          msd.update(inputByte);
          byte[]DigestedBytes=msd.digest();
          result=toHexadecimal(DigestedBytes);
           
       
        }catch(Exception e){
            
        }
    return result;}
    static String toHexadecimal ( byte[] source ) {
		
		StringBuilder sb = new StringBuilder();
		
		for ( byte b : source ) {
			
			String toAppend = String.format("%2X", b ).replace(" ", "0"); // %X Hexadecimal
			sb.append( toAppend.toLowerCase() );
		}
		
		return sb.toString();		
	}
   static boolean verification(String s1,String s2){
        boolean test=true;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)){test=false;break;}
        }
   return test; }
}
