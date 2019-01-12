package commands;

import entities.*;
import container.*;

/**
 * The method of the class display the empty list of bed
 * @author mashrafihaider
 *
 */

public class ListEmptyBedsCommand {
	/**
	 * Display the empty list of bed
	 * @return stringInfo A String of empty list of bed
	 */
	public String listEmptyBed(){
		Ward ward=WardAccess.ward();
		String stringInfo=" ";
		for (int i = ward.getMinBedLabel(); i <= ward.getMaxBedLabel(); i++){
			if (!ward.isOccupied(i)){
				stringInfo=stringInfo+"\nbed"+" "+i+"is empty";
				
			}
				
		
	}
   
   return stringInfo;
   }
}
