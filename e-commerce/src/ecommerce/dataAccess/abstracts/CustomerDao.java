package ecommerce.dataAccess.abstracts;

import java.util.List;

import ecommerce.entities.concretes.Customer;

public interface CustomerDao {
	void add(Customer customer);
	void delete(Customer customer);
	void update(Customer customer);
	Customer getById(int id);
	List<Customer> getAll();
	
}
