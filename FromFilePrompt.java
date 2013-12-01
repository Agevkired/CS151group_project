import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Prompts the user to enter the file location, loads file, and then adds
 * file to model. Part of controller.
 * @author Ryan Vo
 * @version 2013-11-30
 *
 */
public class FromFilePrompt extends JFrame
{	
	public FromFilePrompt(CalendarEventList list)
	{
		// Initialize variables.
		initializeHashMap();
		events = list;
		
		// Initialize fields.
		JLabel label = new JLabel("Click on textbox to select file to load:");
		final JTextField textField = new JTextField(20);
		final JFileChooser fileChooser = new JFileChooser();
		textField.addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent event)
				{
					int action = fileChooser.showOpenDialog(null);
					if(action == JFileChooser.APPROVE_OPTION)
						textField.setText(fileChooser.getSelectedFile().getPath());
				}
			});
		JButton button = new JButton("Load File");
		button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if (!textField.getText().equals(""))
					{
						loadFile(textField.getText());
						setVisible(false);
					}
				}
			});
		
		// Initialize frame.
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(textField, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
		setVisible(false);
	}
	
	private void loadFile(String fileName)
	{
		Scanner in = null;
		try
		{
			in = new Scanner(new File(fileName));
		}
		catch (Exception e)
		{
			// do something
			System.out.println("File not found!");
			return;
		}
		
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			insertRepeatingEvent(line);			
		}
		
		try
		{
			in.close();
		}
		catch(Exception e)
		{
			// who cares
		}
	}
	
	private void initializeHashMap()
	{
		MAP.put(new Integer(Calendar.SUNDAY), new Character(DAYOFWEEK.charAt(0)));
		MAP.put(new Integer(Calendar.MONDAY), new Character(DAYOFWEEK.charAt(1)));
		MAP.put(new Integer(Calendar.TUESDAY), new Character(DAYOFWEEK.charAt(2)));
		MAP.put(new Integer(Calendar.WEDNESDAY), new Character(DAYOFWEEK.charAt(3)));
		MAP.put(new Integer(Calendar.THURSDAY), new Character(DAYOFWEEK.charAt(4)));
		MAP.put(new Integer(Calendar.FRIDAY), new Character(DAYOFWEEK.charAt(5)));
		MAP.put(new Integer(Calendar.SATURDAY), new Character(DAYOFWEEK.charAt(6)));
	}
		
	private void insertRepeatingEvent(String line)
	{
		// Get parameters
		String[] params = line.split(";");
		String eventName = params[0];
		int year = Integer.parseInt(params[1]);
		int startMonth = Integer.parseInt(params[2]);
		int endMonth = Integer.parseInt(params[3]);
		String days = params[4];
		int startHour = Integer.parseInt(params[5]);
		int endHour = Integer.parseInt(params[6]);
		
		// Prepare for iteration.
		GregorianCalendar startDate = new GregorianCalendar(year, startMonth - 1, 1, startHour, 0);
		GregorianCalendar endDate = new GregorianCalendar(year, endMonth - 1, 1, startHour, 0); // startHour is correct
		endDate.add(Calendar.MONTH, 1);  
		endDate.set(Calendar.DAY_OF_MONTH, 1);  
		endDate.add(Calendar.DATE, -1);
		GregorianCalendar currDate = (GregorianCalendar) startDate.clone();
		
		// Iterate.
		while(currDate.compareTo(endDate) <= 0)
		{
			if (days.indexOf(MAP.get(new Integer(currDate.get(Calendar.DAY_OF_WEEK)))) != -1)
			{
				try
				{
					events.addEvent(new CalendarEvent(eventName, year, currDate.get(Calendar.MONTH) + 1, 
							currDate.get(Calendar.DATE), startHour, endHour));
				}
				catch (CannotAddEventException e)
				{
					// should do something.
					System.out.println("Event could not be added.");
				}
			}
			currDate.add(Calendar.DATE, 1);
		} // wend
	}
	
	private CalendarEventList events;
	
	private final String DAYOFWEEK = "SMTWHFA";
	private final HashMap<Integer, Character> MAP = new HashMap<>();
}
