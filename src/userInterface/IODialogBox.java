package userInterface;
import javax.swing.*;

public class IODialogBox extends AbstractDialogIO implements InputOutputInterface {
	/**
	 * Display a prompt and read the string entered.
	 * @param prompt the string to be displayed as a prompt
	 * @return  the String read 
	 */
	
		/**
	     * Read in a String using the specified prompt.
	     * 
	     * @param prompt the String to be used to prompt the user
	     * @return the String obtained
	     */
	    public String readString(String prompt) {
	        return JOptionPane.showInputDialog(null, prompt);
	    }
	    

	    /**
	     * Read in an int value using the specified prompt.
	     * 
	     * @param prompt the String to be used to prompt the user
	     * @return the int value obtained
	     */
	    public int readInt(String prompt) {
	        String valueAsString = JOptionPane.showInputDialog(null, prompt);
	        int value;
	        if (valueAsString != null && valueAsString.length() > 0) {
	            try {
	                value = Integer.parseInt(valueAsString);
	            } catch (NumberFormatException e) {
	                value = readInt("Please enter an integer value!\n" + prompt);
	            }
	        } else
	            value = readInt("Please enter an integer value!\n" + prompt);
	        return value;
	    }
	    /**
	     * Read the choice from different option and return one
	     */
	    public int readChoice(String[] options){
	    	int input=super.readChoice(options);
	    	return input;
	    }
	    /**
	     * (non-Javadoc)
	     * @see userInterface.InputOutputInterface#outputString(java.lang.String)
	     */
	    public void outputString(String outString){
	    	JOptionPane.showMessageDialog(null,outString);
	    }


	    

	}


