package models;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class SuKien extends HistoricalItem{
	private String title;
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
		this.title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
		TrieuDai = trieuDai;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}
	
	public SuKien(String title) {
		super();
		this.title = title;
	}

	
	
	public SuKien(String title, String beginYear, String endYear) {
		super();
		this.title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
	}
	
	

	public SuKien(String title, String beginYear, String endYear, ArrayList<String> nhanVat,
			ArrayList<String> diaDiem) {
		super();
		this.title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.nhanVat = nhanVat;
		this.diaDiem = diaDiem;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		// TODO Auto-generated method stub
		return null;
	}
	
}