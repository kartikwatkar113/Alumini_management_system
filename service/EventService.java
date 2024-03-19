package Alumini_Management_System.service;

import java.util.*;

import Alumini_Management_System.model.EventModel;
import Alumini_Management_System.model.aluminiModel;
import Alumini_Management_System.model.attendanceModel;
import Alumini_Management_System.repository.EventRepo;
import Alumini_Management_System.repository.aluminiRepo;



public class EventService {

	Scanner k=new Scanner(System.in);
	EventRepo evRepo=new EventRepo();
	
	aluminiModel alm=new aluminiModel();
	aluminiRepo alr=new aluminiRepo();
	
	
	ArrayList <EventModel>evemodel;
	ArrayList<aluminiModel>almodel;
	
/*-------------------this is for add event------------------------------*/
	public void addEvent() {
		
		boolean flag=false;
		System.out.println("\n------------------------------------------------");
		System.out.println("Enter Event Name...");
		String ev_name=k.next();
		try {
			evemodel=evRepo.getEventDetails();
			for(EventModel evm:evemodel) {
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
	
			EventModel evm=new EventModel(ev_name,ev_date,ev_time);
			
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
	
	public void showEvent() {

		try {
			
			evemodel=evRepo.getEventDetails();
			
			if(evemodel.size()>0) {
				
				System.out.println("\n-------------------------------------------------------------------------------------");
				System.out.println("Event Name\t || Date\t || Time");
				System.out.println("-------------------------------------------------------------------------------------");
				
				
				for(EventModel evm:evemodel) {
	
					System.out.println(evm.getEv_name()+"\t"+evm.getEv_date()+"\t"+evm.getEv_time());
				}
				
			}
			else {
				System.out.println("There is no Event Record found.......");
			}
			
		}
		catch(Exception e) {
			System.out.println("All Records Deleted.... :(");
		}
		
	}
	
/*-------------------this is for takeAttendance------------------*/
	
	public void takeAttendance() {
		k.nextLine();
		System.out.println("Enter Alumini name: ");
		String alumini_name1=k.next();
		System.out.println("Enter Event name: ");
		String eve_name1=k.next();
		
		if(evRepo.takeAttendance(eve_name1,alumini_name1)) {
			System.out.println("Attendance Marked... :)");
		}
		else {
			System.out.println("There is something Wrong... :(");
		}

	}
	
/*----------------this is for present alumini----------------------*/
	
	public void presentAlumini() {
		
		System.out.println("Enter Event Name: ");
		String eve_name2=k.next();

		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(attendanceModel atm:evRepo.presentAlumini()) {
			
			for(aluminiModel alm:alr.getAluminiData()) {
				
				if( atm.getAlumini_name1().equalsIgnoreCase(alm.getAlumini_name())&& atm.getEve_name1().equalsIgnoreCase(eve_name2)) {
					
					alm.setStatus(true);
					System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
				}
			}
		}
	}
	
/*----------------------this is for Absent alumini-----------------*/
	
	public void absentAlumini() {

		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");

			
			for(aluminiModel alm:alr.getAluminiData()) {				

					
					if(alm.isStatus()==false) {

						System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
					}
					
			}
			for(aluminiModel alm:alr.getAluminiData()) {
				
				alm.setStatus(false);
			}
		
	}
}
