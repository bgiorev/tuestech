/*автоматична подредба на хората в самолет, започва от 1А до ред 27, има 2х3 места на всеки ред
правилна имплементация на метода add*/
import java.util.Random;

public class AirPlane {

	private int [][] seats = new int[6][27];
	public void printSeats() {
		
		for (int k=0; k<27; k++) {
			for(int l=0; l<6; l++) {
				if(l == 2)
				{
					System.out.print(seats[l][k] + " ");
				} else {
					System.out.print(seats[l][k] );
				}
			}
				System.out.println();
		}
	} 
	public void add(int rvalue) {
		for (int i=0;i<rvalue;i++) {	
			seats[i][0] = 1;
		}	
	}
	
	public int freeSeats() {
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		AirPlane plane = new AirPlane();
		plane.printSeats();		
		plane.add(2);
		System.out.println("############################");
		plane.printSeats();
	}

}
