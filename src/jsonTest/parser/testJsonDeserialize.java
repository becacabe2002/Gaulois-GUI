package jsonTest.parser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import application.models.DiaDiem;

public class testJsonDeserialize{
    public static void main(String[] args) {

        //Tạo đối tượng Gson
        Gson gson = new Gson();

        //Chuyển đổi từ JSON sang ArrayList
        DiaDiem[] list = null;
        try {
        	File file = new File("C:\\Users\\becac\\OneDrive - Hanoi University of Science and Technology\\Documents\\A_HUST\\2022.1\\OOP\\Gaulois-GUI\\src\\jsonTest\\dataSource\\DiaDiem.json");
        	FileReader reader = new FileReader(file);
            //Type type = new TypeToken<ArrayList<DiaDiem>>(){}.getType();
            list = gson.fromJson(reader, DiaDiem[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(DiaDiem p : list){
            System.out.println(p);
        }
    }
}

