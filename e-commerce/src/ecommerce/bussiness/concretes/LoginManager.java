package ecommerce.bussiness.concretes;

import ecommerce.bussiness.abstracts.LoginService;
import ecommerce.dataAccess.abstracts.CustomerDao;
import ecommerce.entities.concretes.Customer;

public class LoginManager implements LoginService{
	 private CustomerDao customerDao;

	    public LoginManager(CustomerDao customerDao) {
	        this.customerDao = customerDao;
	    }
	@Override
	public boolean login(String userEmail, String userPassword) {
		for (Customer customerLogged:customerDao.getAll()){
            if (userEmail==customerLogged.getEmail() && userPassword== customerLogged.getPasswaord()){
                if (customerLogged.isActivationStatus()){
                    System.out.println("Giriþ Baþarýlý...");
                    return true;
                }
                else{
                    System.out.println("Lütfen Mail aktivasyonunu gerçekleþtiriniz");
                    return true;
                }
            }
        }
        System.out.println("Kullanýcý Bulunamadý");
        return false;
    }
}


