package userInterface;

import javax.swing.JOptionPane;
/**
 * It determine whether the user wants to use the Dialog box or the Console
 * @author mashrafihaider
 *
 */
public class IOAccess {
	private String option;
	private static InputOutputInterface inOut;
	static String[] options={"DialogBox","Console"};
	/**
	 * It is the constructor of the IOAccess and determine whether the user wants to use Dialog box or Console and intialize accordingly
	 */
	public IOAccess(){
   	option=(String)JOptionPane.showInputDialog(
                null,                            // parent component
                "Please select an UserInterface option ",      // prompt
                "Choice Selection",              // window title
                JOptionPane.QUESTION_MESSAGE,    // type of message
                null,                            // icon displayed
                options,                         // choices for the Combo box
                options[0]); 
    switch(option){
    case "DialogBox":
    	inOut=new IODialogBox();
    	break;
    case "Console":
    	inOut=new ConsoleIO();
    	break;
    default:
    	break;
    }
    }
	/**
	 * Get the instance variable inOut
	 * @return
	 */
	public InputOutputInterface getinOut(){
		if (inOut==null){
			throw new RuntimeException("Intialize IOAccess first");
		}
		return inOut;
	}
	/**
	 * get the option that the user choose
	 * @return
	 */
	public String getOption(){
		return option;
	}
		

	}
	


