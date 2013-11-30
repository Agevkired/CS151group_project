/**
 * This exception should be thrown when an event cannot be added.
 * @author Ryan Vo
 * @version 2013-11-28
 */
public class CannotAddEventException extends RuntimeException 
{
	/**
	 * Default constructor.
	 */
	public CannotAddEventException()
	{
		
	}
	
	/**
	 * Constructs a CannotAddEventException and includes the reason.
	 * @param reason The reason why the exception was thrown.
	 */
	public CannotAddEventException(String reason)
	{
		super(reason);
	}
}
