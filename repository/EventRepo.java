package Alumini_Management_System.repository;

import java.util.ArrayList;

import Alumini_Management_System.model.EventModel;
import Alumini_Management_System.model.aluminiModel;
import Alumini_Management_System.model.attendanceModel;

public class EventRepo {
	aluminiModel alm=new aluminiModel();
	aluminiRepo alr=new aluminiRepo();
	
	static ArrayList<EventModel>evemodel=new ArrayList<EventModel>();
	static ArrayList<attendanceModel>atmodel=new ArrayList<attendanceModel>();
	
	public boolean isEventAdd(EventModel evm) {
		
		boolean b=evemodel.add(evm);
		
		return evemodel.size()>0?b:null;
		
	}
	
	public ArrayList<EventModel> getEventDetails() {
		
		return evemodel;
	}
	
/*-----------------this is for attendance-------------------*/
	
	public boolean takeAttendance(String eve_name,String alumini_name) {
		
		if(alr.isAluminiPresent(alumini_name)) {
			
			attendanceModel atm=new attendanceModel(eve_name,alumini_name);
			boolean b=atmodel.add(atm);
			return b;
		}
		else {
			System.out.println("Alumini is not present... :(");
			return false;
		}
		
	}
	
/*-------------this is for present alumini--------------*/

	public ArrayList<attendanceModel> presentAlumini() {
		
		return atmodel!=null?atmodel:null;
		
	}
}

