import java.awt.GridLayout;

import javax.swing.JFrame;

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
		
		// From file
		FromFileButton fromFileButton = new FromFileButton(new FromFilePrompt(events));
		
		// Main frame
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(2, 3));
		frame.add(new CreateEventButton());
		//frame.add(new ViewSelector());
		frame.add(fromFileButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);;
	}
}
