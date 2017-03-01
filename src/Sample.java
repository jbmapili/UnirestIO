import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Sample {
	public void getQuestionsUsingUnirest() throws Exception {
//		HttpResponse<JsonNode> response = Unirest
//				.get("https://api.stackexchange.com/2.2/questions")
//				.header("accept", "application/json")
//				.queryString("order", "desc").queryString("sort", "creation")
//				.queryString("filter", "default")
//				.queryString("site", "stackoverflow").asJson();
		
		
//		
//		HttpResponse<String> response = Unirest.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net")
//				.header("X-Mashape-Key", "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
//				.header("Accept", "text/plain")
//				.asString();
		
//		HttpResponse<String> response = Unirest.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net/manga/naruto/")
//				.header("X-Mashape-Key", "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
//				.header("Accept", "text/plain")
//				.asString();
		
		HttpResponse<String> response = Unirest.get("https://doodle-manga-scraper.p.mashape.com/mangareader.net/manga/naruto/1")
				.header("X-Mashape-Key", "raFjk0Yuu9mshz6KxNgPAPNXnCvHp1hHzaqjsnCEea7V86YrGh")
				.header("Accept", "text/plain")
				.asString();
		
		
		System.out.println(response.getBody());
	}

	public static void main(String args[]) throws Exception {
		Sample client = new Sample();
		client.getQuestionsUsingUnirest();
	}
}