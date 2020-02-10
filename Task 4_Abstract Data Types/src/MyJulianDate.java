
public class MyJulianDate implements JulianDate {

	private static GregorDate FirstDay;

	
	
	public MyJulianDate() {
		FirstDay = new GregorDate(4712,1,1, false);
	}
	@Override
	public int daysBetween(GregorDate Day1, GregorDate Day2) {
				
		int JDay1 = GregorToJulian(Day1);
		int JDay2 = GregorToJulian(Day2);
		return Math.abs(JDay2-JDay1);
	}
	@Override
	public GregorDate JulianToGregor(int JD) {
		
		GregorDate outcome = new GregorDate();
		
		int JD0 = 1721426;
		int N400 = (JD-JD0)/146097;
		int R400 = (JD-JD0)%146097;
		int N100 = R400/36524;
		int R100 = R400%36524;
		int N4 = R100/1461;
		int R4 = R100%1461;
		int N1 = R4/365;
		int LT = R4%365;
		
		int LJ = 400*N400 + 100*N100 + 4*N4 + N1;
		
		outcome.setYear(LJ+1);
		outcome.setMonth((LT+1)/30 + 1);
		outcome.setDay(GregorDate.DayOfYeartoDayofMonth(LT + 1, outcome.getYear()));
				
		return outcome;		
	}
	//https://de.wikipedia.org/wiki/Umrechnung_zwischen_julianischem_Datum_und_gregorianischem_Kalender
	@Override
	public int GregorToJulian(GregorDate Day) {
		int JD;
		int JD0 = 1721426;
		int LJ = Day.getYear()-1;
		int N400 = LJ/400;
		int R400 = LJ%400;
		int N100 = R400/100;
		int R100 = R400%100;
		int N4 = R100/4;
		int N1 = R100%4;
		int LT = Day.getDayOfTheYear()-1;
		
		//-1 weil getDayOFTheYear bei 1 anfängt und nicht wie in der Formel bei 0
		JD = JD0 + N400*146097 + N100*36524 + N4*1461 + N1*365 + LT;
				
		return JD;		
	}
	@Override
	public String get_Weekday(int JD) {
		
		int Weekday = (JD+1)%7;
		
		switch(Weekday) {
			case 0:
				return "Sunday";
			case 1:
				return "Monday";
			case 2:
				return "Tuesday";
			case 3:
				return "Wednesday";
			case 4:
				return "Thursday";
			case 5:
				return "Friday";
			case 6:
				return "Saturday";
		}
		return null;	
	}
	public static GregorDate get_FirstDay() {
		return FirstDay;
	}
}
