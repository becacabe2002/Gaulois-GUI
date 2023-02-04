package application.models;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class DiaDiem extends HistoricalItem{
	private String Title;
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> suKien = new ArrayList<String>();
	public DiaDiem( String title,ArrayList<String> nhanVat, ArrayList<String> suKien) {
		super();
		this.Title = title;
		this.nhanVat = nhanVat;
		this.suKien = suKien;
	}
	
	public DiaDiem(ArrayList<String> Historical_Characters, String title) {
		super();
		this.Title = title;
		this.nhanVat = Historical_Characters;
	}
	public DiaDiem(String title, ArrayList<String> Historical_Events) {
		super();
		this.Title = title;
		this.suKien = Historical_Events;
	}
	
	public DiaDiem(String title) {
		super();
		this.Title = title;
	}
	
	public DiaDiem() {
		super();
	}

	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	public void setSuKien(ArrayList<String> suKien) {
		this.suKien = suKien;
	}
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(ArrayList<String> nhanVat) {
		this.nhanVat = nhanVat;
	}

	public void getWebUrl() {
		String url = "https://thuvienlichsu.com/dia-diem";
	}
	
	
//	@Override
//	public JSONObject createJSON() {
//		JSONObject jsonObject = new JSONObject();
//	    //Inserting key-value pairs into the json object
//	    jsonObject.put("ID", this.id);
//	    jsonObject.put("Title", this.Title);
//	    jsonObject.put("Historical_Events", this.suKien);
//	    jsonObject.put("Historical_Characters", this.nhanVat);
//	    this.jsonFormat = jsonObject;
//	    return jsonObject;
//	}
	
	public String toStringNV() {
		StringBuffer bufferNhanVat = new StringBuffer();
		for (String nv: nhanVat) {
			bufferNhanVat.append("+ "+ nv);
			bufferNhanVat.append("\n");
		}
		String res ="-Nhân vật liên quan:\n" + bufferNhanVat.toString();
		System.out.println(res);
		return res;
	}
	public String toStringSK() {
		StringBuffer bufferSuKien = new StringBuffer();
		for (String sk: suKien) {
			bufferSuKien.append("+ " + sk);
			bufferSuKien.append("\n");
		}
		String res = "-Sự kiện liên quan:\n" + bufferSuKien.toString();
		System.out.println(res);
		return res;
	}
}