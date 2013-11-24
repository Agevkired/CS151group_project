/**
 * This class displays different views of the model.
 * @author
 *
 */

public class View extends // My first guess would be JTextArea, but I don't know.
{
	/* This class may need to be refactored heavily. It may be even needed to be broken into
	 * muliple classes, perhaps sharing the same interface. I can't imagine how to do weekly
	 * or monthly view with just a JTextArea. 
	 */
	
	/**
	 * Changes the day. Changing the day may also change the view.
	 * @param year The year.
	 * @param month The month (1-12).
	 * @param day The day.
	 */
	
	void changeDay(int year, int month, int day)
	{
		
	}
	
	/**
	 * Changes the view between day, week, and month.
	 */
	void changeView(/*parameters*/)
	{
		
	}
	
	void changeToAgendaView(/*parameters*/)
	{
		// Changing to agenda view would require different parameters (for the period).
	}
}
