package ecommerce.bussiness.concretes;

import ecommerce.bussiness.abstracts.CustomerCheckService;
import ecommerce.bussiness.abstracts.CustomerService;
import ecommerce.bussiness.abstracts.LoginService;
import ecommerce.bussiness.abstracts.LoginWithService;
import ecommerce.dataAccess.abstracts.CustomerDao;
import ecommerce.entities.concretes.Customer;


public class CustomerManager implements CustomerService{
	
	private CustomerDao customerDao;
	private CustomerCheckService customerCheckService;
	private LoginService loginService;
	private LoginWithService loginWithService;
	
	
	 public CustomerManager(CustomerDao customerDao,CustomerCheckService customerCheckService,
			 LoginService loginService,LoginWithService loginWithService) {
		super();
		this.customerDao=customerDao;
		this.customerCheckService=customerCheckService;
		this.loginService=loginService;
		this.loginWithService=loginWithService;
	}
	 
	@Override
	public void add(Customer customer) {
		boolean registrationStatus = true;
		 if (customerDao.getAll()!=null) { // eMail mevcut mu de�il mi kontrol edilen yer
	            for (Customer customerExists : customerDao.getAll()) {
	                if(customer.getEmail()==customerExists.getEmail()) {
	                    System.out.println("Bu mail adresi kay�tl�!");
	                    return;
	                }
	            }
	        }
	        if (!customerCheckService.checkIfValidEmail(customer)){ //eMail d�zg�n formatta m�, kontrol edilen yer
	            System.out.println("Ge�ersiz e-posta adresi. L�tfen ge�erli bir e-posta adresi giriniz.");
	            registrationStatus =false;
	        }
	        if (!customerCheckService.checkIfValidName(customer)){//Ad Soyad d�zg�n formatta m�, kontrol edilen yer
	            System.out.println("Ge�ersiz Ad veya Soyad. L�tfen en az iki karakterli ad ve soyad giriniz..");
	            registrationStatus =false;
	        }
	        if (!customerCheckService.checkIfValidPassword(customer)){//�ifre d�zg�n formatta m�, kontrol edilen yer
	            System.out.println("Ge�ersiz �ifre. L�tfen en az 6 karakterli bir �ifre giriniz.");
	            registrationStatus =false;
	        }
	        if (registrationStatus==false){
	            System.out.println("Kay�t Ba�ar�s�z!");
	        }else{
	        	customerDao.add(customer);
	            System.out.println("Aktivasyon Maili g�nderilmi�tir.");
	        }
	}

	@Override
	public void login(String userEmail, String userPassword) {
		loginService.login(userEmail, userPassword);
		
	}

	@Override
	public void googleWithLogin(String userEmail, String userPassword) {
		loginWithService.loginWithGoogle(userEmail, userPassword);
		System.out.println("Google ile giri� ba�ar�l�.");
		
	}
	
	

}
