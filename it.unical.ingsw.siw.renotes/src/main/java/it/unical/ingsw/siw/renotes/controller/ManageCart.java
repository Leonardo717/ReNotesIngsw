package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Cart;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class ManageCart extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart) req.getSession().getAttribute("cartSession");
		
		Integer id = Integer.valueOf(req.getParameter("adIdAdd"));
		
		Ad newAd = new Ad();
		newAd = DBManager.getInstance().getAdDao().findByPrimaryKey(id);
		
		boolean alreadyInsert = false;
		List<Ad> ads = cart.getAds();
		
		if(ads.size()>0)
			for(int i=0; i<ads.size() && !alreadyInsert; i++)
			{
				if(ads.get(i).getId() == id)
					alreadyInsert = true;
			}
		
		if(alreadyInsert)
		{
			
			RequestDispatcher rd = req.getRequestDispatcher("/errorAddAd.html");
			rd.forward(req, resp);
		}
		else
		{
			DBManager.getInstance().getCartDao().insertAd(cart.getId(), id);
			
			cart.getAds().add(newAd);
			
			cart.setTotal(cart.getTotal());
			DBManager.getInstance().getCartDao().update(cart);
			
			RequestDispatcher rd = req.getRequestDispatcher("ViewAdList");
			rd.forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cart cart = (Cart) req.getSession().getAttribute("cartSession");
		
		String idString = req.getParameter("adIdRemove");
		
		Integer id = 0; 
		if(idString != null)
		{
			id = Integer.valueOf(req.getParameter("adIdRemove"));
			
			Ad newAd = new Ad();
			newAd.setId(id);
			
			DBManager.getInstance().getCartDao().deleteAd(cart.getId(), newAd.getId());
			cart.getAds().remove(newAd);
			
		}
		else
		{
			Integer loop = Integer.valueOf(req.getParameter("clearCart"));
			
			List<Ad> adsDaRimuovere = cart.getAds();
		
			int cont=0;
			
			while(cont<loop)
			{
				Ad newAd = new Ad();
				newAd.setId(adsDaRimuovere.get(cont).getId());

				DBManager.getInstance().getCartDao().deleteAd(cart.getId(), newAd.getId());
			
				cont++;	
			}
			
			cart.getAds().clear();
		}
		
		cart.setTotal(cart.getTotal());
		DBManager.getInstance().getCartDao().update(cart);
		
		RequestDispatcher rd = req.getRequestDispatcher("ViewCart");
		rd.forward(req, resp);
		
	}

}
