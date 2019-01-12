package commands;
import container.*;

import entities.*;
/**
 * The method of the class release patient from the Ward
 * @author mashrafihaider
 *
 */
public class ReleasePatientFromWardCommand extends CommandStatus {
	/**
	 * Released patient from the ward
	 * @param HealthNumber
	 */
	public void releasePatientFromWard(int HealthNumber)
	{   Patient patient=PatientAccess.patients().get(HealthNumber);
		if (patient.getBedLabel() == -1){
			String error=" ";
			error+="The patient must already have a bed.";
			this.errorMessage=error;
			this.successful=false;
			throw new RuntimeException(error);
		}
		int bedNum = patient.getBedLabel();
		if (WardAccess.ward().getPatient(bedNum) != patient){
			String error=" ";
			error+="The patient is not in the bed stored"
					+ " with the patient.  Bed " + bedNum
					+ " has patient " + WardAccess.ward().getPatient(bedNum);
			this.errorMessage=error;
			this.successful=false;
			throw new RuntimeException(error);
			
		}
		WardAccess.ward().freeBed(patient.getBedLabel());
		patient.release();
		this.successful=true;
	
	}

}
