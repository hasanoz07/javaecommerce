package ecommerce.bussiness.abstracts;

import ecommerce.entities.concretes.Customer;

public interface CustomerCheckService {
	boolean checkIfValidEmail(Customer customer);
	boolean checkIfValidName(Customer customer);
	
	boolean checkIfValidPassword(Customer customer);
	
}
