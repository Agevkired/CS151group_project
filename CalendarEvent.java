import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This class stores information about an event on the calendar. Part of the model.
 * @author Ryan Vo
 * @version 2013-11-29
 *
 */
public class CalendarEvent implements Comparable<CalendarEvent>
{
	/**
	 * Constructs a CalendarEvent object. The event shall start and end on the same day.
	 * @param eventName The name of the event.
	 * @param year The year the event will take place.
	 * @param month The month the event will take place (1-12).
	 * @param day The day the event will take place (1-31).
	 * @param startHour The hour the event will take place (0-23).
	 * @param endHour The hour the event will end (0-23).
	 */
	public CalendarEvent(String eventName, int year, int month, int day, 
			int startHour, int endHour)
	{
		this.eventName = eventName;
		this.startDate = new GregorianCalendar(year, month - 1, day, startHour, 0);
		this.endDate = new GregorianCalendar(year, month - 1, day, endHour, 0);
	}
	
	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 */
	public String getEventName()
	{
		return eventName;
	}
	
	/**
	 * Gets the year the event will take place.
	 * @return The year.
	 */
	public int getYear()
	{
		return startDate.get(Calendar.YEAR);
	}
	
	/**
	 * Gets the month the event will take place.
	 * @return The month.
	 */
	public int getMonth()
	{
		return startDate.get(Calendar.MONTH) + 1; // Month uses zero-index.
	}

	/**
	 * Gets the day the event will take place.
	 * @return The day.
	 */
	public int getDay()
	{
		return startDate.get(Calendar.DATE);
	}
	
	/**
	 * Gets the hour the event will start at.
	 * @return The hour the event will start at.
	 */
	public int getStartHour()
	{
		return startDate.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Gets the hour the event will end at.
	 * @return The hour the event will end at.
	 */
	public int getEndHour()
	{
		return endDate.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Gets the start date. Modifying the returned object will not modify
	 *    CalendarEvent.
	 * @return The start date.
	 */
	public GregorianCalendar getStartDate()
	{
		return (GregorianCalendar) startDate.clone();
	}
	
	/**
	 * Gets the end date. Modifying the returned object will not modify
	 *    CalendarEvent.
	 * @return The end date.
	 */
	public GregorianCalendar getEndDate()
	{
		return (GregorianCalendar) endDate.clone();
	}
	
	/**
	 * Determines whether two events have time conflicts.
	 * @param other The other CalendarEvent.
	 * @return true if two events conflict; false otherwise.
	 */
	public boolean conflictsWith(CalendarEvent other)
	{
		
		int startComparison = this.startDate.compareTo(other.startDate);
		if (startComparison == 0)
		{
			return true;
		}
		else if (startComparison < 0)
		{
			return this.endDate.compareTo(other.startDate) > 0;
		}
		else
			return other.endDate.compareTo(this.startDate) > 0;
	}
	
	@Override
	public int compareTo(CalendarEvent other) 
	{
		return startDate.compareTo(other.startDate);
	}
	
	@Override
	public String toString()
	{
		String sb = getEventName() + ";";
		sb += (getYear() + ";");
		sb += (getMonth() + ";");
		sb += (getDay() + ";");
		sb += (getStartHour() + ";");
		sb += (getEndHour() + ";");
		
		return sb;
	}
	
	// Should the assumption be made that events start and end on the same day?
	private String eventName;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
}
