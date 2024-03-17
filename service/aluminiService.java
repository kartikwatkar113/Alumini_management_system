package Alumini_Management_System.service;
import java.util.*;

import Alumini_Management_System.model.aluminiModel;
import Alumini_Management_System.repository.aluminiRepo;

public class aluminiService {
	Scanner k=new Scanner(System.in);
	aluminiRepo alr=new aluminiRepo();
	Vector<aluminiModel>vc;
	
	
/*-----------------this is for add data in vector---------------*/
	
	
	public void addAluminiData() {

		boolean flag = false;
		System.out.println("Enter Alumini Batch...");
		String alumini_batch = k.next();
		System.out.println("Enter Alumini ID...");
		int alumini_id=k.nextInt();
		System.out.println("Enter Alumini Name...");
		String alumini_name = k.next();
		System.out.println("Enter Alumini Email...");
		String alumini_email = k.next();
		try {
			vc = alr.getAluminiData();
			for (aluminiModel alm : vc) {
				if (alm.getAlumini_email().equals(alumini_email)) {
					flag = true;
					break;
				}
			}

		} catch (Exception e) {

		}

		if (!flag) {

			System.out.println("Enter Alumini Mobile Number...");
			String alumini_mob = k.next();
			System.out.println("Enter Alumini Address...");
			String alumini_address = k.next();
			System.out.println("Enter Alumini Job Desription...");
			String alumini_jd = k.next();

			aluminiModel alm = new aluminiModel(alumini_batch,alumini_id, alumini_name, alumini_email, alumini_mob,
					alumini_address, alumini_jd);


			boolean b = alr.isAluminiAdd(alm);

			if (b) {
				System.out.println("Alumini Record Saved Succesfully..... :)");
			}
		} else {
			System.out.println("Record Already Present.....");
		}
	}
	
/*--------------------this is for show data------------------- */
	
	public void show() {
		
		try {
			vc=alr.getAluminiData();
			
			if(vc.size()>0) {
				System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
				System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
				
				for(aluminiModel alm:vc) {
					System.out.println(alm.getAlumini_batch()+"\t"+alm.getAlumini_id()+"\t"+alm.getAlumini_name()+"\t"+alm.getAlumini_email()+"\t"+alm.getAlumini_mob()+"\t"+alm.getAlumini_address()+"\t"+alm.getAlumini_jd());
				}
			}
			else {
				System.out.println("there are no Alumini Records to Show.... :(");
			}
		}
		catch(Exception e) {
			System.out.println("All Record Deleted... ");
		}
	}
	
	/*--------------------this is for searching----------------------*/
	
	public Vector<aluminiModel>searchByID(int alumini_id) {
		Vector v1=new Vector();
		boolean flag=false;
		vc=alr.getAluminiData();
		
		for(aluminiModel alm:vc){
			
			if(alm.getAlumini_id()==alumini_id){
				v1.add(alm);
			}
		}
		
		return v1;

	}
	public Vector<aluminiModel> searchByName(String alumini_name) {
		Vector v1=new Vector();
		boolean flag=false;
		vc=alr.getAluminiData();
		for(aluminiModel alm:vc) {
			if(alm.getAlumini_name().equals(alumini_name)) {
				v1.add(alm);
			}
		}
		return v1;
		
	}
	public Vector<aluminiModel> searchByEmail(String alumini_email) {
		Vector v1=new Vector();
		boolean flag=false;
		vc=alr.getAluminiData();
		for(aluminiModel alm:vc) {
			if(alm.getAlumini_email().equals(alumini_email)) {
				v1.add(alm);
			}
		}
		return v1;
	
	}
	
/*-------------------------this is for updation by id--------------------------------*/
	
	public void update(String alumini_batch,int alumini_id) {
		aluminiModel alm = null;
		vc = alr.getAluminiData();

		if (vc.size() > 0) {
			int flag = 0;
			String modify_batch = null;
			
			for (int i = 0; i < vc.size(); i++) {
				Object ob = vc.get(i);
				aluminiModel alm1 = (aluminiModel) ob;
				if (alm1.getAlumini_batch().equals(alumini_batch)) {

					if (alm1.getAlumini_id() == alumini_id) {
						int choice;

							System.out.println("<><><><><>><><><><><><><><><><><><><>");
							System.out.println("1.Do you Want to Change Batch...");
							System.out.println("2.Remain As it is...");
							System.out.println("3.Exit...");
							System.out.println("<><><><><>><><><><><><><><><><><><><>");
							choice = k.nextInt();

							switch (choice) {
							case 1: {
								System.out.println("Enter Modify Batch: ");
								modify_batch = k.next();
								System.out.println("Enter Modify Alumini Name...");
								String modify_name = k.next();
								System.out.println("Enter Modify Alumini Email...");
								String modify_email = k.next();
								System.out.println("Enter Modify Alumini Mobile Number...");
								String modify_mob = k.next();
								System.out.println("Enter Modify Alumini Address...");
								String modify_address = k.next();
								System.out.println("Enter Modify Alumini Job Desription...");
								String modify_jd = k.next();

								alm = new aluminiModel(modify_batch, alm1.getAlumini_id(), modify_name, modify_email,
										modify_mob, modify_address, modify_jd);
								vc.setElementAt(alm, i);
								System.out.println("Alumini Data Modify succesfully..... :)");
								
							}
								break;
							case 2: {
								System.out.println("Enter Modify Alumini Name...");
								String modify_name = k.next();
								System.out.println("Enter Modify Alumini Email...");
								String modify_email = k.next();
								System.out.println("Enter Modify Alumini Mobile Number...");
								String modify_mob = k.next();
								System.out.println("Enter Modify Alumini Address...");
								String modify_address = k.next();
								System.out.println("Enter Modify Alumini Job Desription...");
								String modify_jd = k.next();

								alm = new aluminiModel(alm1.getAlumini_batch(), alm1.getAlumini_id(), modify_name,
										modify_email, modify_mob, modify_address, modify_jd);
								vc.setElementAt(alm, i);
								System.out.println("Alumini Data Modify succesfully..... :)");
							}
								break;
							}

						break;
						
					} else {
						System.out.println("Enter Valid ID.....");
					}
				} else {
					System.out.println("Entered Valid Batch Name....");
				}
			}

		} else {
			System.out.println("There are no Records Found .... :(");
		}
		
	}
	
/*----------------this is for deletion by id------------------------*/
	
	public void delete() {
		
		
		vc=alr.getAluminiData();
		
		if (vc.size() > 0) {
			boolean flag=false;
			System.out.println("Enter Batch First for Updation: ");
			String alumini_batch=k.next();
			System.out.println("Enter ID for Updation: ");
			int alumini_id=k.nextInt();
			
			for (int i = 0; i < vc.size(); i++) {
				Object ob = vc.get(i);
				aluminiModel alm = (aluminiModel) ob;
				if (alm.getAlumini_batch().equals(alumini_batch)) {
					
					if(alm.getAlumini_id()==alumini_id) {
						vc.remove(i);
						flag = true;
					}
					else {
						System.out.println("Enter valid ID....");
					}
				}
				else {
					System.out.println("Enter valid Batch Name....");
				}
			}
			
			if(flag) {
				System.out.println("Alumini's Data Deleted Succesfully... :)");
			}
			else {
				System.out.println("Entered Data not found... :(");
			}
			
		} else {
			System.out.println("There are no Records Found .... :(");
		}
		
	}
	
	
}
