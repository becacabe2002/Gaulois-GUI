package application.models;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class LeHoi extends HistoricalItem{
	private int id;
//	private String title;
	private String date;
	private String diaDiem;
	private ArrayList<String> nhanVat;
	
	
	
	public LeHoi(String title, String date, String diaDiem, ArrayList<String> nhanVat) {
		super();
		this.Title = title;
		this.date = date;
		this.diaDiem = diaDiem;
		this.nhanVat = nhanVat;
	}
	public LeHoi(String title) {
		super();
		this.Title = title;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return diaDiem;
	}
	public void setLocation(String location) {
		this.diaDiem = location;
	}
	public ArrayList<String> getHistorical_Characters() {
		return nhanVat;
	}
	public void setHistorical_Characters(ArrayList<String> historical_Characters) {
		nhanVat = historical_Characters;
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
		for (String nv : nhanVat) {
			nvBuffer.append("+" + nv +"\n");
		}
		String res = "<<" + Title + ">>\n" + "- Thời gian diễn ra: " + date + "\n- Nơi diễn ra: " + diaDiem + "\n- Các nhân vật liên quan: \n" + nvBuffer.toString();
		return res;
	}
	
}
