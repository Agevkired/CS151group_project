import javax.swing.JButton;

/** 
 * This class is used to construct the "Create" button.
 * @author Ryan Vo
 * @version 2013-11-23
 *
 */
public class CreateEventButton extends JButton
{
	public CreateEventButton()
	{
		setText(TEXT);
	}
	
	// In main, use addActionListner to show prompt to add event.
	
	private final String TEXT = "CREATE";
}
