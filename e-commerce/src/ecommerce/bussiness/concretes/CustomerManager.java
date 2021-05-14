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
		 if (customerDao.getAll()!=null) { // eMail mevcut mu deðil mi kontrol edilen yer
	            for (Customer customerExists : customerDao.getAll()) {
	                if(customer.getEmail()==customerExists.getEmail()) {
	                    System.out.println("Bu mail adresi kayýtlý!");
	                    return;
	                }
	            }
	        }
	        if (!customerCheckService.checkIfValidEmail(customer)){ //eMail düzgün formatta mý, kontrol edilen yer
	            System.out.println("Geçersiz e-posta adresi. Lütfen geçerli bir e-posta adresi giriniz.");
	            registrationStatus =false;
	        }
	        if (!customerCheckService.checkIfValidName(customer)){//Ad Soyad düzgün formatta mý, kontrol edilen yer
	            System.out.println("Geçersiz Ad veya Soyad. Lütfen en az iki karakterli ad ve soyad giriniz..");
	            registrationStatus =false;
	        }
	        if (!customerCheckService.checkIfValidPassword(customer)){//Þifre düzgün formatta mý, kontrol edilen yer
	            System.out.println("Geçersiz Þifre. Lütfen en az 6 karakterli bir þifre giriniz.");
	            registrationStatus =false;
	        }
	        if (registrationStatus==false){
	            System.out.println("Kayýt Baþarýsýz!");
	        }else{
	        	customerDao.add(customer);
	            System.out.println("Aktivasyon Maili gönderilmiþtir.");
	        }
	}

	@Override
	public void login(String userEmail, String userPassword) {
		loginService.login(userEmail, userPassword);
		
	}

	@Override
	public void googleWithLogin(String userEmail, String userPassword) {
		loginWithService.loginWithGoogle(userEmail, userPassword);
		System.out.println("Google ile giriþ baþarýlý.");
		
	}
	
	

}
