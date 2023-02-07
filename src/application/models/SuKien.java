package application.models;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class SuKien extends HistoricalItem{
//	private String title;
	private String beginYear;
	private String endYear;
	private String TrieuDai;
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> diaDiem = new ArrayList<String>();
	
	
	
	public SuKien() {
		super();
	}

	public SuKien(String title, String beginYear, String endYear, String trieuDai, ArrayList<String> nhanVat,
			ArrayList<String> diaDiem) {
		super();
		this.Title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
		TrieuDai = trieuDai;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}
	
	public SuKien(String title) {
		super();
		this.Title = title;
	}

	
	
	public SuKien(String title, String beginYear, String endYear) {
		super();
		this.Title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
	}
	
	

	public SuKien(String title, String beginYear, String endYear, ArrayList<String> nhanVat,
			ArrayList<String> diaDiem) {
		super();
		this.Title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}

	public String getBeginYear() {
		return beginYear;
	}
	public void setBeginYear(String beginYear) {
		this.beginYear = beginYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getTrieuDai() {
		return TrieuDai;
	}
	public void setTrieuDai(String trieuDai) {
		TrieuDai = trieuDai;
	}
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}
	public void setNhanVat(ArrayList<String> nhanVat) {
		this.nhanVat = nhanVat;
	}
	public ArrayList<String> getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(ArrayList<String> diaDiem) {
		this.diaDiem = diaDiem;
	}

	@Override
	public JSONObject createJSON() {
		JSONObject jsonObject = new JSONObject();
	    //Inserting key-value pairs into the json object
	    jsonObject.put("ID", this.id);
	    jsonObject.put("Title", this.Title);
	    jsonObject.put("Historical_Places", this.diaDiem);
	    jsonObject.put("Historical_Characters", this.nhanVat);
	    this.jsonFormat = jsonObject;
	    return jsonObject;
	}
	
	public String toString() {
		StringBuffer nvBuffer = new StringBuffer();
		StringBuffer ddBuffer = new StringBuffer();
		
		nvBuffer.append("\n- Các nhân vật liên quan đến sự kiện:\n");
		for(String nv : nhanVat) {
			nvBuffer.append("+ " + nv +"\n");
		}
		
		ddBuffer.append("\n- Các địa điểm liên quan đến sự kiện:\n");
		for(String dd : nhanVat) {
			ddBuffer.append("+ " + dd +"\n");
		}
		
		String res = "<< " + this.getTitle() + " >>" + nvBuffer.toString() + ddBuffer.toString();
		
		return res;
	}
	
}