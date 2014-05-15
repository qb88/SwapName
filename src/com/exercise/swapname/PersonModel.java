package com.exercise.swapname;

public class PersonModel {

	public final static String FNAME_TAG = "fname";
	public final static String SNAME_TAG = "sname";
	
	private String fName;
	private String sName;
	
	public PersonModel(String fName, String sName) {
		this.fName = fName;
		this.sName = sName;
	}
	
	public PersonModel(String str) throws IllegalArgumentException{
		String[] arr = str.split(" ");
		if(arr.length >= 2) {
			setFName(arr[0]);
			setSName(arr[1]);
		} else if (arr.length == 1) {
			setFName(arr[0]);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String getFName() {
		return fName;
	}
	public void setFName(String fName) {
		this.fName = fName;
	}
	public String getSName() {
		return sName;
	}
	public void setSName(String sName) {
		this.sName = sName;
	}
	
	@Override
	public String toString() {
		return fName + " " + sName;
	}
}
