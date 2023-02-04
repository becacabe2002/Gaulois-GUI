package multipleScreen;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
	private Pane view;
	
	public FxmlLoader() {
		
	}
	
	public Pane getPage(String fileName) {
		try {
			URL fileUrl = MultipleFxmlHandling.class.getResource(fileName + ".fxml");
			if(fileUrl == null) {
				throw new java.io.FileNotFoundException("No file can't be found");
			}
			
			System.out.println(fileUrl);
			view = FXMLLoader.load(fileUrl);

			} catch (Exception e) {
			System.out.println("No page " + fileName + ". Please check FxmlLoader.");

			}
			return view;
	}
}
