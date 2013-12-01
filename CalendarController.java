package cs151_project;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
//import java.util.TimeZone;
import javax.swing.JFrame;

public class CalendarController extends JFrame
{
	private CreateButtonView create;
	private AgendaView agenda; 
	private CalendarView calendar;
	private CalendarModel calmodel;
	private Calendar cal;
	public CalendarController()
	{
            cal = new GregorianCalendar();
            super.setLayout(new GridLayout(2,2));	
	}
}
