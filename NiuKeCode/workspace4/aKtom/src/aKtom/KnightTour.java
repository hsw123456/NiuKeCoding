package aKtom;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class KnightTour {
	
	private int[] horizontal ={2,1,-1,-2,-2,-1,1,2};
	
	private int[] vertical = {-1,-2,-2,-1,1,2,2,1};
	
	private int [] [] arr= new int[8][8];
	
	

	
	public void knightPlay(){
		int currentRow = 3;
		int currentCol = 4;
		int moveNumber=0;
		int count = 0;
		int i =0;
		int point =0;
		
		int [][] oarr = new int[8][8];
		Random rd = new Random();
		
		for (int j = 0; j < oarr.length; j++) {
			for(int k=0 ;k<oarr[i].length;k++)
				oarr[j][k]=1;
		}
		arr[currentRow][currentCol] = 1;
		
	 while(!Arrays.equals(arr,oarr)||i==7||point==7){
						
				for( i =0;i<8;i++){
						
						/*System.out.println("please enter a step for 0~7");
						Scanner in = new Scanner(System.in);
						*/
						moveNumber=rd.nextInt(8); //in.nextInt();
						currentRow +=  vertical[moveNumber];
						currentCol +=  horizontal[moveNumber];
						
					if((0<=currentRow&&currentRow<8)&&(0<=currentCol&&currentRow<8)){
							
							if(arr[currentRow][currentCol]!=1)
							{
								arr[currentRow][currentCol] = 1;
								count++;
								i = 0;
								
							}
							else
								continue;
						}
						else{
							
							System.out.println("array beyond limit");
							currentRow -=  vertical[moveNumber];
							currentCol -=  horizontal[moveNumber];
							point++;
							
							}
		
					}
				
	        }
	 
	       System.out.println("the knight had moved " +count+ " steps");
		
	 		for (int j = 0; j < arr.length; j++) {
			for(int k=0 ;k<arr[j].length;k++){
			
				System.out.printf(" %d",  arr[j][k]);
			     if(k==7)
				System.out.println();
		
			}
	 		}
		
		
		//continue;	
	  
	 
	 		}

	
}
