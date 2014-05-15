package com.exercise.swapname;

class PersonModel implements Comparable<PersonModel>{

	public final static String FNAME_TAG = "fname";
	public final static String SNAME_TAG = "sname";
	
	private String fName;
	private String sName;
	
	PersonModel(String fName, String sName) {
		this.fName = fName;
		this.sName = sName;
	}
	
	PersonModel(String str) throws IllegalArgumentException{
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

	@Override
	public int compareTo(PersonModel another) {
		return this.fName.compareTo(another.fName);
	}
}
