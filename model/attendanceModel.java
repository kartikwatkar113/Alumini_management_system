package Alumini_Management_System.model;

public class attendanceModel {

	private String eve_name1,alumini_name1;
	
	public attendanceModel() {
		
	}

	public attendanceModel(String eve_name1, String alumini_name1) {
		super();
		this.eve_name1 = eve_name1;
		this.alumini_name1 = alumini_name1;
	}

	public String getEve_name1() {
		return eve_name1;
	}

	public void setEve_name1(String eve_name1) {
		this.eve_name1 = eve_name1;
	}

	public String getAlumini_name1() {
		return alumini_name1;
	}

	public void setAlumini_name1(String alumini_name1) {
		this.alumini_name1 = alumini_name1;
	}

	
	
}
