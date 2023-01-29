package models;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class DiaDiem extends HistoricalItem{
	private String title;
	private ArrayList<String> suKien = new ArrayList<String>();
	private ArrayList<String> nhanVat = new ArrayList<String>();
	public DiaDiem(String title, ArrayList<String> suKien, ArrayList<String> nhanVat) {
		super();
		this.title = title;
		this.suKien = suKien;
		this.nhanVat = nhanVat;
	}
	
	public DiaDiem(String title, ArrayList<String> suKien) {
		super();
		this.title = title;
		this.suKien = suKien;
	}
	
	public DiaDiem(String title) {
		super();
		this.title = title;
	}
	
	public DiaDiem() {
		super();
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	
	@Override
	public JSONObject createJSON() {
		JSONObject jsonObject = new JSONObject();
	    //Inserting key-value pairs into the json object
	    jsonObject.put("ID", this.id);
	    jsonObject.put("Title", this.title);
	    jsonObject.put("Historical_Events", this.suKien);
	    jsonObject.put("Historical_Characters", this.nhanVat);
	    this.jsonFormat = jsonObject;
	    return jsonObject;
	}

}