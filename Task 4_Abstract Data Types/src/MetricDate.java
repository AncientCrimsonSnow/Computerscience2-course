
public class MetricDate extends MyJulianDate{
	
	
	private int day;
	private int week;
	private int month;
	private int year;
	
	
	//if u know the param
	public MetricDate(int year, int month, int week, int day) {
		super();
		setDay(day);
		setWeek(week);
		setMonth(month);
		setYear(year);
	}
	//with JulienDate
	public MetricDate(int JD) {
		super();
		
		MetricDate MD = JulianToMetric(JD);
		setDay(MD.getDay());
		setWeek(MD.getWeek());
		setMonth(MD.getMonth());
		setYear(MD.getYear());
	}
	//With the GregorDates
	public MetricDate(GregorDate G_Date) {
		super();
		MetricDate MD = new MetricDate(GregorToJulian(G_Date));
		setDay(MD.getDay());
		setWeek(MD.getWeek());
		setMonth(MD.getMonth());
		setYear(MD.getYear());
	}
	public MetricDate JulianToMetric(int JD) {
		
		day = ((JD%10==0)? 10 : JD%10);
		JD -= day;
		
		week = ((JD%100/10==0)? 10 : JD%100/10);
		JD -= week*10;
		
		month = ((JD%1000/100==0)? 10 : JD%1000/100);
		JD -= month*100;
		
		year = JD/1000;
		
		return this;	
	}
	public int MetricToJulian(MetricDate MD) {
					
		return day+week*10+month*100+year*1000;		
	}
	
	public String toString() {
		String FirstLetterDay = ((this.day<10) ? "0" : "");
		String FirstLetterWeek = ((this.week<10) ? "0" : "");
		String FirstLetterMonth = ((this.month<10) ? "0" : "");
		return Integer.toString(year) + "." + 
				FirstLetterMonth + Integer.toString(month) + "." + 
				FirstLetterWeek + Integer.toString(week) + "." + 
				FirstLetterDay + Integer.toString(day);
	}
	
	
	public int getDay() {
		return day;
	}
	public int getWeek() {
		return week;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int day) {
		if( 0 < day && day <= 10)
			this.day = day;
		else
			throw new IllegalArgumentException("days out of range");	
	}
	public void setMonth(int month) {
		if( 0 < month && month <= 10)
			this.month = month;
		else
			throw new IllegalArgumentException("months out of range");
	}
	public void setWeek(int week) {
		if( 0 < week && week <= 10)
			this.week = week;
		else
			throw new IllegalArgumentException("weeks out of range");
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
