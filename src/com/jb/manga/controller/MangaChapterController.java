package com.jb.manga.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class MangaChapterController
 */
@WebServlet("/MangaChapterController")
public class MangaChapterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 String mangaId = request.getParameter("mangaId");
			 
			HttpResponse<String> mangaChapter = Unirest
										 			 .get("https://doodle-manga-scraper.p.mashape.com/mangareader.net/manga/"+mangaId+"/")
													 .header("X-Mashape-Key",
													 "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
													 .header("Accept", "text/plain")
													 .asString();
			
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
