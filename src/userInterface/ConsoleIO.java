package userInterface;
import java.util.Scanner;

import java.util.InputMismatchException;
/**
 * It manage the input from the console
 * @author mashrafihaider
 *
 */
public class ConsoleIO implements InputOutputInterface {
	protected Scanner input=new Scanner(System.in);
	/**
	 * It takes in the input String from the user and return name 
	 */
	public String readString(String prompt){
		System.out.print(prompt);
		
		String name=input.nextLine();
		return name;
		
	}
	/**
	 * It takes in the input Integer from the user
	 */
	public int readInt(String prompt){
		int result = 0; // must be initialized
        boolean successful;
        do {
            System.out.print(prompt);
            successful = true;
            try {
                result = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                successful = false;
                String faultyInput = input.nextLine();
                System.out.print("Not a valid int value, you entered \""
                        + faultyInput + "\".  Please try again.\n\t");
            }
        } while (!successful);
        
        return result;
	}
	/**
	 * read the choice of the Hospital System and return
	 * 
	 */
	public int readChoice(String[]option){
		
		String info="Please select an operation to do";
		for(int i=0;i<option.length;i++){
			info+=option[i];
			
		}
		info+="\nPlease enter the number of your selection: ";
		int result =readInt(info);
                                                                 // read the end of line after the command id
        return result;
	}
	/**
	 * Output the string
	 */
	public void outputString(String outString){
		System.out.println(outString);
	}

	
	

}

//final String[] option={"\n0: quit","\n1: add a new patient","\n2: assign a patient a bed","\n3: release a patient","\n4: display empty beds","\n5: display current system state"};

