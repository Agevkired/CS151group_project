package cs151_project;

public class Agenda
{
	String theagenda;
	private int month, day, year;
	
	public Agenda(int m, int d, int y, String agen)
	{
		month = m;
		day = d;
		year = y;
		theagenda = agen;
	}
        public Agenda()
        {
            month = 0;
            day = 0;
            year = 0;
            theagenda = "NULL";
        }
	
	public int getmonth()
	{
		return month;
	}
	public int getday()
	{
		return day;
	}
	public int getyear()
	{
		return year;
	}
	public String getagenda()
	{
		return theagenda;
	}
}
