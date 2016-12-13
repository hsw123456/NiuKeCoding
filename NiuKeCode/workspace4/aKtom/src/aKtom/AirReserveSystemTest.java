package aKtom;

public class AirReserveSystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=0;
		AirReserveSystem ars = new AirReserveSystem ();
	for (int i=0;i<12;i++)	{
		number = ars.getNumber();
		
		ars.showMessage(number);
		System.out.println();
	}
		
	}

}
