package aKtom;
import java.util.Random;
import java.util.Scanner;

public class Multiple {
	
	public static void main(String[] args)
	{
		System.out.printf("%d*%d= ?\n",pupil(),pupil());
		int m = pupil()*pupil();
		
		Scanner in = new Scanner(System.in);
		System.out.println("please enter you answer");
		int answer =in.nextInt();
		in.close();
		if (answer==m) {
			
			System.out.println("excellent,you are right");
			
		}
		
	}

	
	
	public static  int pupil(){
		
		Random random = new Random();
		
		int a = random.nextInt(9)+1;
		return a;
		
		
	}
}
