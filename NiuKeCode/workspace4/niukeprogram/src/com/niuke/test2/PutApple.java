package com.niuke.test2;

import java.util.Scanner;
public class PutApple{

	public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        
        int m=0;
        int n=0;
        
        while(s.hasNextInt()){
            m = s.nextInt();
            n= s.nextInt();
            
            System.out.println(m+"----->"+n);
        }
    }
	
	public static void combine(int m, int n){
		
	}

}