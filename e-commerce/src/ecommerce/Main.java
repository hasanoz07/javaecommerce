package ecommerce;

import ecommerce.bussiness.abstracts.CustomerService;
import ecommerce.bussiness.abstracts.LoginWithService;
import ecommerce.bussiness.concretes.CustomerCheckManager;
import ecommerce.bussiness.concretes.CustomerManager;
import ecommerce.bussiness.concretes.LoginManager;
import ecommerce.dataAccess.concretes.HibernateCustomerDao;
import ecommerce.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Hasan");
		customer.setEmail("hasanoz2002@gmail.com");
		customer.setLastName("ÖZ");
		customer.setPasswaord("123456");
		
		CustomerService customerService= new CustomerManager(new HibernateCustomerDao(),new CustomerCheckManager(),
				new LoginManager(new HibernateCustomerDao()),new LoginWithService() {
					
					@Override
					public boolean loginWithGoogle(String userName, String password) {
						// TODO Auto-generated method stub
						return false;
					}
				});
		customerService.add(customer);
		System.out.println("------------------------------------");
		customerService.login("ayseyesil@mobimenti.com", "12345678");
		System.out.println("------------------------------------");
		customerService.login("hasanozz2002@gmail.com", "12345678");
		System.out.println("------------------------------------");
		customerService.login("dmsadm@gmail.com", "147852369");
		System.out.println("------------------------------------");
		customerService.googleWithLogin("deneme@gmail.com", "deneme");
		
		
		
		

	}
	

}
