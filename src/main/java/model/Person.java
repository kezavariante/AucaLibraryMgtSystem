package model;

public class Person {

	private String person_id;
	private String first_name;
	private String last_name;
	private PersonGender gender;
	private String phone_number;

	
	public Person() {}


	public Person(String person_id, String first_name, String last_name, PersonGender gender, String phone_number) {
		
		this.person_id = person_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.phone_number = phone_number;
	}


	public String getPerson_id() {
		return person_id;
	}


	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public PersonGender getGender() {
		return gender;
	}


	public void setGender(PersonGender gender) {
		this.gender = gender;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
	
}
