package application.crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import application.data.Database;
import application.models.HistoricalItem;
import application.models.SuKien;

public class SuKienCrawler extends ThuVienLichSuCrawler{
	private String originalUrl;
	private String subUrl;
	
	public SuKienCrawler() {
		super();
		originalUrl = "https://thuvienlichsu.com"; 
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	@Override
	public Elements listElementCard(String url, String elmClass) throws IOException {
		Document document = Jsoup.connect(url).get(); 
		Elements elms = document.getElementsByClass(elmClass);
		return elms;
	}
	
	@Override
	public Document getSubPage(Element element) throws IOException {
		Element link = element.getElementsByTag("a").first();
		this.subUrl = link.absUrl("href");
		Document documentSubPage = Jsoup.connect(this.subUrl).get();
		return documentSubPage;
	}
	
	public SuKien getDataSuKienPage(Document documentSuKienPage) {
		SuKien suKienData = new SuKien(); 
		Elements elms = this.getHeaderCards(documentSuKienPage);
		String title = elms.first().getElementsByClass("header-edge").text();
		Element headerCardDiaDanh = this.getCategoryHeaderCard("Địa điểm liên quan", elms);
		Element headerCardNhanVat = this.getCategoryHeaderCard("Nhân vật liên quan", elms);
		ArrayList<String> diaDanhTitleElements = new ArrayList<String>();
		ArrayList<String> nhanVatTitleElements = new ArrayList<String>();
		if(headerCardDiaDanh != null) {
			diaDanhTitleElements = this.getInnerDataCardsTitles(headerCardDiaDanh);
		}
		if(headerCardNhanVat != null) {
			nhanVatTitleElements = this.getInnerDataCardsTitles(headerCardNhanVat);
		}
		suKienData.setDiaDiem(diaDanhTitleElements);
		suKienData.setNhanVat(nhanVatTitleElements);
		suKienData.setTitle(title);
		
		System.out.println(title);
		System.out.println(nhanVatTitleElements);
		System.out.println(diaDanhTitleElements);
		return suKienData;
	}
	
	public static void main(String[] args) throws IOException {
		SuKienCrawler crawler = new SuKienCrawler();
		Elements cardElements = crawler.listElementCard(crawler.getOriginalUrl() + "/su-kien", "divide-content");
		Database db = new Database();
		cardElements.forEach((element) -> {
			try {
				Document documentSubPage = crawler.getSubPage(element);
				HistoricalItem data = crawler.getDataSuKienPage(documentSubPage);
				db.addData(data.createJSON());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		db.saveData("src/application/data/SuKien.json");
		System.out.println("done");
		//System.out.println(cardElements);
	}
}
