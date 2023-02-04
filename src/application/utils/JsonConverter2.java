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

import application.models.DiaDiem;
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
}

