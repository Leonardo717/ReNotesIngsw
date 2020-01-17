package it.unical.ingsw.siw.renotes.persistance.jdbc;

import java.util.List;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.PaymentMethod;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.dao.UserDao;


public class UserDaoJDBC implements UserDao {

	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	public User findByPrimaryKey(String username, String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<Ad> findBoughtAd() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ad> findManagedAd() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PaymentMethod> findPaymentMethods() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertBoughtAd(User user, Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBoughtAd(User user, Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void insertManagedAd(User user, Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteManagedAd(User user, Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void insertPaymentMethods(User user, String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	public void deletePaymentMethods(User user, String cardNumber) {
		// TODO Auto-generated method stub
		
	}
}
