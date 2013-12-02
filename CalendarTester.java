import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class runs the entire project. Everything comes together here.
 * @author Cobra
 *
 */
public class CalendarTester 
{
	public static void main(String Args[])
	{
		// Model
		CalendarEventList events = new CalendarEventList();
		
		// Create event
		PromptButton createEventButton = new PromptButton("CREATE", new CreateEventPrompt(events));
		
		// From file
		PromptButton fromFileButton = new PromptButton("From File", new FromFilePrompt(events));
		
		// View
		final ViewManager viewManager = new ViewManager(events);
		events.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent e) 
				{
					viewManager.refresh();					
				}
			});
	
		// Main frame
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(2, 3));
		frame.add(createEventButton);
		//frame.add(new ViewSelector());
		frame.add(fromFileButton);
		//miniCalendar
		frame.add(viewManager);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);;
	}
}
