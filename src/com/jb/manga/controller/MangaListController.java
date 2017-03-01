package com.jb.manga.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jb.manga.entity.UserList;
import com.jb.manga.entity.UsersChapter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class MangalistController
 */
@WebServlet("/MangalistController")
public class MangaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpResponse<String> mangaList = Unirest
													.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net")
													.header("X-Mashape-Key",
															"raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
													.header("Accept", "text/plain").asString();
			
			Gson gson = new Gson();
			System.out.println(mangaList.getBody());
			String json = mangaList.getBody();
			
			Type collectionType = new TypeToken<ArrayList<UserList>>() {}.getType();
			List<UserList> titles = gson.fromJson(json, collectionType);
			
			request.setAttribute("titles", titles);
			
			String page = "/pages/manga.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			dispatcher.forward(request, response);

			
//			Type collectionType = new TypeToken<ArrayList<UsersChapter>>() {}.getType();
//			List<UsersChapter> getPageChapter = gson.fromJson(json, collectionType);
//			
//			request.setAttribute("titles", getPageChapter);
//			
//			String page = "/pages/manga.jsp";
//			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//			dispatcher.forward(request, response);
			
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendError(400);
			return;
		}

	}

}
