package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unical.ingsw.siw.renotes.model.Cart;
import it.unical.ingsw.siw.renotes.model.PaymentMethod;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class Checkout extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("userSession");
		
		System.out.println(user);
		if(user == null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("/notLogin.html");
			rd.forward(req, resp);
		}
		else
		{
			Cart cart = (Cart) req.getSession().getAttribute("cartSession");
			
			req.setAttribute("cart", cart);
			List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
			
			for(PaymentMethod pmTemp: user.getPaymentMethods())
			{
				PaymentMethod pm = new PaymentMethod();
				pm = DBManager.getInstance().getPaymentMethodDao().findByPrimaryKey(pmTemp.getCardNumber());
				
				paymentMethods.add(pm);
			}
			
			user.setPaymentMethods(paymentMethods);
			
			req.setAttribute("payments", user.getPaymentMethods());
			
			RequestDispatcher rd = req.getRequestDispatcher("/checkout.jsp");
			rd.forward(req, resp);
		}
	}

}
