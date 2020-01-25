package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unical.ingsw.siw.renotes.model.Cart;
import it.unical.ingsw.siw.renotes.model.PaymentMethod;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class FLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * QUANDO SI APRE IL SITO SENZA LOGIN VIENE CREATO UN CARRELLO E LO SI INSERISCE NEL DB.
		 * LO SI ASSOCIA ALLA SESSIONE.
		 * SE NON VERRÀ MAI FATTO IL LOGIN ALLORA IL CARRELLO VA ELIMINATO DAL DB E CHIUSA LA SESSIONE
		 * QUANDO AVVERRÀ IL LOGIN IL CARRELLO SI ASSOCIA ALL'UTENTE-DB COME CHIAVE ESTERNA.
		 */
		
		//DBManager.getInstance().resetSerialReview();
		User user = new User();
		user.setUsername("GiovanniRana");
		user.setMail("gioran717@tortellino.it");
	
		List<PaymentMethod> paymentMethods = DBManager.getInstance().getUserDao().findPaymentMethods(user); //HA SOLO I NUMERI DI CARTA
		
		user.setPaymentMethods(paymentMethods);
		
		//SETTO CARRELLO
		Cart cart = DBManager.getInstance().getCartDao().findByPrimaryKey(1);

		cart.setAds(DBManager.getInstance().getCartDao().listOfAds(cart));
		
		
		cart.setTotal(cart.getTotal());

		DBManager.getInstance().getCartDao().update(cart);
		
		//FINE DI SET
		
		HttpSession session = req.getSession(true);
		session.setAttribute("userSession", user);
		session.setAttribute("cartSession", cart);
		
		System.out.println("SONO IN HOME");
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.html");
		rd.forward(req, resp);
	}

}
