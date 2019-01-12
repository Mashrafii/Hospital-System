package commands;
import java.util.HashMap;

import container.*;
import entities.Patient;
/**
 * It add patient to the static HaspMap of Patient where the value is the Patient
 * @author mashrafihaider
 *
 */
public class AddPatientCommand extends CommandStatus  {
	/**
	 * Implement the AddPatient command
	 * @param Name
	 * @param HealthNumber
	 * @throws RuntimeException
	 */
	public void addPatient(String Name,int HealthNumber)throws RuntimeException{
		HashMap<Integer,Patient>patientMap=PatientAccess.patients();
		if (patientMap.containsKey(HealthNumber))
		{   
			String error="Patient not added as there already "
                    + "is a patient with the health number " + HealthNumber;
			this.errorMessage=error;
			this.successful=false;
			throw new RuntimeException(error);
			
		}
		else
		{
			Patient patient = new Patient(Name, HealthNumber);
			Patient sameNumberPatient=PatientAccess.patients().put(HealthNumber,patient);
			if (sameNumberPatient != null)
			{
				PatientAccess.patients().put(HealthNumber, sameNumberPatient); // put the original patient back
				String error="Health number in the patient dictionary even "
					       + "though containsKey failed.  Number " + HealthNumber + " not entered.";
				this.errorMessage=error;
				this.successful=false;
				throw new RuntimeException(error);
			}
			this.successful=true;
		}
		
		
	}


}
