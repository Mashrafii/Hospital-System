package commands;

import java.util.Collection;

import container.*;
import entities.*;
/**
 * Display the current system of the hospital system
 * @author mashrafihaider
 *
 */
public class DisplayCurrentSystem {
	/**
	 * Display the current system of the hospital system
	 */
	public String toString()
	{
		String result = "\nThe patients in the system are \n";
		Collection<Patient> patientsColl = PatientAccess.patients().values();
		for (Patient p: patientsColl)
			result = result + p;
		result = result + "\nThe doctors in the system are \n";
		Collection<Doctor> doctorsColl = DoctorAccess.doctors().values();
		for (Doctor d: doctorsColl)
			result = result + d;
		result = result + "\nThe ward is " + WardAccess.ward();
		return result;
	}

}
