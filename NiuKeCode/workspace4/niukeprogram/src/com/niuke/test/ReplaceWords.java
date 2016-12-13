package com.niuke.test;

import java.util.Scanner;

public class ReplaceWords {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String orginal = input.nextLine();
			String  replace = input.nextLine();
			
			System.out.println(replaceWords(str, orginal, replace));
			
		}
		
		
	}
	
	public static String replaceWords(String str, String res,String rep){
		String[] newStr = str.split(" ");
		for(int i= 0;i<newStr.length; i++){
			if(newStr[i].equals(res))
				newStr[i]=rep;
		}
			String flash ="";
		for(int i=0; i<newStr.length; i++){
			flash= flash+newStr[i]+" ";
		}
		
		return flash;
	}
	

}
