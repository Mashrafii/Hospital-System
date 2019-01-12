package container;
import java.util.HashMap;

import entities.*;
/**
 * It is a static class which has method to intialize the Doctor HashMap
 * @author mashrafihaider
 *
 */
public class DoctorAccess {
	
	private DoctorAccess(){
		
	}
	
    private static HashMap<String,Doctor>doctors;
	/**
	 * Intialize the doctor HashMap
	 */
	public static void intialize(){
		doctors=new HashMap<String,Doctor>();
	}
	/**
	 * return the doctor HashMap
	 * @return
	 */
	public static HashMap<String,Doctor> doctors(){
		if(doctors==null){
			throw new RuntimeException("Intialize doctor first.Call DoctorAccess.intialize()");
			
		}
		return doctors;
	}

}
