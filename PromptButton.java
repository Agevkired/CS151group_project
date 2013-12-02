import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This class is used to construct a button to display a prompt.
 * Part of controller.
 * @author Ryan Vo
 * @version 2013-12-01
 *
 */
public class PromptButton extends JButton
{
	public PromptButton(String text, JFrame aPrompt)
	{
		setText(text);
		prompt = aPrompt;
		addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					prompt.setVisible(true);
				}
			});
	}
	
	private JFrame prompt;
}

