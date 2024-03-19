package Alumini_Management_System.model;

public class aluminiModel {

	private String alumini_batch;
	private int alumini_id;
	private String alumini_name;
	private String alumini_email;
	private String alumini_mob;
	private String alumini_address;
	private String alumini_jd;
	private boolean status;

	
	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public aluminiModel() {
		
	}


	public aluminiModel(String alumini_batch, int alumini_id, String alumini_name, String alumini_email,
			String alumini_mob, String alumini_address, String alumini_jd) {
		super();
		
		this.alumini_batch = alumini_batch;
		this.alumini_id=alumini_id;
		this.alumini_name = alumini_name;
		this.alumini_email = alumini_email;
		this.alumini_mob = alumini_mob;
		this.alumini_address = alumini_address;
		this.alumini_jd = alumini_jd;
	}


	public String getAlumini_batch() {
		return alumini_batch;
	}


	public void setAlumini_batch(String alumini_batch) {
		this.alumini_batch = alumini_batch;
	}


	public int getAlumini_id() {
		return alumini_id;
	}


	public void setAlumini_id(int alumini_id) {
		this.alumini_id = alumini_id;
	}


	public String getAlumini_name() {
		return alumini_name;
	}


	public void setAlumini_name(String alumini_name) {
		this.alumini_name = alumini_name;
	}


	public String getAlumini_email() {
		return alumini_email;
	}


	public void setAlumini_email(String alumini_email) {
		this.alumini_email = alumini_email;
	}


	public String getAlumini_mob() {
		return alumini_mob;
	}


	public void setAlumini_mob(String alumini_mob) {
		this.alumini_mob = alumini_mob;
	}


	public String getAlumini_address() {
		return alumini_address;
	}


	public void setAlumini_address(String alumini_address) {
		this.alumini_address = alumini_address;
	}


	public String getAlumini_jd() {
		return alumini_jd;
	}


	public void setAlumini_jd(String alumini_jd) {
		this.alumini_jd = alumini_jd;
	}


	
	

}
