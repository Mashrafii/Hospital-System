package controller;
import javax.swing.JOptionPane;

import commands.*;
import startup.*;
import userInterface.IOAccess;;
/**
 * It implements all the method of the Hospital System
 * @author mashrafihaider
 *
 */
public class HospitalSystemController {
	private AddPatientCommand addPatientCommand;
	private AssignPatientToBedCommand assignPatientToBedCommand;
	private ListEmptyBedsCommand listEmptyBedsCommand;
	private ReleasePatientFromWardCommand releasePatientFromWardCommand;
	private CommandStatus lastCommandStatus;
	private IOAccess IO;
	private DisplayCurrentSystem displayCurrentSystem;
	public HospitalSystemController(){
		addPatientCommand=new AddPatientCommand();
		assignPatientToBedCommand= new AssignPatientToBedCommand();
		listEmptyBedsCommand=new ListEmptyBedsCommand();
		releasePatientFromWardCommand= new ReleasePatientFromWardCommand();
		displayCurrentSystem=new DisplayCurrentSystem();
		this.lastCommandStatus=null;
		IO=new IOAccess();
	}
	/**
	 * It start the Hospital System
	 */
	public void startUpHopsital()
	{
		// Use your HospitalSystemStartUp class to initialize the hospital data (Patients, Doctors, Ward)
		String name=IO.getinOut().readString("Please enter the name of the ward");
		int minBedLabel=IO.getinOut().readInt("Please enter the first Bed Label");
		int maxBedLabel=IO.getinOut().readInt("Please enter the last Bed Label");
		HospitalSystemStartUp.start(name, minBedLabel, maxBedLabel);
	}
	/**
	 * It add the patient on the HashMap of Patient
	 */
	public void addPatient()
	{
		// Use your this.addPatientCommand property to perform the operation.
		
		// Save the status of addPatientCommand somehow.
		// 		e.g.  this.lastCommandStatus = this.addPatientCommand
		
		String name=IO.getinOut().readString("Please enter the name of the patient");
		int HealthNumber=IO.getinOut().readInt("Please enter the HealthNumber");
		
		addPatientCommand.addPatient(name,HealthNumber);
		this.lastCommandStatus=this.addPatientCommand;
		if(!lastCommandStatus.wasSuccessful()){
			throw new RuntimeException(lastCommandStatus.getErrorMessage());
		}
			
		}
	/**
	 * It display the emptybed
	 */
	public void listEmptyBeds(){
		String info=listEmptyBedsCommand.listEmptyBed();
		if(IO.getOption().equals("DialogBox")){
			JOptionPane.showMessageDialog(null,info);
		}
		System.out.println(info);
	}
	/**
	 * It Assign a patien to a specific bed
	 */
	public void assignPatientToBed(){
		Integer HealthNumber=IO.getinOut().readInt("Please enter the HealthNumber");
		int bed_label=IO.getinOut().readInt("Please enter the bed_label");
		assignPatientToBedCommand.assignPatientToBed(HealthNumber, bed_label);
		this.lastCommandStatus=this.assignPatientToBedCommand;
		if(!lastCommandStatus.wasSuccessful()){
			throw new RuntimeException(lastCommandStatus.getErrorMessage());
		}
		
	}
	/**
	 * It release the patient from the ward
	 */
	public void releasePatientFromWard(){
		int HealthNumber=IO.getinOut().readInt("Please enter the HealthNumber of the patient released");
		releasePatientFromWardCommand.releasePatientFromWard(HealthNumber);
		this.lastCommandStatus=this.releasePatientFromWardCommand;
		if(!lastCommandStatus.wasSuccessful()){
			throw new RuntimeException(lastCommandStatus.getErrorMessage());
		}
		
		
	}
	/**
	 * It display the current sysytem of the hospital system
	 */
	public void displayCurrentSystem(){
		String result=displayCurrentSystem.toString();
		if(IO.getOption().equals("DialogBox")){
			JOptionPane.showMessageDialog(null,result);
		}
		System.out.println(result);
		
	}
	/**
	 * It returns the last command status
	 * @return
	 */
	public CommandStatus getLastCommandStatus()
	{
		return this.lastCommandStatus;
	}
	/**
	 * It returns the IO
	 * @return
	 */
	public IOAccess getIO(){
		return IO;
	}
	
	
	

}
