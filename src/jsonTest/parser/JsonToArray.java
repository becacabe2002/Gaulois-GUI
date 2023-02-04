package jsonTest.parser;
import com.google.gson.Gson;

import application.models.DiaDiem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JsonToArray {
	public static void main(String args[]){
		Gson nGson = new Gson();
		
		//chuyen tu JSON sang Obj
		DiaDiem[] diadiems = null;
		try {
			File file = new File("C:\\Users\\becac\\OneDrive - Hanoi University of Science and Technology\\Documents\\A_HUST\\2022.1\\OOP\\Gaulois-GUI\\src\\jsonTest\\dataSource\\DiaDiem.json");
			FileReader reader = new FileReader(file);
			diadiems = nGson.fromJson(reader, DiaDiem[].class);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		for (DiaDiem d: diadiems) {
			System.out.println(d);
		}
	}
}
