package commands;
/**
 * The method of the class determine whether the function is right or wrong
 * @author mashrafihaider
 *
 */
public class CommandStatus {
	protected boolean successful = false;
	protected String errorMessage;
	/**
	 * It return a bool value and return true when the last command was successful and false when the last command was failed
	 * @return
	 */
	public boolean wasSuccessful() {
		return successful;
		
	}
	/**
	 * Return an error message if the last command fail
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
		
	}
	
	
	
}

	
		


