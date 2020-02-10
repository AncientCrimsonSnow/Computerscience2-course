
import java.io.IOException;
import java.util.Scanner;

public class Test {

	//https://data-flair.training/blogs/read-java-console-input/
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		MyJulianDate MJD = new MyJulianDate();

		
		//Test JulianDAte

		/*
		//Days Between:
		
		GregorDate Test_Date1 = AskforDate();
		GregorDate Test_Date2 = AskforDate();
				
		System.out.println("Between " + Test_Date1 + " and " + Test_Date2 + " are " + MJD.daysBetween(Test_Date1, Test_Date2) + " days." );
		
		//Testing Julien to Gregor and Gregor to Julien:
		System.out.println(GregorDate.get_current_date());
		System.out.println(MJD.JulianToGregor(MJD.GregorToJulian(GregorDate.get_current_date())));
		//toString is automaticly used!!!
		
		//Testing Weekdays:
		//Today:
		System.out.println(MJD.get_Weekday(MJD.GregorToJulian(GregorDate.get_current_date())));
		//next few Days with Date that u can see its right
		for(int i = MJD.GregorToJulian(GregorDate.get_current_date()); i< 15 + MJD.GregorToJulian(GregorDate.get_current_date()); i++){
			System.out.println(MJD.get_Weekday(i));
			System.out.println(MJD.JulianToGregor(i));
		}
		//for a specific day to be sure:
		
		System.out.println(MJD.get_Weekday(MJD.GregorToJulian(AskforDate())));
		
		//First Julien Day:
		System.out.println(MJD.get_FirstDay());
		
		
		//Test Birthday
		Birthday MyBirthday = new Birthday(AskforDate());
		
		*/
		//Test MeticDate with Birthday:
		//3 Way to Create MD:
		//Gregor:
		MetricDate MD = new MetricDate(new GregorDate(1998,02,19,true));
		System.out.println(MD);
		//direct:
		MD = new MetricDate(2450,8,6,4);
		System.out.println(MD);
		//with Julian:
		MD = new MetricDate(MD.GregorToJulian(new GregorDate(1998,02,19,true)));
		System.out.println(MD);
		
		System.out.println(123450);
		System.out.println(MD.JulianToMetric(123450));
		System.out.println(MD.MetricToJulian(MD.JulianToMetric(123450)));
	}
	
	
	public static GregorDate AskforDate() {
		
		GregorDate outcome = new GregorDate();
		System.out.println("DayBetween TestDate Year(YYYY):");
		outcome.setYear(in.nextInt());
		System.out.println("DayBetween TestDate Month(MM):");
		outcome.setMonth(in.nextInt());
		System.out.println("DayBetween TestDate Month(DD):");
		outcome.setDay(in.nextInt());
		
		return outcome;
	}

}
