import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class stores CalendarEvents. Part of the model.
 * @author Ryan Vo
 * @version 2013-11-29
 */
public class CalendarEventList 
{
	/**
	 * Constructs a Calendar object.
	 */
	public CalendarEventList()
	{
		events = new LinkedList<>();
		listeners = new ArrayList<>();
	}
	
	/** 
	 * Adds an event. If the event cannot be added, let the controller
	 * handle the exception.
	 * 
	 * @throws CannotAddEventException
	 */
	void addEvent(CalendarEvent eventToAdd) throws CannotAddEventException
	{
		for (CalendarEvent e : events)
		{
			if (eventToAdd.conflictsWith(e))
			{
				String msg = "Trying to add conflicting events!\n";
				msg += ("Event on calendar:" + e.toString() + "\n");
				msg += ("Event trying to add:" + eventToAdd.toString() + "\n");
				throw new CannotAddEventException(msg);
			}
		}
		
		events.add(eventToAdd);
		Collections.sort(events);
		
		ChangeEvent changeEvent = new ChangeEvent(this);
		for (ChangeListener l : listeners)
		{
			l.stateChanged(changeEvent);
		}
	}
	
	/** 
	 * Adds a repeating event to the calendar. If the event cannot be added, 
	 * let the controller handle the exception.
	 * 
	 * @throws CannotAddEventException
	 */
//	void addRepeatingEvent(/*parameters*/) throws CannotAddEventException
//	{
//		// Add CalendarEvents in a loop.
//	}
	
	/** 
	 * Gets all events.
	 * @return a List containing all events
	 */
	List<CalendarEvent> getEvents()
	{
		return events;
	}
	
	/** 
	 * Gets all events between some dates.
	 * @param startDate The start date.
	 * @param endDate The end date.
	 * @return a List containing all events between some dates.
	 */
	List<CalendarEvent> getEvents(GregorianCalendar startDate, GregorianCalendar endDate)
	{
		LinkedList<CalendarEvent> listToReturn = new LinkedList<>();
		for (CalendarEvent e : events)
		{
			if (startDate.compareTo(e.getStartDate()) <= 0
					&& e.getStartDate().compareTo(endDate) <= 0)
				listToReturn.add(e);
		}
		return listToReturn;
	}
	
	/** 
	 * Adds a ChangeListener to model.
	 * @param l ChangeListener to add.
	 */
	void addChangeListener(ChangeListener l)
	{
		listeners.add(l);
	}
	
	// LinkedList is probably better than ArrayList.
	private LinkedList<CalendarEvent> events;
	private ArrayList<ChangeListener> listeners;
}
