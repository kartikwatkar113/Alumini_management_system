package Alumini_Management_System.repository;

import java.util.Vector;

import Alumini_Management_System.model.EventModel;

public class EventRepo {
	EventModel evm=null;
	static Vector<EventModel>v2=new Vector<EventModel>();
	
	public boolean isEventAdd(EventModel evm) {
		
		boolean b=v2.add(evm);
		
		return v2.size()>0?b:null;
		
	}
	
	public Vector getEventDetails() {
		
		return v2;
	}

}
