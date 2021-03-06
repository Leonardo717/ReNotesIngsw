package it.unical.ingsw.siw.renotes.persistance.dao;

import java.util.List;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Review;
import it.unical.ingsw.siw.renotes.model.User;


public interface AdDao {
	
	public void save(Ad ad); //Insert -Create
	public Ad findByPrimaryKey(Integer id);
	public void update(Ad ad);
	public void delete(Ad ad);
	
	public List<Review> findReview(Integer adId);
	public User findUserCreator(Integer adId);
	
	public List<Ad> findAll();

}
