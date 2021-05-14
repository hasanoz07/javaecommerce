package ecommerce.bussiness.abstracts;

import ecommerce.entities.concretes.Customer;

public interface CustomerService {
	void add(Customer customer);
	void login(String userEmail, String userPassword);
	void googleWithLogin(String userEmail, String userPassword);
}
