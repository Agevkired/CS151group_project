import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This class is used to construct a button to display a prompt.
 * Part of controller.
 * @author Ryan Vo
 * @version 2013-11-30
 *
 */
public class FromFileButton extends JButton
{
	public FromFileButton(FromFilePrompt aPrompt)
	{
		setText(TEXT);
		prompt = aPrompt;
		addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					prompt.setVisible(!prompt.isVisible());
				}
			});
	}
	
	private FromFilePrompt prompt;
	private final String TEXT = "From File";
}
