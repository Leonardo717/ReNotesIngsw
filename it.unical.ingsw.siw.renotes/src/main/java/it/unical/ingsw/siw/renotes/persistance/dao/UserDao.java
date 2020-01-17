package it.unical.ingsw.siw.renotes.persistance.dao;

import java.util.List;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.PaymentMethod;
import it.unical.ingsw.siw.renotes.model.User;


public interface UserDao {
	
	public void save(User user); //Insert -Create
	public User findByPrimaryKey(String username, String mail);
	public void update(User user);
	public void delete(User user);
	
	public List<Ad> findBoughtAd();
	public List<Ad> findManagedAd();
	public List<PaymentMethod> findPaymentMethods();
	
	public void insertBoughtAd(User user, Integer id);
	public void deleteBoughtAd(User user, Integer id);
	
	public void insertManagedAd(User user, Integer id);
	public void deleteManagedAd(User user, Integer id);
	
	public void insertPaymentMethods(User user, String cardNumber);
	public void deletePaymentMethods(User user, String cardNumber);

	
}
