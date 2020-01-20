package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Review;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class GetAdInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String idS = req.getParameter("adId");
		//System.out.println(idS);
		//Integer id = Integer.valueOf(idS);
		
		int id = 1;
		Ad ad = DBManager.getInstance().getAdDao().findByPrimaryKey(id);
		User user = DBManager.getInstance().getAdDao().findUserCreator(id);
		List<Review> reviews = DBManager.getInstance().getAdDao().findReview(id);
		
		int statistics[] = ad.getStat(reviews); 
		
		req.setAttribute("ad", ad);
		req.setAttribute("user", user);
		req.setAttribute("stat", statistics);
		req.setAttribute("reviews", reviews);
		
		RequestDispatcher rd = req.getRequestDispatcher("/adInfo.jsp");
		rd.forward(req, resp);
		
	}
	
/*	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}*/
}
