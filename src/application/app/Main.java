package application.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage test) throws IOException{
		FXMLLoader loader2 = new FXMLLoader();
		Stage loadingStage = new Stage();
		loader2.setLocation(getClass().getResource("/application/views/LoadingScreen.fxml"));
		Parent ldRoot = loader2.load();
		Scene loadingView = new Scene(ldRoot);
		loadingStage.setScene(loadingView);
		loadingStage.show();
		
		
//		FXMLLoader loader1 = new FXMLLoader();
//		loader1.setLocation(getClass().getResource("/application/views/MainScreen.fxml"));
//		Parent tableViewParent = loader1.load();
//		Scene tableView = new Scene(tableViewParent);
//		test.setScene(tableView);
//		test.setTitle("Historical Dictionary");
//		test.show();
//		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
