package userInterface;

import java.util.Scanner;
import controller.HospitalSystemController;


/**
 * It has method that runs the system
 * @author mashrafihaider
 *
 */

public class HospitalManager extends ConsoleIO {
	
	/**
	 * Runs the hospital system
	 */
	public void run()
	{
		input = new Scanner(System.in);
		HospitalSystemController controller=new HospitalSystemController();
		controller.startUpHopsital();
		String[] option={"\n0: quit","\n1: add a new patient","\n2: assign a patient a bed","\n3: release a patient","\n4: display empty beds","\n5: display current system state"};


		int opId =controller.getIO().getinOut().readChoice(option);
		while (opId != 0)
		{
			try
			{
				switch (opId)
				{
				case 1:
					controller.addPatient();
					break;
				case 2:
					controller.assignPatientToBed();
					break;
				case 3:
					controller.releasePatientFromWard();
					
					break;
				case 4:
					controller.listEmptyBeds();
					break;
				case 5:
					controller.displayCurrentSystem();
					break;
				
				default:
					System.out.println("Invalid task specification; try again\n");
				}
			} catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
			}

			opId =controller.getIO().getinOut().readChoice(option);
		}
		
		System.out.println("The system at shutdown is as follows: " + toString());
		input.close();
	}


	
	}


