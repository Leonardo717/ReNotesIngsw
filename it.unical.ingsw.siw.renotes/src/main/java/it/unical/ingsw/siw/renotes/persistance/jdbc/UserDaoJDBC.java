package it.unical.ingsw.siw.renotes.persistance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unical.ingsw.siw.renotes.model.*;
import it.unical.ingsw.siw.renotes.persistance.dao.DataSource;
import it.unical.ingsw.siw.renotes.persistance.dao.UserDao;


public class UserDaoJDBC implements UserDao{

	private DataSource dataSource;

	public UserDaoJDBC(DataSource ds) {
		dataSource = ds;
	}

	public void save(User user) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String insert = "insert into utente(username, mail, password, carrello) values(?,?,?,?)";

			PreparedStatement stm = connection.prepareStatement(insert);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setString(3, user.getPassword());
			stm.setInt(4, user.getCart().getId());
			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}


	}

	public User findByPrimaryKey(String name, String email) {
		User user = null;
		int cartId = 0;
		Connection connection=null;

		try {
			connection = dataSource.getConnection();

			PreparedStatement stm;
			String query = "select * from utente where username=? AND mail=?";
			stm = connection.prepareStatement(query);
			stm.setString(1, name);
			stm.setString(2, email);


			ResultSet result = stm.executeQuery();

			if(result.next())
			{
				user = new User();
				user.setUsername(result.getString("username"));
				user.setMail(result.getString("mail"));
				user.setPassword(result.getString("password"));
				cartId = result.getInt("carrello");

			}

		}
		catch (SQLException e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		CartDaoJDBC cartDaoJDBC = new CartDaoJDBC(dataSource);
		Cart c = cartDaoJDBC.findByPrimaryKey(cartId);

		user.setCart(c);

		return user;

	}

	public void update(User user) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String update = "update utente SET password=?, carrello=? WHERE username=? AND mail=?";

			PreparedStatement stm = connection.prepareStatement(update);

			
			stm.setString(1, user.getPassword());
			stm.setInt(2, user.getCart().getId());
			stm.setString(3, user.getUsername());
			stm.setString(4, user.getMail());
			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	}

	public void delete(User user) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String update = "DELETE FROM utente WHERE  username=? AND mail=?";

			PreparedStatement stm = connection.prepareStatement(update);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());

			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public List<Ad> findBoughtAd(User user) {
		List<Ad> ad = new ArrayList<Ad>();

		Connection connection = null;

		try {
			connection = dataSource.getConnection();

			PreparedStatement stm;
			String query = "select inserzione from relazione_utente_inserzione where e_acquistata=true AND utente_username=?";
			stm = connection.prepareStatement(query);
			stm.setString(1, user.getUsername());

			ResultSet result = stm.executeQuery();

			while(result.next())
			{
				Ad a = new Ad();
				a.setId(result.getInt("inserzione"));

				ad.add(a);
			}

		}
		catch (SQLException e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return ad;
	}

	public List<Ad> findManagedAd(User user) {
		List<Ad> ad = new ArrayList<Ad>();

		Connection connection = null;

		try {
			connection = dataSource.getConnection();

			PreparedStatement stm;
			String query = "select inserzione from relazione_utente_inserzione where e_acquistata=false AND utente_username=?";
			stm = connection.prepareStatement(query);
			stm.setString(1, user.getUsername());

			ResultSet result = stm.executeQuery();

			while(result.next())
			{
				Ad a = new Ad();
				a.setId(result.getInt("inserzione"));

				ad.add(a);
			}

		}
		catch (SQLException e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return ad;
	}

	public List<PaymentMethod> findPaymentMethods(User user) {
		List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();

		Connection connection = null;

		try {
			connection = dataSource.getConnection();

			PreparedStatement stm;
			String query = "select metodo_di_pagamento from lista_metodi_di_pagamento where utente_username=? AND utente_mail=?";
			stm = connection.prepareStatement(query);
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());

			ResultSet result = stm.executeQuery();

			while(result.next())
			{
				PaymentMethod pm = new PaymentMethod();
				pm.setCardNumber(result.getString("metodo_di_pagamento"));

				paymentMethods.add(pm);
			}

		}
		catch (SQLException e) {
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return paymentMethods;
	}

	public void insertBoughtAd(User user, Integer id) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String insert = "insert into relazione_utente_inserzione(utente_username, utente_mail, inserzione, e_acquistata) values(?,?,?,true)";

			PreparedStatement stm = connection.prepareStatement(insert);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setInt(3, id);
			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}


	}

	public void deleteBoughtAd(User user, Integer id) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String update = "DELETE FROM relazione_utente_inserzione WHERE   utente_username=? AND utente_mail=? AND inserzione=? AND e_acquistata=true";

			PreparedStatement stm = connection.prepareStatement(update);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setInt(3, id);

			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	}

	public void insertManagedAd(User user, Integer id) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String insert = "insert into relazione_utente_inserzione(utente_username, utente_mail, inserzione, e_acquistata) values(?,?,?,false)";

			PreparedStatement stm = connection.prepareStatement(insert);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setInt(3, id);
			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}


	}

	public void deleteManagedAd(User user, Integer id) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String update = "DELETE FROM relazione_utente_inserzione WHERE  utente_username=? AND utente_mail=? AND inserzione=? AND e_acquistata=false";

			PreparedStatement stm = connection.prepareStatement(update);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setInt(3, id);

			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public void insertPaymentMethods(User user, String cardNumber) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String insert = "insert into lista_metodi_di_pagamento(utente_username, utente_mail, metodo_di_pagamento) values(?,?,?)";

			PreparedStatement stm = connection.prepareStatement(insert);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setString(3, cardNumber);
			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}

		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}


	}

	public void deletePaymentMethods(User user, String cardNumber) {
		Connection connection = null;

		try {
			connection = dataSource.getConnection();
			String update = "DELETE FROM lista_metodi_di_pagamento WHERE  utente_username=? AND utente_mail=? AND metodo_di_pagamento=?";

			PreparedStatement stm = connection.prepareStatement(update);

			stm.setString(1, user.getUsername());
			stm.setString(2, user.getMail());
			stm.setString(3, cardNumber);

			stm.executeUpdate();
		}
		catch (SQLException e) {

			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {

					throw new RuntimeException(e.getMessage());
				}
			}
		}
		finally
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

	}
}
