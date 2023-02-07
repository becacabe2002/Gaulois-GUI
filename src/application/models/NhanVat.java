package application.models;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class NhanVat extends HistoricalItem {
//	private int id;
//	private String title;
	private String dateOfBirth;
	private String dateOfDeath;
	private ArrayList<String> suKien = new ArrayList<String>();
	private ArrayList<String> nhanVat = new ArrayList<String>();
	private ArrayList<String> diaDiem = new ArrayList<String>();
	public NhanVat(int id, String title, String dateOfBirth, String dateOfDeath, ArrayList<String> suKien, ArrayList<String> nhanVat,
			ArrayList<String> diaDiem) {
		super();
		this.id = id;
		this.Title = title;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.suKien = suKien;
		this.diaDiem = diaDiem;
	}
	
	
	
	public NhanVat() {
		super();
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfDeath() {
		return dateOfDeath;
	}
	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	public ArrayList<String> getSuKien() {
		return suKien;
	}
	public void setSuKien(ArrayList<String> suKien) {
		this.suKien = suKien;
	}
	public ArrayList<String> getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(ArrayList<String> diaDiem) {
		this.diaDiem = diaDiem;
	}
	
	public ArrayList<String> getNhanVat() {
		return nhanVat;
	}



	public void setNhanVat(ArrayList<String> nhanVat) {
		this.nhanVat = nhanVat;
	}



	@Override
	public JSONObject createJSON() {
		JSONObject jsonObject = new JSONObject();
	    //Inserting key-value pairs into the json object
	    jsonObject.put("ID", this.id);
	    jsonObject.put("Title", this.Title);
	    jsonObject.put("Date_Of_Birth", this.dateOfBirth);
	    jsonObject.put("Date_Of_Death", this.dateOfDeath);
	    jsonObject.put("Historical_Events", this.suKien);
	    jsonObject.put("Historical_Places", this.diaDiem);
	    jsonObject.put("Historical_Characters", this.nhanVat);
	    this.jsonFormat = jsonObject;
	    return jsonObject;
	}

	public String toStringDD(){
		StringBuffer ddBuffer = new StringBuffer();
		for (String dd : diaDiem) {
			ddBuffer.append(dd + ", ");
		}
		String res = "Các địa điểm liên quan: " + ddBuffer.toString();
		return res;
	}
	public String toStringSK(){
		StringBuffer skBuffer = new StringBuffer();
		for (String sk : suKien) {
			skBuffer.append("+ " + sk + "\n");
		}
		String res = "- Các sự kiện liên quan: \n" + skBuffer.toString();
		return res;
	}
	public String toStringNV(){
		StringBuffer nvBuffer = new StringBuffer();
		for (String nv : nhanVat) {
			nvBuffer.append("+ " + nv + "\n");
		}
		String res = "- Các nhân vật liên quan: \n" + nvBuffer.toString();
		return res;
	}

}
