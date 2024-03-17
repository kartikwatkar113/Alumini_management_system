package Alumini_Management_System.client;

import java.util.*;

import Alumini_Management_System.model.aluminiModel;
import Alumini_Management_System.service.aluminiService;

public class Alumini_MS_mainClass{

	public static void main(String[] args){
		
		Scanner k=new Scanner(System.in);
		int choice;
		
		aluminiService als=new aluminiService();
		
		Vector<aluminiModel>v1;
		
		do {
			System.out.println("===========================================");
			System.out.println("1.Add Alumini's in the Record");
			System.out.println("2.Show Alumini's in the Record Batch Wise");
			System.out.println("3.Search Alumini's Data");
			System.out.println("4.Update Alumini Details by ID");
			System.out.println("5.Delete Alumini");
			System.out.println("6.Add Event ");
			System.out.println("===========================================");
			System.out.println("Enter choice: ");
			choice=k.nextInt();
			
			switch(choice) {
				
				case 1:{
					
					als.addAluminiData();
								
				}
				break;
				
				case 2:{
					als.show();
				}
				break;
				
				case 3:{
					int choice1;
					
					do{
						System.out.println("<><><><><><><><><><><><><><><>");
						System.out.println("1.Search By ID");
						System.out.println("2.Search By Name");
						System.out.println("3.Search By Email ID");
						System.out.println("4.Exit");
						System.out.println("<><><><><><><><><><><><><><><>");
						System.out.println("Enter choice: ");
						choice1=k.nextInt();
						switch(choice1) {
						
							case 1:{
								
								System.out.println("Enter ID for Search: ");
								int alumini_id=k.nextInt();
								v1=als.searchByID(alumini_id);
								
								if(v1.size()>0) {
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									
									for(aluminiModel alm:v1) {
										System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
									}
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
								}
								else {
									System.out.println("No Alumini Found...");
								}
								
								
							}
							break;
							
							case 2:{
								System.out.println("Enter Name for Search: ");
								String alumini_name=k.next();
								v1=als.searchByName(alumini_name);
								
								if(v1.size()>0) {
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									
									for(aluminiModel alm:v1) {
										System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
									}
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
								}
								else {
									System.out.println("No Alumini Found...");
								}
								
							}
							break;
							
							case 3:{
								System.out.println("Enter Email ID for Search: ");
								String alumini_email=k.next();
								v1=als.searchByEmail(alumini_email);
								System.out.println(v1);
								if(v1.size()>0) {
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
									
									for(aluminiModel alm:v1) {
										System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
									}
									System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
								}
								else {
									System.out.println("No Alumini Found...");
								}
								
							}
							break;
						}
						
					}while(choice1>=3);
				}
				break;

				case 4:{
					
					System.out.println("Enter Batch First for Updation: ");
					String alumini_batch=k.next();
					System.out.println("Enter ID for Updation: ");
					int alumini_id=k.nextInt();
					als.update(alumini_batch,alumini_id);
				}				
				break;

				case 5:{
					
					
					als.delete();
				}
				break;

				case 6:{
					
				}
				break;

				case 7:{
	
				}				
				break;

				case 8:{
	
				}
				break;

				case 9:{
	
				}
				break;
				
				default:
				System.out.println("Please Entered Valid Choice.....");
				
			}
			
		}while(choice<=9);

	}

}
