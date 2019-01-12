package commands;
import container.*;
import entities.*;
/**
 * the method of the class Assign Patient to the specific BedLabel
 * @author mashrafihaider
 *
 */
public class AssignPatientToBedCommand extends CommandStatus {
	/**
	 * It Assign the patient with the specific bed label
	 * @param HealthNumber
	 * @param bed_label
	 */
	public void assignPatientToBed(Integer HealthNumber,int bed_label)
	{
		Patient patient=PatientAccess.patients().get(HealthNumber);
		
		if (patient.getBedLabel() != -1){
			String error=" Patient " + patient
					+ " is already in a bed so cannot be assigned a new bed";
			this.errorMessage=error;
			this.successful=false;
			throw new RuntimeException(error);}
		
		if (bed_label < WardAccess.ward().getMinBedLabel() || bed_label > WardAccess.ward().getMaxBedLabel()){
			String error="Bed label " + bed_label + " is not valid, as "
					+ "the value must be between " + WardAccess.ward().getMinBedLabel() 
					+ " and " + WardAccess.ward().getMaxBedLabel();
			
			this.errorMessage=error;
			this.successful=false;
			throw new RuntimeException(error);
		}
		patient.setBedLabel(bed_label);
		
		WardAccess.ward().assignPatientToBed(patient,bed_label);
		this.successful=true;
		
	}


}
