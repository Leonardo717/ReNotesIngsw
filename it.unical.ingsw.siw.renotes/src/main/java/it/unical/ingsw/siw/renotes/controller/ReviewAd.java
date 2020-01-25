package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.model.Review;
import it.unical.ingsw.siw.renotes.model.User;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class ReviewAd extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer quality = Integer.valueOf(req.getParameter("qualityValue"));
		Integer reliability = Integer.valueOf(req.getParameter("reliabilityValue"));
		Integer completeness = Integer.valueOf(req.getParameter("completenessValue"));
		String comment = req.getParameter("comment");
		
		HttpSession session = req.getSession();
		//Ad ad = (Ad) session.getAttribute("adSession");
		Ad ad = new Ad();
		ad.setId(1);
		
		//DOVREBBE VENIR FUORI DALLA SESSION
		User user = (User) session.getAttribute("userSession");
		
		Review review = new Review();
		review.setQuality(quality);
		review.setReliability(reliability);
		review.setCompleteness(completeness);
		review.setComment(comment);
		review.setAd(ad);
		review.setUser(user);
		
		//System.out.println(review.getComment());
		DBManager.getInstance().getReviewDao().save(review);
		
		RequestDispatcher rd = req.getRequestDispatcher("/reviewAddedSuccessfully.html");
		rd.forward(req, resp);
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		Ad ad = (Ad) session.getAttribute("adSession");
		
		Integer id = ad.getId(); //VERRÀ POI PRESO DALLA PAGINA CHE MI PORTA QUI
		
		String adTitle = DBManager.getInstance().getAdDao().findByPrimaryKey(id).getTitle();
		
		req.setAttribute("adTitle", adTitle);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/reviewAdd.jsp");
		rd.forward(req, resp);
		
	}

}
