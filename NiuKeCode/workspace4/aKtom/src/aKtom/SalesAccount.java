package aKtom;

import java.util.Scanner;

public class SalesAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMessage();
	}
	
	
	
	public static void showMessage(){
		
		double[][] a = new double [5][4];
		
		Scanner in = new Scanner(System.in);
		
		for(int i =0;i<5;i++){
			
			System.out.printf("%s%d\n" ,"please enter four Number to stand  the sealsman's sealsAccount for item",i+1);
			for(int j=0;j<4;j++)
			{
				a[i][j]=in.nextDouble();
			}
				
		}
		
		in.close();
		
		System.out.println("\\    1    2    3    4");
		
		for(int i =0;i<5;i++){
			System.out.printf("%d  ",i+1);
			for(int j=0;j<4;j++)
			{
				System.out.printf("%-4.2f  ",a[i][j]);
			}
			System.out.println();
		}
			
			
		
	}

}
