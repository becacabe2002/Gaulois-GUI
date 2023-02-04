package application.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import multipleScreen.MultipleFxmlHandling;

//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.io.File;

/*
 * Get real path of a file
 */
public class PathFinder {
	/* 
	 * Get path of a Json file
	 */
	public static String getPathJson(String filename){
		String res = new String();
		File temp = new File(filename);
		try {
			res = temp.getCanonicalPath().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sbStr = res.substring(0, res.indexOf("Gaulois-GUI\\") + 12);
//		System.out.println(sbStr);
		res = sbStr + "src\\application\\data\\" + filename;
		return res;
	}
	
	/*
	 * Get path of a fxml file
	 */
//	public static URL getPathFxml(String fileName) {
//			URL fileUrl = MultipleFxmlHandling.class.getResource(fileName);	
//			System.out.println(fileUrl);
//			return fileUrl;
//	}
	
}
