package application.crawler;

import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import application.models.LeHoi;

public class WikipediaCrawler {
	public Element getDataTable(Document document) {
		Element table = document.getElementsByTag("table").get(1);
		return table;
	}
	
	public Elements getDataTableRows(Element table) {
		Elements tableRows = table.getElementsByTag("tr");
		return tableRows;
	}
	
	public LeHoi getDataFromRow(Element row) {
		String title = row.getElementsByTag("td").get(2).text();
		String date = row.getElementsByTag("td").get(0).text();
		String diaDiem = row.getElementsByTag("td").get(1).text();
		ArrayList<String> nhanVat = new ArrayList<String>();
		nhanVat.add(row.getElementsByTag("td").get(4).text());
		LeHoi leHoiItem = new LeHoi(title, date, diaDiem, nhanVat);
		return leHoiItem;
	}
}
