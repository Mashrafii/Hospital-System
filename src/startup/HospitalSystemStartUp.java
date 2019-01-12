package startup;
import container.*;
/**
 * The method of this class
 * @author mashrafihaider
 *
 */
public final class HospitalSystemStartUp {
	private HospitalSystemStartUp(){
		
	}
	/**
	 * start the hospital system
	 * @param name
	 * @param minBedLabel
	 * @param maxBedLabel
	 */
	public static void start(String name,int minBedLabel,int maxBedLabel){
		DoctorAccess.intialize();
		PatientAccess.intialize();
		WardAccess.initialize(name, minBedLabel, maxBedLabel);
		
	}

}
