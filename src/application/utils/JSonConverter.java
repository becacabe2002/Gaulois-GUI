package application.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import application.models.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class JSonConverter {
	public static ArrayList<DiaDiem> toArrListDiaDiem(String path) {
        //Tạo đối tượng Gson
        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ArrayList<DiaDiem> list = new ArrayList<>();
        try {
        	File file = new File(path);
        	FileReader reader = new FileReader(file);
            Type type = new TypeToken<ArrayList<DiaDiem>>(){}.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
	}
	public static ArrayList<SuKien> toArrListSuKien(String path) {
        //Tạo đối tượng Gson
        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ArrayList<SuKien> list = new ArrayList<>();
        try {
        	File file = new File(path);
        	FileReader reader = new FileReader(file);
            Type type = new TypeToken<ArrayList<SuKien>>(){}.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
	}
	public static ArrayList<TrieuDai> toArrListTrieuDai(String path) {
        //Tạo đối tượng Gson
        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        ArrayList<TrieuDai> list = new ArrayList<>();
        try {
        	File file = new File(path);
        	FileReader reader = new FileReader(file);
            Type type = new TypeToken<ArrayList<TrieuDai>>(){}.getType();
            list = gson.fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
	}
	public static ObservableList<DiaDiem> toObListDiaDiem(String path){
		ArrayList<DiaDiem> temp = toArrListDiaDiem(path);
        ObservableList<DiaDiem> list = FXCollections.observableArrayList();
       
        for(DiaDiem d : temp) {
        	list.add(d);
        }

        return list;
	}
	
}
