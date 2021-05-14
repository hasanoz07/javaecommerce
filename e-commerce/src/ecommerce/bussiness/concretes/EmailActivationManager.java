package ecommerce.bussiness.concretes;

import ecommerce.bussiness.abstracts.ActivationService;
import ecommerce.entities.concretes.Customer;

public class EmailActivationManager implements ActivationService{

	@Override
	public void activater(Customer customer) {
		//Deneme sim�lasyon, Aktivasyon ger�ekle�tirildi.
        customer.setActivationStatus(true);
		
	}

}
