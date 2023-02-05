package application.data;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Database {
	private JSONArray list;
	public Database() {
		list = new JSONArray();
	}
	public void addData(JSONObject jsonObject) {
		list.add(jsonObject);
	}
	public void saveData(String filePath) {
		try {
	         FileWriter file = new FileWriter(filePath);
	         file.write(list.toJSONString());
	         file.close();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	}
	public void loadData(String filePath) {
		
	}

}
