package aKtom;

public class AddTest {
	static int sum0;
	static int sum1;
	static int sum2;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//int sum0,sum1,sum2;
		System.out.println(add(1,2));
		System.out.println(add(1,2,3));
		System.out.println(add(1,2,4,3));
	}
		
		
		
		public  static int add(int a,int b)
		{
			  sum0 = a+b;
			return sum0;
			
		}
		public static int add(int a,int b,int c)
		{
			
			  sum1 = a+b+c;
			return sum1;
			
		}
		public static int add(int...args)
		{
			
			 sum2 = 0;
			
			for(int i=0;i<args.length;i++)
			{
				
				sum2 += args[i];
				
				
			}
			return sum2;
			
			
			
		}
		
	

}
