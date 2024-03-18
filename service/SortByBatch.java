package Alumini_Management_System.service;

import java.util.Comparator;

import Alumini_Management_System.model.aluminiModel;

public class SortByBatch implements Comparator<aluminiModel> {

	@Override
	public int compare(aluminiModel alm1, aluminiModel alm2) {
		
		return alm1.getAlumini_batch().compareTo(alm2.getAlumini_batch());
	}

}
