import javax.swing.event.ChangeListener;

/**
 * This class stores CalendarEvents. Part of the model.
 * @author
 *
 */
public class CalendarEventList 
{
	/** 
	 * Adds an event. If the event cannot be added, let the controller
	 * handle the exception.
	 * 
	 * @throws CannotAddEventException
	 */
	void addEvent(/*parameters*/) throws CannotAddEventException
	{
		// Add a CalendarEvent.
	}
	
	/** 
	 * Adds a repeating event to the calendar. If the event cannot be added, 
	 * let the controller handle the exception.
	 * 
	 * @throws CannotAddEventException
	 */
	void addRepeatingEvent(/*parameters*/) throws CannotAddEventException
	{
		// Add CalendarEvents in a loop.
	}
	
	/** 
	 * Gets all events
	 * @return a List containg all events
	 */
	List<CalendarEvent> getEvents()
	{
		
	}
	
	/** 
	 * 
	 * @param c
	 */
	void addChangeListener(ChangeListener c)
	{
		
	}
	
	// LinkedList is probably better than ArrayList.
}
