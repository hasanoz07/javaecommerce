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
                    System.out.println("Giri� Ba�ar�l�...");
                    return true;
                }
                else{
                    System.out.println("L�tfen Mail aktivasyonunu ger�ekle�tiriniz");
                    return true;
                }
            }
        }
        System.out.println("Kullan�c� Bulunamad�");
        return false;
    }
}


