package threadExercise;

public class ThreadDemo {

	public static void main(String[] args){
		
		Thread tt = new TestThread();
		tt.start();
		
		while(true){
			
			System.out.println("main():"+Thread.currentThread().getName());
		}
		
	}
	
}
  
class TestThread extends Thread{
	
	public void  run(){
		
		while(true){
			
			System.out.println("run():"+Thread.currentThread().getName());
		}
		
	}
	
}
