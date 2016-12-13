package aKtom;
import java.util.Scanner;
public class AirReserveSystem {
 
	boolean [] chairArr = new boolean[10];
	int num;
	
	public int getNumber(){
		
		System.out.println("please type 1 for first class, type2 for Economy");
		Scanner in = new Scanner(System.in);
		
		 num = in.nextInt();
		
		//in.close();
		return num;
	}
	
	
	public void showMessage(int num){
		int i =0;
		if(num==1){
			
			for( i=0; i<5;i++){
				
				if(chairArr[i]==false){
					
					chairArr[i] = true;
					  break;
					}
				
			}
			
			if(i>4){
				
				System.out.println("the first class is full whould you like go to the Economy 0 for Y,1forN");
				
				Scanner in = new Scanner(System.in);
				
				int answer =in.nextInt();
				
				if (answer == 0){
					
					for( i=5; i<10;i++){
						
						if(chairArr[i]==false){
							
							chairArr[i] = true;
							  break;
							}
						
					}
					if(i>9)
						System.out.println("the airplan is full please wait next classes");
					else
						System.out.printf("%s:%d","you are in Economy and your seat number is",i+1);
				}
				else
					System.out.println("next flignt leaves in 3 hours");
				
				
			}
			else
				
				System.out.printf("%s:%d","you are in first class and your seatnumber is",i+1);
			
			
			
		}
		
		else{
			
			
			for( i=5; i<10;i++){
				
				if(chairArr[i]==false){
					
					chairArr[i] = true;
					  break;
					}
				
			}
			
			if(i==9){
				
				System.out.println("the Economy is full whould you like go to the first class 0 for Y,1forN");
				
				Scanner in = new Scanner(System.in);
				
				int answer =in.nextInt();
				
				if (answer == 0){
					
					for( i=0; i<5;i++){
						
						if(chairArr[i]==false){
							
							chairArr[i] = true;
							  break;
							}
						
					}
					if(i==4)
						System.out.println("the airplan is full please wait next classes");
					else
						System.out.printf("%s:%d","you are in Economy and your seat number is",i+1);
				}
				else
					System.out.println("next flignt leaves in 3 hours");
				
				
			}
			else
				
				System.out.printf("%s:%d","you are in  Economy and your seatnumber is",i+1);
			
			
			
		}
			
			
		
			
			
	}
}
