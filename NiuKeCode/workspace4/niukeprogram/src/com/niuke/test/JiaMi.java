package com.niuke.test;

import java.util.Scanner;

public class JiaMi {
	

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
         int count = 0;
        String[] str ;
        while(input.hasNext()){
            count = Integer.parseInt(input.nextLine());
            str = new String[count];
            for(int i = 0; i< count; i++){
                str[i] = input.nextLine();
            }
            
            	jiaMi(str);
            for(int i = 0;i<str.length; i++){
            	for(int j =0; j<str[i].length(); j++){
            		System.out.print(str[i].charAt(j));
            	}
            	
            	System.out.println();
            }
            
        }
        
        
    }
    
    public static void jiaMi(String[] str){
    	
    	
    	for(int i = 0; i<str.length;i++){
    		String newStr = "";
    		for(int j = 0; j<str[i].length();j++){
    			int thisChar = str[i].charAt(j);
    			if(thisChar>='a'&&thisChar<'z' ||thisChar>='A'&&thisChar<'Z'){
    				thisChar = thisChar + 1;
    			}else if (thisChar == 'Z') {
					thisChar = 'A';
				}else if (thisChar == 'z') {
					thisChar = 'a';
				}
    			
    			newStr += (char)thisChar;
    		}
    		
    		str[i] = newStr;
    		
    	}
    	
    }
}


