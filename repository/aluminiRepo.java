package Alumini_Management_System.repository;

import java.util.Vector;
import Alumini_Management_System.model.aluminiModel;

public class aluminiRepo {

	static Vector<aluminiModel>vc=new Vector<aluminiModel>();
	
	
	public boolean isAluminiAdd(aluminiModel alm) {
		
		boolean b=vc.add(alm);
		return b;
		
	}
	
	public Vector getAluminiData() {
		
		return vc;
		
	}
	
	
	
	
}
