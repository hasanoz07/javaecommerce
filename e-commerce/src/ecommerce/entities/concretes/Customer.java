package ecommerce.entities.concretes;

import ecommerce.entities.abstracts.Entity;

public class Customer implements Entity{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String passwaord;
	private boolean activationStatus = false;
	public Customer() {
		
	}

	public Customer(int id, String firstName, String lastName, String email, String passwaord) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwaord = passwaord;
	}

	//Getter
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String getPasswaord() {
		return passwaord;
	}
	
	//Setter
	
	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPasswaord(String passwaord) {
		this.passwaord = passwaord;
	};
	
	
}
