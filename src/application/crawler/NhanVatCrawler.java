package application.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import application.data.Database;
import application.models.HistoricalItem;
import application.models.NhanVat;

public class NhanVatCrawler extends ThuVienLichSuCrawler{
	
	private String originalUrl;
	private String subUrl;
	
	public NhanVatCrawler() {
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
		// TODO Auto-generated method stub
		Document document = Jsoup.connect(url).get(); 
		Elements elms = document.getElementsByClass(elmClass);
		return elms;
	}

	@Override
	public Document getSubPage(Element element) throws IOException {
		// TODO Auto-generated method stub
		Element link = element.getElementsByTag("a").first();
		this.subUrl = link.absUrl("href");
		Document documentSubPage = Jsoup.connect(this.subUrl).get();
		return documentSubPage;
	}
	
	public HistoricalItem getDataNhanVatPage(Document documentSubPage) {
		NhanVat nhanVatData = new NhanVat(); 
		Elements elms = this.getHeaderCards(documentSubPage);
		String title = elms.first().getElementsByClass("header-edge").text();
		Element headerCardSuKien = this.getCategoryHeaderCard("Cuộc đời và sự kiện lịch sử liên quan đến " + this.getTitleOnly(title), elms);
		Element headerCardNhanVat = this.getCategoryHeaderCard("Nhân vật cùng thời kỳ với " + this.getTitleOnly(title), elms);
		ArrayList<String> suKienTitleElements = new ArrayList<String>();
		ArrayList<String> nhanVatTitleElements = new ArrayList<String>();
		if(headerCardSuKien != null) {
			suKienTitleElements = this.getInnerSuKienCardData(headerCardSuKien);
		}
		if(headerCardNhanVat != null) {
			nhanVatTitleElements = this.getInnerDataCardsTitles(headerCardNhanVat);
		}
		nhanVatData.setSuKien(suKienTitleElements);
		nhanVatData.setNhanVat(nhanVatTitleElements);
		nhanVatData.setTitle(title);
		return nhanVatData;
	}
	
	public ArrayList<String> getInnerSuKienCardData(Element headerCardSuKien){
		ArrayList<String> suKienData = new ArrayList<String>();
		Element cardBody = headerCardSuKien.getElementsByClass("card-body").first();
		Element cardBodyTable = cardBody.getElementsByClass("table").first();
		Elements tableRows = cardBodyTable.getElementsByTag("tr");
		for(Iterator<Element> j = tableRows.iterator();j.hasNext();) {
			Element row = j.next();
			if(row.getElementsByTag("td").size() == 3) {
				String suKienTitle = row.getElementsByTag("td").get(2).text();
				suKienData.add(suKienTitle);
			}
		}
		return suKienData;
	}
	
	public static void main(String[] args) throws IOException {
		//TEST
		System.out.println("running");
		NhanVatCrawler crawler = new NhanVatCrawler();
		Database db = new Database();
		for(int pageIndex = 1;pageIndex<=41;pageIndex++) {
			System.out.println("page index: " + pageIndex);
			Elements cardElements = crawler.listElementCard(crawler.getOriginalUrl() + "/nhan-vat?page=" + pageIndex, "divide-content");
			cardElements.forEach((element) -> {
				try {
					Document documentSubPage = crawler.getSubPage(element);
					HistoricalItem data = crawler.getDataNhanVatPage(documentSubPage);
					db.addData(data.createJSON());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		db.saveData("src/application/data/NhanVat.json");
		System.out.println("done");
		//System.out.println(cardElements);
	}

}
