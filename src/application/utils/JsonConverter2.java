package application.utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.lang.reflect.Type;
import java.util.ArrayList;
//import java.util.List;

import application.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * Converter from Json file
 */
public class JsonConverter2{
	
	public static DiaDiem JsonElToDD(JsonElement Je) {
		JsonObject Jo = Je.getAsJsonObject();
		String title = Jo.get("Title").getAsString();
//		int id = Jo.get("ID").getAsInt();
		JsonArray tempArray = Jo.getAsJsonArray("Historical_Characters");
		ArrayList<String> nv = new ArrayList<String>();
		for(int i = 0; i < tempArray.size(); i++) {
			nv.add(tempArray.get(i).getAsString());
		}
		
		ArrayList<String> sk = new ArrayList<String>();
		JsonArray tempArray2 = Jo.getAsJsonArray("Historical_Events");
		for(int i = 0; i < tempArray2.size(); i++) {
			sk.add(tempArray2.get(i).getAsString());
		}
		DiaDiem res = new DiaDiem(title,nv,sk);

		return res;
	}
	
	public static LeHoi JsonElToLH(JsonElement Je) {
		JsonObject Jo = Je.getAsJsonObject();
		String title = Jo.get("Title").getAsString();
//		int id = Jo.get("ID").getAsInt();
		JsonArray tempArray = Jo.getAsJsonArray("Historical_Characters");
		ArrayList<String> nv = new ArrayList<String>();
		for(int i = 0; i < tempArray.size(); i++) {
			nv.add(tempArray.get(i).getAsString());
		}
		
		String dd = Jo.get("Historical_Places").getAsString();
		LeHoi res = new LeHoi(title);
		
		res.setHistorical_Characters(nv);
		res.setLocation(dd);
		
		return res;
	}
	
	public static NhanVat JsonElToNV(JsonElement Je) {
		JsonObject Jo = Je.getAsJsonObject();
		String title = Jo.get("Title").getAsString();
//		int id = Jo.get("ID").getAsInt();
		JsonArray tempArray = Jo.getAsJsonArray("Historical_Characters");
		ArrayList<String> nv = new ArrayList<String>();
		for(int i = 0; i < tempArray.size(); i++) {
			nv.add(tempArray.get(i).getAsString());
		}
		
		ArrayList<String> sk = new ArrayList<String>();
		JsonArray tempArray2 = Jo.getAsJsonArray("Historical_Events");
		for(int i = 0; i < tempArray2.size(); i++) {
			sk.add(tempArray2.get(i).getAsString());
		}
		
		ArrayList<String> dd = new ArrayList<String>();
		JsonArray tempArray3 = Jo.getAsJsonArray("Historical_Places");
		for(int i = 0; i < tempArray3.size(); i++) {
			dd.add(tempArray3.get(i).getAsString());
		}
		NhanVat res = new NhanVat();
		res.setTitle(title);
		res.setNhanVat(nv);
		res.setSuKien(sk);
		res.setDiaDiem(dd);
		return res;
	}
	
	public static SuKien JsonElToSK(JsonElement Je) {
		JsonObject Jo = Je.getAsJsonObject();
		String title = Jo.get("Title").getAsString();
//		int id = Jo.get("ID").getAsInt();
		JsonArray tempArray = Jo.getAsJsonArray("Historical_Characters");
		ArrayList<String> nv = new ArrayList<String>();
		for(int i = 0; i < tempArray.size(); i++) {
			nv.add(tempArray.get(i).getAsString());
		}
		
		ArrayList<String> dd = new ArrayList<String>();
		JsonArray tempArray2 = Jo.getAsJsonArray("Historical_Places");
		for(int i = 0; i < tempArray2.size(); i++) {
			dd.add(tempArray2.get(i).getAsString());
		}
		SuKien res = new SuKien(title);
		
		res.setNhanVat(nv);
		res.setDiaDiem(dd);
		return res;
	}
	
	public static TrieuDai JsonElToTD(JsonElement Je) {
		JsonObject Jo = Je.getAsJsonObject();
		String title = Jo.get("Title").getAsString();
//		int id = Jo.get("ID").getAsInt();
		JsonArray tempArray = Jo.getAsJsonArray("Historical_Characters");
		ArrayList<String> nv = new ArrayList<String>();
		for(int i = 0; i < tempArray.size(); i++) {
			nv.add(tempArray.get(i).getAsString());
		}
		String beginYear = Jo.get("Begin_Year").getAsString();
		String endYear = Jo.get("End_Year").getAsString();
		
		ArrayList<String> sk = new ArrayList<String>();
		JsonArray tempArray2 = Jo.getAsJsonArray("Historical_Events");
		for(int i = 0; i < tempArray2.size(); i++) {
			sk.add(tempArray2.get(i).getAsString());
		}
		ArrayList<String> dd = new ArrayList<String>();
		JsonArray tempArray3 = Jo.getAsJsonArray("Historical_Places");
		for(int i = 0; i < tempArray3.size(); i++) {
			dd.add(tempArray3.get(i).getAsString());
		}
		TrieuDai res = new TrieuDai(title,beginYear,endYear,sk, nv, dd);
		
		return res;
	}
	
	
	
	/*
	 * Convert from Json file to an ObservableList
	 * used in JavaFX tableView
	 */
    public static ObservableList<DiaDiem> JsonToObListDiaDiem(String path) {

        //Tạo đối tượng Gson
//        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ObservableList<DiaDiem> list = FXCollections.observableArrayList();
        File file = null;
        try {
        	file = new File(path);
        	JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
        	JsonArray ObjArray = fileElement.getAsJsonArray();
        	for(int i = 0; i < ObjArray.size(); i++) {
        		list.add(JsonElToDD(ObjArray.get(i)));
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }
    
    public static ObservableList<LeHoi> JsonToObListLeHoi(String path) {

        //Tạo đối tượng Gson
//        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ObservableList<LeHoi> list = FXCollections.observableArrayList();
        File file = null;
        try {
        	file = new File(path);
        	JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
        	JsonArray ObjArray = fileElement.getAsJsonArray();
        	for(int i = 0; i < ObjArray.size(); i++) {
        		list.add(JsonElToLH(ObjArray.get(i)));
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }
    
    public static ObservableList<NhanVat> JsonToObListNhanVat(String path) {

        //Tạo đối tượng Gson
//        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ObservableList<NhanVat> list = FXCollections.observableArrayList();
        File file = null;
        try {
        	file = new File(path);
        	JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
        	JsonArray ObjArray = fileElement.getAsJsonArray();
        	for(int i = 0; i < ObjArray.size(); i++) {
        		list.add(JsonElToNV(ObjArray.get(i)));
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }
    
    public static ObservableList<SuKien> JsonToObListSuKien(String path) {

        //Tạo đối tượng Gson
//        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ObservableList<SuKien> list = FXCollections.observableArrayList();
        File file = null;
        try {
        	file = new File(path);
        	JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
        	JsonArray ObjArray = fileElement.getAsJsonArray();
        	for(int i = 0; i < ObjArray.size(); i++) {
        		list.add(JsonElToSK(ObjArray.get(i)));
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }
    
    public static ObservableList<TrieuDai> JsonToObListTrieuDai(String path) {

        //Tạo đối tượng Gson
//        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ObservableList<TrieuDai> list = FXCollections.observableArrayList();
        File file = null;
        try {
        	file = new File(path);
        	JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
        	JsonArray ObjArray = fileElement.getAsJsonArray();
        	for(int i = 0; i < ObjArray.size(); i++) {
        		list.add(JsonElToTD(ObjArray.get(i)));
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return list;
    }
}

