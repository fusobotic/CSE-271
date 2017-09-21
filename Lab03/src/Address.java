/*
 * Address.java
 * 
 * Address class with getters and smart setters
 * Also two constructors with and without apartment number
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-10-17
 */

public class Address {
	
	private int houseNum,
				zipCode,
				apartNum = -1; //setting default
	
	private String street,
				   city,
				   state;
	
	//constructor without apartment number
	public Address(int houseNum, String street, String city, String state,
				   int zipCode){
		setHouseNum(houseNum);
		setStreet(street);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
	}//end Address (without apartNum)
	
	//constructor with apartment number
	public Address(int houseNum, String street, int apartNum, String city,
				   String state, int zipCode){
		setHouseNum(houseNum);
		setStreet(street);
		setApartNum(apartNum);
		setCity(city);
		setState(state);
		setZipCode(zipCode);
	}//end Address (with apartNum)
	
	
	public boolean comesBefore(Address other){
		//if other Address has a lesser zipCode return false
		if(other.getZipCode() < this.getZipCode()){
			return false;
		}
		return true;
	}//end comesBefore

	public int getHouseNum() {
		return houseNum;
	}//end getHouseNum

	public void setHouseNum(int houseNum) {
		if (houseNum > 0){
			this.houseNum = houseNum;
		} else {
			System.out.println("Please enter a house number above zero.");
		}
	}//end setHouseNum

	public int getApartNum() {
		return apartNum;
	}//end getApartNum

	public void setApartNum(int apartNum) {
		if (apartNum > 0){
			this.apartNum = apartNum;
		} else {
			System.out.println("Please enter an apartment number above zero.");
		}
	}//end setApartNum

	public int getZipCode() {
		return zipCode;
	}//end getZipCode

	public void setZipCode(int zipCode) {
		//doesn't handle zipcodes like: 00012
		if(zipCode <= 0){
			System.out.println("Zip code must be more than zero.");
			return;
		} else if (Integer.toString(zipCode).length() > 5){
			System.out.println("Zip code must be less than 6 digits.");
			return;
		}
		this.zipCode = zipCode;
	}//end setZipCode

	public String getStreet() {
		return street;
	}//end getStreet

	public void setStreet(String street) {
		if(street.length() > 0){
			this.street = street;
		} else {
			System.out.println("[null] is a not a street, try again.");
		}
	}//end setStreet

	public String getCity() {
		return city;
	}//end getCity

	public void setCity(String city) {
		if(city.length() != 0){
			this.city = city;
		} else {
			System.out.println("[null] is a not a city, try again.");
		}
	}//end setCity

	public String getState() {
		return state;
	}//end getState

	public void setState(String state) {
		if(state.length() != 0){
			this.state = state;
		} else {
			System.out.println("[null] is a not a state, try again.");
		}
	}//end setState
	
	public void printAddress(){
		System.out.println(getHouseNum() + " " + getStreet());
		
		//if there is an apartNum print it on another line
		if(getApartNum() > 0) 
			System.out.println(getApartNum());
		
		System.out.println(getCity() + ", " + getState());
		System.out.println(getZipCode());
	}//end printAddress

}//end Address
