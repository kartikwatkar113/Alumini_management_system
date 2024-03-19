package Alumini_Management_System.repository;

import java.util.ArrayList;
import Alumini_Management_System.model.aluminiModel;

public class aluminiRepo {

	static ArrayList<aluminiModel>almodel=new ArrayList<aluminiModel>();
	
	
	public boolean isAluminiAdd(aluminiModel alm) {
		
		boolean b=almodel.add(alm);
		return b;
		
	}
	
	
	public ArrayList<aluminiModel> getAluminiData() {
		
		return almodel!=null?almodel:null;
		
	}
	
/*-------------this is for attendance------------*/
	
	public boolean isAluminiPresent(String alumini_name) {
		
		for(aluminiModel alm:almodel) {
			if(alm.getAlumini_name().equalsIgnoreCase(alumini_name)) {
				return true;
			}
		}
		return false;
		
	}
	
	
	
	
}
