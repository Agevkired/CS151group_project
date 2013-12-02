import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class DayView extends AbstractView
{
	public DayView(CalendarEventList events)
	{
		this.events = events;
		this.textArea = new JTextArea(0, 40);
		add(textArea);
	}

	@Override
	public void setDay(int year, int month, int day)
    {
       this.year = year;
       this.month = month;
       this.day = day;
       refresh();
    }
	
	@Override
	public void refresh()
	{
		String s = "";
	    GregorianCalendar curr = new GregorianCalendar(year, month - 1, day);
	    SimpleDateFormat df = new SimpleDateFormat("h a");
	    
	    // Add title
	    s += ("" + DAYS[curr.get(Calendar.DAY_OF_WEEK) - 1] + " " + month + "/" + day + "\n");
	   
	    while (curr.get(Calendar.DATE) == day) // same day
	    {
	        
	        s += (df.format(curr.getTime()));
	        CalendarEvent event = events.getEvent(year, month, day, curr.get(Calendar.HOUR_OF_DAY));
	        if (event != null)
	        {
	        	s += (" " + event.getEventName());
	        	s += (" (" + event.getStartHour() + ":00-" + event.getEndHour() + "00)");
	        }
	        s += "\n";
	        curr.add(Calendar.HOUR_OF_DAY, 1);
	    }
	        
	    textArea.setText(s);
	}
	
	private int year;
	private int month;
	private int day;
	
	private CalendarEventList events;
	private JTextArea textArea;
	
	private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday"};
}
