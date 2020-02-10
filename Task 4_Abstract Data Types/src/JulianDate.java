
public interface JulianDate {

	public GregorDate JulianToGregor(int JD);
	public int daysBetween(GregorDate Day1, GregorDate Day2);
	public int GregorToJulian(GregorDate Day);
	public String get_Weekday(int JD);
}
