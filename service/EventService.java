package Alumini_Management_System.service;

import java.util.*;

import Alumini_Management_System.model.EventModel;
import Alumini_Management_System.repository.EventRepo;
import Alumini_Management_System.repository.aluminiRepo;
public class EventService {

	Scanner k=new Scanner(System.in);
	EventRepo evRepo=new EventRepo();
	EventModel evm;
	aluminiRepo alr;
	Vector <EventModel>v2;
	
/*-------------------this is for add event------------------------------*/
	public void addEvent() {
		
		k.nextLine();
		boolean flag=false;
		System.out.println("\n------------------------------------------------");
		System.out.println("Enter Event Name...");
		String ev_name=k.next();
		try {
			v2=evRepo.getEventDetails();
			for(EventModel evm:v2) {
				if(evm.getEv_name().equals(ev_name)) {
					flag=true;
					break;
				}
			}
		}
		catch(Exception e) {
			
		}
		if(!flag) {
			System.out.println("Enter Event Date(dd/mm/yyyy): ");
			String ev_date=k.next();
			System.out.println("Enter Time(Hour:minute)(am/pm):");
			String ev_time=k.next();
			
			evm=new EventModel(ev_name,ev_date,ev_time,alr.getAluminiData());
			
			boolean b=evRepo.isEventAdd(evm);
			
			if(b) {
				System.out.println("Event Added Successfully.... :)");
			}
			else {
				System.out.println("There is something wrong..... :(");
			}
		}
		else {
			System.out.println("Event Already Present....");
		}
		
	}
	
/*--------------------this is for show Event with Alumini data----------------------*/
	
	public void showEventAlumini() {
		
		v2=evRepo.getEventDetails();
		
		if(v2.size()>0) {
			
			System.out.println("\n-------------------------------------------------------------------------------------");
			System.out.println("Event Name\t || Date\t || Time");
			System.out.println("-------------------------------------------------------------------------------------");
			
			for(int i=0;i<v2.size();i++) {
				
				Object ob=v2.get(i);
				EventModel evm=(EventModel)ob;
				System.out.println(evm.getEv_name()+"\t"+evm.getEv_date()+"\t"+evm.getEv_time());
				
				
			}
			
		}
		else {
			System.out.println("There is no Event Record found.......");
		}
	}
}
