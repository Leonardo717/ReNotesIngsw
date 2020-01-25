package it.unical.ingsw.siw.renotes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unical.ingsw.siw.renotes.model.Ad;
import it.unical.ingsw.siw.renotes.persistance.dao.DBManager;

public class ViewAdList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//UTILE PER VEDERE TUTTE LE INSERZIONI DENTRO IL DB. EMULA FALSAMENTE IL RISULTATO DI UNA RICERCA
		List<Ad> ads = DBManager.getInstance().getAdDao().findAll();
		
		//System.out.println("SONO NELLA SERVLET ViewAdList. CI SONO " + ads.size() + " INSERZIONI");
		
		if(ads.size()>0)
			req.setAttribute("ads", ads);
		
		RequestDispatcher rd = req.getRequestDispatcher("/adList.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
