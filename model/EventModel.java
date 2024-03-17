package Alumini_Management_System.model;

import java.sql.Date;
import java.util.Vector;

public class EventModel {

	private String ev_name;
	private String ev_date;
	private String ev_time;
	private Vector setAlumini;
	private Boolean Status;

	public EventModel() {

	}

	public EventModel(String ev_name, String ev_date, String ev_time,Vector setAlumini) {
		super();
		this.ev_name = ev_name;
		this.ev_date = ev_date;
		this.ev_time = ev_time;
		this.setAlumini=setAlumini;
	}

	public String getEv_name() {
		return ev_name;
	}

	public void setEv_name(String ev_name) {
		this.ev_name = ev_name;
	}

	public String getEv_date() {
		return ev_date;
	}

	public void setEv_date(String ev_date) {
		this.ev_date = ev_date;
	}

	public String getEv_time() {
		return ev_time;
	}

	public void setEv_time(String ev_time) {
		this.ev_time = ev_time;
	}

	public Vector getSetAlumini() {
		return setAlumini;
	}

	public void setSetAlumini(Vector setAlumini) {
		this.setAlumini = setAlumini;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

}
