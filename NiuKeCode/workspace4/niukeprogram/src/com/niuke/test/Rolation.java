package com.niuke.test;

public class Rolation {
	
	public static boolean checkRolation(String A, int lena, String B, int lenb){
		
		if(lena != lenb)
			return false;
		
		String C = A +A;
		return C.contains(B);
		
	}
	
	public static void main(String[] args) {
		String a = "1234";
		String b = "3412" ;
		System.out.println(checkRolation(a, 4, b, 4));
	}

}
