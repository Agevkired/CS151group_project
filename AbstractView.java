import javax.swing.JPanel;

/**
 * This class displays different views of the model.
 * @author
 *
 */
public abstract class AbstractView extends JPanel
{
	abstract void setDay(int year, int month, int day);
	abstract void refresh();
}
