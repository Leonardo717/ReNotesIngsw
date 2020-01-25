package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Cart;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class ViewCart extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart) req.getSession().getAttribute("cartSession");
		
		List<Ad> adsTemp = cart.getAds();
		List<Ad> ads = new ArrayList<Ad>();
		
		if(adsTemp.size()>0)
			for(Ad ad: adsTemp)
			{
				Ad adTemp = DBManager.getInstance().getAdDao().findByPrimaryKey(ad.getId());
				ads.add(adTemp);
			}
		
		if(ads.size()>0)
		{	
			req.setAttribute("ads", ads);
		}
		
		req.setAttribute("cart", cart);
	
		RequestDispatcher rd = req.getRequestDispatcher("/cart.jsp");
		rd.forward(req, resp);
	}
}
