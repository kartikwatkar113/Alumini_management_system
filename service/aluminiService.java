package Alumini_Management_System.service;
import java.util.*;
import Alumini_Management_System.model.aluminiModel;
import Alumini_Management_System.repository.aluminiRepo;

public class aluminiService {
	Scanner k=new Scanner(System.in);
	aluminiRepo alr=new aluminiRepo();
	ArrayList<aluminiModel>almodel;
	
	
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
			almodel = alr.getAluminiData();
			for (aluminiModel alm : almodel) {
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
			almodel=alr.getAluminiData();
			
			if(almodel.size()>0) {
				System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("Alumini Batch\t||Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
				System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
				
				for(aluminiModel alm:almodel) {
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
	
	public ArrayList<aluminiModel>searchByID(int alumini_id) {
		ArrayList<aluminiModel> almodel1=new ArrayList<aluminiModel>();
//		boolean flag=false;
		almodel=alr.getAluminiData();
		
		for(aluminiModel alm:almodel){
			
			if(alm.getAlumini_id()==alumini_id){
				almodel1.add(alm);
			}
		}
		
		return almodel1;

	}
	public ArrayList<aluminiModel> searchByName(String alumini_name) {
		ArrayList<aluminiModel> almodel1=new ArrayList<aluminiModel>();
//		boolean flag=false;
		almodel=alr.getAluminiData();
		for(aluminiModel alm:almodel) {
			if(alm.getAlumini_name().equals(alumini_name)) {
				almodel1.add(alm);
			}
		}
		return almodel1;
		
	}
	public ArrayList<aluminiModel> searchByEmail(String alumini_email) {
		ArrayList<aluminiModel> almodel1=new ArrayList<aluminiModel>();
//		boolean flag=false;
		almodel=alr.getAluminiData();
		for(aluminiModel alm:almodel) {
			if(alm.getAlumini_email().equals(alumini_email)) {
				almodel1.add(alm);
			}
		}
		return almodel1;
	
	}
	
/*-------------------------this is for updation by id--------------------------------*/
	
	public void update() {
		aluminiModel alm = null;
		almodel = alr.getAluminiData();

		if (almodel.size() > 0) {
			System.out.println("Enter Batch First for Updation: ");
			String alumini_batch=k.next();
			System.out.println("Enter ID for Updation: ");
			int alumini_id=k.nextInt();
			
			String modify_batch = null;
			
			for (int i = 0; i < almodel.size(); i++) {
				Object ob = almodel.get(i);
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
								almodel.set(i, alm);
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
								almodel.set(i, alm);
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
		
		
		almodel=alr.getAluminiData();
		
		if (almodel.size() > 0) {
			boolean flag=false;
			System.out.println("Enter Batch First for Updation: ");
			String alumini_batch=k.next();
			System.out.println("Enter ID for Updation: ");
			int alumini_id=k.nextInt();
			
			for (int i = 0; i < almodel.size(); i++) {
				Object ob = almodel.get(i);
				aluminiModel alm = (aluminiModel) ob;
				if (alm.getAlumini_batch().equals(alumini_batch)) {
					
					if(alm.getAlumini_id()==alumini_id) {
						almodel.remove(i);
						flag = true;
					}
					
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
	
	
/*----------------------this is for sorting batch wise--------------------*/

	public void sortBatchWise() {
		
		almodel=alr.getAluminiData();
		
		if(almodel.size()>0) {
			
			SortByBatch sbb=new SortByBatch();
			
			Collections.sort(almodel, sbb);
			
			ArrayList<aluminiModel>almodel1=new ArrayList<aluminiModel>(almodel);
			
			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Alumini Id\t||Alumini Name\t||Alumini Email\t||Alumini Mobile Number\t||Alumini Address\t||Alumini Job Description");
			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
			
			for(int i=0;i<almodel1.size();i++) {
				System.out.println("[" + (almodel1.get(i).getAlumini_batch()) + "] Alumni Batch: \n"
						+ "--------------------------------------------------------------------------------------------\n");
				System.out.println(almodel1.get(i).getAlumini_id()+"\t"+almodel1.get(i).getAlumini_name()+"\t"+almodel1.get(i).getAlumini_email()+"\t"+almodel1.get(i).getAlumini_mob()+"\t"+almodel1.get(i).getAlumini_address()+"\t"+almodel1.get(i).getAlumini_jd());
				
				for(int j=(i+1);j<almodel1.size();j++) {
					if(almodel1.get(i).getAlumini_batch().equals(almodel1.get(j).getAlumini_batch())) {
						
						System.out.println(almodel1.get(j).getAlumini_id()+"\t"+almodel1.get(j).getAlumini_name()+"\t"+almodel1.get(j).getAlumini_email()+"\t"+almodel1.get(j).getAlumini_mob()+"\t"+almodel1.get(j).getAlumini_address()+"\t"+almodel1.get(j).getAlumini_jd());
						almodel1.remove(j);
					}
				}
				System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------");
				
			}

		}
		else {
			System.out.println("There are no Record found..... :(");
		}
	}
	
	
}
