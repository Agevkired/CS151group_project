import java.awt.CardLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

/**
 * This class displays different views of the model.
 * @author
 *
 */
public class ViewManager extends AbstractView
{
	public ViewManager(CalendarEventList events)
	{
		setLayout(new CardLayout());
		dayView = new DayView(events);
		add(dayView, DAYVIEW);
		
		GregorianCalendar today = new GregorianCalendar();
		setDay(today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DATE)); 
		
		changeView(DAYVIEW);
	}
	
	
	/**
	 * Changes the day. Changing the day may also change the view.
	 * @param year The year.
	 * @param month The month (1-12).
	 * @param day The day.
	 */
	
	public void setDay(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		
		dayView.setDay(year,  month, day);
	}
	
	public void refresh()
	{
		dayView.refresh();
	}	
	
	/**
	 * Changes the view between day, week, and month.
	 */
	public void changeView(String view)
	{
		CardLayout layout = (CardLayout) getLayout();
		layout.show(this, view);
		currView = view;
	}
	
	public void setAgendaView(/*parameters*/)
	{
		// Changing to agenda view would require different parameters (for the period).
	}
	
	private int year;
	private int month;
	private int day;
	
	private AbstractView dayView;
	
	private String currView;
	
	public static final String DAYVIEW = "0";
	public static final String WEEKVIEW = "1";
	public static final String MONTHVIEW = "2";
	public static final String AGENDAVIEW = "3";
}
