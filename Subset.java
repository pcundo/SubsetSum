package Subset;

public class Subset {
	public static void main(String [] args){
		comb1("", "12");
	}
	 private static void comb1(String prefix, String s) {
	        if (s.length() > 0) {
	            System.out.println(prefix + s.charAt(0));
	            comb1(prefix + s.charAt(0), s.substring(1));
	            comb1(prefix,               s.substring(1));
	        }
	        
	 }
	
}
