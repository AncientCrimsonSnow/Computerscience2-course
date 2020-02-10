
import java.io.IOException;
import java.util.Scanner;


public class Birthday {
	
	
	private static GregorDate Birthday = new GregorDate(1, 1, 1, true);

	
	private static MyJulianDate MJD = new MyJulianDate();
	
	public Birthday(GregorDate Birthday) throws IOException {
		this.Birthday = Birthday;
		main(null); //its not pretty i know....
	}
	
	public static void main(String[] args) throws IOException {
	
		if(Birthday.equalsMonth_Day(GregorDate.get_current_date()))
			System.out.println("HAPPY BIRTHDAY");
		if( MJD.daysBetween(Birthday,GregorDate.get_current_date()) % 100 == 0)
			System.out.println("You lived a number of days that is divisible by 100.");
		
		System.out.println("You are " + MJD.daysBetween(Birthday,GregorDate.get_current_date()) + " days old");
		System.out.println("You were born on a " + MJD.get_Weekday(MJD.GregorToJulian(Birthday)));	
				
	}
}
/*
*/