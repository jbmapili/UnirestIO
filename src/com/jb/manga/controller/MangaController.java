package com.jb.manga.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jb.manga.entity.Pages;
import com.jb.manga.entity.UsersChapter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class MangaController
 */
@WebServlet("/MangaController")
public class MangaController extends HttpServlet {
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
			// HttpResponse<JsonNode> response = Unirest
			// .get("https://api.stackexchange.com/2.2/questions")
			// .header("accept", "application/json")
			// .queryString("order", "desc").queryString("sort", "creation")
			// .queryString("filter", "default")
			// .queryString("site", "stackoverflow").asJson();

			//
			// HttpResponse<String> response =
			// Unirest.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net")
			// .header("X-Mashape-Key",
			// "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
			// .header("Accept", "text/plain")
			// .asString();

			// HttpResponse<String> response =
			// Unirest.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net/manga/naruto/")
			// .header("X-Mashape-Key",
			// "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
			// .header("Accept", "text/plain")
			// .asString();

			HttpResponse<String> manga;

			manga = Unirest
					.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net/manga/naruto/1")
					.header("X-Mashape-Key",
							"raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
					.header("Accept", "application/json").asString();

			Gson gson = new Gson();

			// System.out.println(gson.toJson(response.getBody()));
			String json = "[" + manga.getBody() + "]";

			Type collectionType = new TypeToken<ArrayList<UsersChapter>>() {
			}.getType();
			List<UsersChapter> getPageChapter = gson.fromJson(json,
					collectionType);

			for (UsersChapter u : getPageChapter) {
				System.out.print(u.getHref());
				System.out.println(" " + u.getName() + " " + u.getLastUpdate());
				for (Pages p : u.getPages()) {
					System.out.println("\t" + p.getPageId() + " " + p.getUrl());
				}
			}

			try {
				String path = "http://chart.finance.yahoo.com/z?s=GOOG&t=6m&q=l";
				System.out.println("Get Image from " + path);
				URL url = new URL(getPageChapter.get(0).getPages().get(0)
						.getUrl());
				BufferedImage image = ImageIO.read(url);
				System.out.println("Load image into frame...");
				JLabel label = new JLabel(new ImageIcon(image));
				JFrame f = new JFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.getContentPane().add(label);
				f.pack();
				f.setLocation(200, 200);
				f.setVisible(true);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
