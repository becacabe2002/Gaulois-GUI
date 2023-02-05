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
import application.models.SuKien;
import application.models.TrieuDai;

public class TrieuDaiCrawler extends ThuVienLichSuCrawler{
	private String originalUrl;
	private String subUrl;
	
	public TrieuDaiCrawler() {
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
	
	public HistoricalItem getDataTrieuDaiPage(Document documentSubPage) throws IOException {
		//crawl inside the subpage to get title of Trieu dai
		String title = documentSubPage.getElementsByTag("h1").text();
		//get begin and end year from title
		ArrayList<String> date = this.getBeginEndYear(title);
		String beginYear = date.get(0);
		String endYear = date.get(1);
		ArrayList<String> suKien = new ArrayList<String>();
		ArrayList<String> nhanVat = new ArrayList<String>();
		ArrayList<String> diaDiem = new ArrayList<String>();
		
		Elements suKienCard = this.listElementCard(this.subUrl, "divide-content");
		SuKien suKienData = new SuKien();
		for (Iterator<Element> i = suKienCard.iterator(); i.hasNext();) {
		    Element element = i.next();
		    try {
				Document documentSuKienPage = this.getSubPage(element);
				suKienData = this.getDataSuKienPage(documentSuKienPage);
				
				//add title of places into diaDiem array for TrieuDai object
				diaDiem = this.addTitlesDiaDanhFromSuKien(suKienData, diaDiem);
				
				//add characters into nhanVat array for TrieuDai object
				nhanVat = this.addTitlesNhanVatFromSuKien(suKienData, nhanVat);
				
				//add events into suKien array for TrieuDai object
				suKien = this.addTitlesSuKienFromSuKien(suKienData, suKien);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(diaDiem);
		TrieuDai itemTrieuDai = new TrieuDai(title, beginYear, endYear, suKien, nhanVat, diaDiem);
		return itemTrieuDai;
	}
	
	private ArrayList<String> addTitlesSuKienFromSuKien(SuKien suKienData, ArrayList<String> suKienArray) {
		// TODO Auto-generated method stub
		String titleSuKien = suKienData.getTitle();
		if(suKienArray.contains(titleSuKien) == false) {
			suKienArray.add(titleSuKien);
		}
		return suKienArray;
	}
	
	public ArrayList<String> addTitlesDiaDanhFromSuKien(SuKien suKienData, ArrayList<String> diaDiemArray){
		for(Iterator<String> j = suKienData.getDiaDiem().iterator();j.hasNext();) {
			String diaDiemTitle = j.next();
			if(diaDiemArray.contains(diaDiemTitle) == false) {
				diaDiemArray.add(diaDiemTitle);
			}
		}
		return diaDiemArray;
	}
	
	public ArrayList<String> addTitlesNhanVatFromSuKien(SuKien suKienData, ArrayList<String> nhanVatArray){
		for(Iterator<String> j = suKienData.getNhanVat().iterator();j.hasNext();) {
			String nhanVatTitle = j.next();
			if(nhanVatArray.contains(nhanVatTitle) == false) {
				nhanVatArray.add(nhanVatTitle);
			}
		}
		return nhanVatArray;
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
		return suKienData;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//TEST
		System.out.println("running");
		TrieuDaiCrawler crawler = new TrieuDaiCrawler();
		Elements cardElements = crawler.listElementCard(crawler.getOriginalUrl() + "/thoi-ky", "divide-content");
		Database db = new Database();
		cardElements.forEach((element) -> {
			try {
				Document documentSubPage = crawler.getSubPage(element);
				HistoricalItem data = crawler.getDataTrieuDaiPage(documentSubPage);
				db.addData(data.createJSON());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		db.saveData("src/application/data/TrieuDai.json");
		System.out.println("done");
		//System.out.println(cardElements);
	}
}
