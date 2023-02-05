package application.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import application.data.Database;
import application.models.LeHoi;

public class LeHoiCrawler extends WikipediaCrawler{
	private String originalUrl;
	private String subUrl;
	
	public LeHoiCrawler() {
		super();
		originalUrl = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam"; 
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	
	
	public static void main(String[] args) {
		LeHoiCrawler crawler = new LeHoiCrawler(); 
		Document document;
		Database db = new Database();
		try {
			document = Jsoup.connect(crawler.getOriginalUrl()).get();
//			System.out.println(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			document = null;
			e.printStackTrace();
		} 
		Element leHoiTable = crawler.getDataTable(document);
		Elements leHoiTableRows = crawler.getDataTableRows(leHoiTable);
		leHoiTableRows.remove(0);
		System.out.println(leHoiTableRows);
		for(Iterator<Element> iter = leHoiTableRows.iterator();iter.hasNext();) {
			Element row = iter.next();
			LeHoi leHoiItem = crawler.getDataFromRow(row);
			db.addData(leHoiItem.createJSON());
		}
		db.saveData("src/application/data/LeHoi.json");
	}
}
