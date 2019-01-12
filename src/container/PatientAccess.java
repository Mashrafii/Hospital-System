package container;
import entities.*;

import java.util.HashMap;
/**
* It is a static class which has method to intialize and return the Patient HashMap
* @author mashrafihaider
*
*/
public class PatientAccess {
	private PatientAccess(){
		
	}
	private static HashMap<Integer,Patient>patients;
	/**
	 * Intialize the patient HashMap
	 */
	public static void intialize(){
		patients=new HashMap<Integer,Patient>();
	}
	/**
	 * return the patient HashMap
	 * @return
	 */
	public static HashMap<Integer,Patient> patients(){
		if(patients==null){
			throw new RuntimeException("Intialize patients first.Call PatientAccess.intialize()");
			
		}
		return patients;
	}
	

}
