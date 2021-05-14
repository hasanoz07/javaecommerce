package ecommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ecommerce.dataAccess.abstracts.CustomerDao;
import ecommerce.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao{

	public List<Customer> customers = new ArrayList<Customer>(); //Bir liste oluþturuyoruz ve kullanýcýlarýmýzýn bilgilerini bu listeye ekliyoruz.
	@Override
	public void add(Customer customer) {
		System.out.println(customer.getFirstName() + " Sisteme eklendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println(customer.getFirstName() + " Sistemden silindi.");
		
	}

	@Override
	public void update(Customer customer) {
		System.out.println(customer.getFirstName() + " Sistem üzerinden güncellendi.");
		
	}

	@Override
	public Customer getById(int id) {
		
		for (Customer customer : customers) {
			if (customer.getId() == id)
				return customer;
		}
		return null;
	}

	@Override
	public List<Customer> getAll() {
		
        List<Customer> customers= new ArrayList<Customer>();
        Customer customer1 = new Customer(1,"Hasan","ÖZ","hasanozz2002@gmail.com","12345678");
        Customer customer2 = new Customer(2,"Ayþe","YEÞÝL","ayseyesil@mobimenti.com","12345678");
        Customer customer3 = new Customer(3,"Büþra","DEMÝR","busrademir@yandex.com","12345678");
        Customer customer4 = new Customer(4,"Mahmut","ÇELÝK","mahmutcelik@hotmail.com","12345678");
        Customer customer5 = new Customer(5,"Derya","KAYA","deryalaya@yahoo.com","12345678");

        customers.add(customer1);
        customer1.setActivationStatus(true);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);


        return customers;
	}

}
