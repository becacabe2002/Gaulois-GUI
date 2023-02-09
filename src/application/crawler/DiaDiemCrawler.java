package application.crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import application.data.Database;
import application.models.DiaDiem;
import application.models.HistoricalItem;

public class DiaDiemCrawler extends ThuVienLichSuCrawler{
	private String originalUrl;
	private String subUrl;
	
	public DiaDiemCrawler() {
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
	
	
	public HistoricalItem getDataDiaDiemPage(Document documentDiaDiemPage) throws IOException {
		DiaDiem diaDiemData = new DiaDiem(); 
		Elements elms = this.getHeaderCards(documentDiaDiemPage);
		String title = elms.first().getElementsByClass("header-edge").text();
		Element headerCardSuKien = this.getCategoryHeaderCard("Sự kiện liên quan", elms);
		Element headerCardNhanVat = this.getCategoryHeaderCard("Nhân vật liên quan", elms);
		ArrayList<String> suKienTitleElements = new ArrayList<String>();
		ArrayList<String> nhanVatTitleElements = new ArrayList<String>();
		if(headerCardSuKien != null) {
			suKienTitleElements = this.getInnerDataCardsTitles(headerCardSuKien);
		}
		if(headerCardNhanVat != null) {
			nhanVatTitleElements = this.getInnerDataCardsTitles(headerCardNhanVat);
		}
		diaDiemData.setSuKien(suKienTitleElements);
		diaDiemData.setNhanVat(nhanVatTitleElements);
		diaDiemData.setTitle(title);
		System.out.println(title);
		System.out.println(nhanVatTitleElements);
		System.out.println(suKienTitleElements);
		return diaDiemData;
	}
	public static void main(String[] args) throws IOException {
		DiaDiemCrawler crawler = new DiaDiemCrawler();
		Database db = new Database();
		for(int pageIndex = 1;pageIndex<=10;pageIndex++) {
		Elements cardElements = crawler.listElementCard(crawler.getOriginalUrl() + "/dia-diem?page="+ pageIndex, "divide-content");
		System.out.println("page index: " + pageIndex);
		cardElements.forEach((element) -> {
			try {
				Document documentSubPage = crawler.getSubPage(element);
				HistoricalItem data = crawler.getDataDiaDiemPage(documentSubPage);
				db.addData(data.createJSON());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		}
		db.saveData("src/application/data/DiaDiem.json");
		System.out.println("done");
		//System.out.println(cardElements);
		
	}
}
