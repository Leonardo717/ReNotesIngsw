package it.unical.ingsw.siw.renotes.persistance.dao;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Cart;
import it.unical.ingsw.siw.renotes.model.PaymentMethod;
import it.unical.ingsw.siw.renotes.model.Preview;
import it.unical.ingsw.siw.renotes.model.Review;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.jdbc.AdDaoJDBC;
import it.unical.ingsw.siw.renotes.persistance.jdbc.CartDaoJDBC;
import it.unical.ingsw.siw.renotes.persistance.jdbc.PaymentDaoJDBC;
import it.unical.ingsw.siw.renotes.persistance.jdbc.PreviewDaoJDBC;
import it.unical.ingsw.siw.renotes.persistance.jdbc.ReviewDaoJDBC;
import sun.security.pkcs11.Secmod.DbMode;

public class DBManager {
	
	public static void main(String[] args) {
		
		//DBManager.getInstance().findCarrelloProva();
		Ad ad = new Ad();
		ad.setId(1); //AGGIUNGI SE DEVI USARE L'ID
		ad.setTitle("titolo2");
		ad.setDegreeCourse("degree2");
		ad.setSubject("subj2");
		ad.setUniversity("uny2");
		ad.setDescription("descr2");
		ad.setPrice(20.0);
		ad.setFile("sonoUnLinkaFile");
		
		Preview prv = new Preview();
		prv.setId(1);
		prv.setImage("sonoUnLinkAdAnteprima");
		ad.setPreview(prv);
		
		User user = new User();
		user.setUsername("GiovanniRana");
		user.setMail("gioran717@tortellino.it");
		
		Review review = new Review();
		review.setId(2);
		review.setQuality(1);
		review.setReliability(1);
		review.setCompleteness(5);
		review.setComment("commento2");
		review.setUser(user);
		review.setAd(ad);
		
		PaymentMethod method=new PaymentMethod();
		method.setCardNumber("0010");
		method.setOwner("proprietarioAle");
		method.setBalance(10.50);
		method.setExpiryDate(new Date());
		method.setCvc(332);
		method.setDefault(false);
		
		DBManager.getInstance().getPaymentMethodDao().update(method);
		
		
		//DBManager.getInstance().resetSerialPreview();
		//DBManager.getInstance().resetSerialAd();
		
		//DBManager.getInstance().insertPreview(prv);
		//DBManager.getInstance().insertAd(ad);
		
		//Ad adResult = DBManager.getInstance().getAdDao().findByPrimaryKey(1);
		//System.out.println(adResult.getId() + " " + adResult.getTitle() + " " + adResult.getSubject() + " " + adResult.getDegreeCourse() + " " + adResult.getFile() + " " + adResult.getPrice() + " " + adResult.getUniversity() + " " + adResult.getPreview().getId() + " " + adResult.getPreview().getImage());
		
		//DBManager.getInstance().getAdDao().update(ad);
		//Ad adResult = DBManager.getInstance().getAdDao().findByPrimaryKey(1);
		//System.out.println(adResult.getId() + " " + adResult.getTitle() + " " + adResult.getPreview().getImage());
		
		//DBManager.getInstance().getPreviewDao().update(prv);
		
		//DBManager.getInstance().getReviewDao().save(review);
		
		/*List<Review> reviews= DBManager.getInstance().getAdDao().findReview(1);
		for(Review r : reviews)
		{
			System.out.println("ID Val: " + r.getId());
			System.out.println("Q: " + r.getQuality());
			System.out.println("A: " + r.getReliability());
			System.out.println("C: " + r.getCompleteness());
			System.out.println(r.getComment());
			System.out.println("ID Ins: " + r.getAd().getId());
			System.out.println("UserName: " + r.getUser().getUsername());
			System.out.println("UserMail: " + r.getUser().getMail() + "\n");
		}*/
		
		/*Review r = DBManager.getInstance().getReviewDao().findByPrimaryKey(2);
		System.out.println("ID Val: " + r.getId());
		System.out.println("Q: " + r.getQuality());
		System.out.println("A: " + r.getReliability());
		System.out.println("C: " + r.getCompleteness());
		System.out.println(r.getComment());
		System.out.println("ID Ins: " + r.getAd().getId());
		System.out.println("UserName: " + r.getUser().getUsername());
		System.out.println("UserMail: " + r.getUser().getMail() + "\n");*/
		
		//DBManager.getInstance().getReviewDao().update(review);
		
		/*Cart cart = new Cart();
		cart.setTotal(30);
		cart.setDate(new Date());
		
		DBManager.getInstance().getCartDao().save(cart);*/
		
		/*Cart cartResult = DBManager.getInstance().getCartDao().findByPrimaryKey(5);
		
		//System.out.println(cartResult.getId() + " " + cartResult.getTotal() + " " + cartResult.getDate());
		
		cartResult.setTotal(50);*/
		
		//DBManager.getInstance().getCartDao().update(cartResult);
		
		/*Cart cart = new Cart();
		cart.setId(5);
		DBManager.getInstance().getCartDao().delete(cart);*/
		
		//DBManager.getInstance().getCartDao().insertAd(1, 1);
		//DBManager.getInstance().getCartDao().deleteAd(1, 1);
		
	}
	
	private static  DataSource dataSource;

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			//dataSource=new DataSource("jdbc:postgresql://manny.db.elephantsql.com:5432/nzxxsfok","nzxxsfok","5JTu5JBBv9l17WPT1rFhHHpp2OAZ4iuY");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/ReNotesLocal","postgres","Qwerty123");

		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager instance = null;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager()	
	{}
	
	public AdDao getAdDao()
	{
		return new AdDaoJDBC(dataSource);
	}
	
	public void insertAd(Ad ad)
	{
		this.getAdDao().save(ad);
	}
	
	public PreviewDao getPreviewDao()
	{
		return new PreviewDaoJDBC(dataSource);
	}
	
	public void insertPreview(Preview preview)
	{
		this.getPreviewDao().save(preview);
	}
	
	public ReviewDaoJDBC getReviewDao()
	{
		return new ReviewDaoJDBC(dataSource);
	}
	
	public CartDao getCartDao()
	{
		return new CartDaoJDBC(dataSource);
	}
	
	
	public PaymentMethodDao getPaymentMethodDao()
	{
		return new PaymentDaoJDBC(dataSource);
	}
	
	public void findCarrelloProva() {
		Connection connection = null;
		
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from carrello";
			statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while(result.next()) {
				
				Integer carrelloId = (Integer) result.getObject(1);
				Double totale = (Double) result.getObject(2);
				Date data = (Date) result.getObject(3);
				
				System.out.println("CarrelloId: " + String.valueOf(carrelloId) + " Totale: " + String.valueOf(totale) + " Data: " + String.valueOf(data));
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
	//PARTE DA 2 COSÌ LASCIO SEMPRE UN CARRELLO CUI REFERENZIA L'USER
	public void resetSerialPreview() {
		Connection connection = null;
		
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select setval('\"anteprima_anteprimaId_seq\"',2,false)";
			statement = connection.prepareStatement(query);

			statement.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
	}
	
	public void resetSerialAd() {
		Connection connection = null;
		
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select setval('\"Inserzione_inserioneId_seq\"',1,false)";
			statement = connection.prepareStatement(query);

			statement.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
	}
	
	public void resetSerialCart() {
		Connection connection = null;
		
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select setval('\"carrello_carrelloId_seq\"',1,false)";
			statement = connection.prepareStatement(query);

			statement.executeQuery();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
	}
}
