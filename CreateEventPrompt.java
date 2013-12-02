import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Prompts the user to enter the event details and then tries to add event to model.
 * If there is an error, the prompt should tell the user about the error and let them try again.
 * Part of controller.
 * @author
 *
 */
public class CreateEventPrompt extends JFrame // a guess to what it should extend.
{
	public CreateEventPrompt(CalendarEventList list)
	{

		events = list;
        
        // Input fields
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4, 2));
        
        textPanel.add(new JLabel("Event name: "));
        final JTextField desc = new JTextField(TEXT_FIELD_WIDTH);
        textPanel.add(desc);
        
        textPanel.add(new JLabel("Date (MM/DD/YYYY): "));
        final JTextField date = new JTextField(TEXT_FIELD_WIDTH);
        textPanel.add(date);
        
        textPanel.add(new JLabel("Start Hour: "));
        final JTextField startTime = new JTextField(TEXT_FIELD_WIDTH);
        textPanel.add(startTime);
        
        textPanel.add(new JLabel("End Hour: "));
        final JTextField endTime = new JTextField(TEXT_FIELD_WIDTH);
        textPanel.add(endTime);
        
        // Input button and error message
        JButton button = new JButton("Create");
        final JLabel errorLabel = new JLabel(" ");
        button.addActionListener(new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        try
                        {
                           String[] dateFields = date.getText().split("/");
                           int mon = Integer.parseInt(dateFields[0]);
                           int day = Integer.parseInt(dateFields[1]);
                           int year = Integer.parseInt(dateFields[2]);
                           
                           int stHour = Integer.parseInt(startTime.getText());
                           
                           int etHour = Integer.parseInt(endTime.getText());
                           
                           events.addEvent(new CalendarEvent(desc.getText(), year, mon, day, stHour, etHour));
                           
                           setVisible(false);
                           
                        }
                        catch (CannotAddEventException e)
                        {
                            if(e.getMessage() != null)
                            	errorLabel.setText(e.getMessage());
                            else
                            	errorLabel.setText("Time conflict! Event could not be added");
                        }
                        catch (Exception e)
                        {
                        	errorLabel.setText("Please check your input.");
                        }
                    }
                });

        // Initialize frame
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);
        add(errorLabel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
		setVisible(false);
	}
	
	private CalendarEventList events;
	
	private final int TEXT_FIELD_WIDTH = 10;
}
