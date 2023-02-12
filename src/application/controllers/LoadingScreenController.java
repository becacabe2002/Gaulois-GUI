package application.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import application.crawler.*;

public class LoadingScreenController {

    @FXML
    private TextArea returnRes;

    @FXML
    private Button startCrawlerBtn;
    
    @FXML
    public void PressButton(ActionEvent e) {
    	returnRes.setText("Loading....");
    	returnRes.setStyle("-fx-text-fill: yellow;");
    	try {
    	DiaDiemCrawler.main(null);
    	LeHoiCrawler.main(null);
    	NhanVatCrawler.main(null);
    	TrieuDaiCrawler.main(null);
    	SuKienCrawler.main(null);
    	} catch (IOException exc) {
    		exc.printStackTrace();
    	}
    	returnRes.setText("Done");
    	returnRes.setStyle("-fx-text-fill: green;");
    	Stage stg = (Stage)startCrawlerBtn.getScene().getWindow();
    	stg.setOnCloseRequest(event -> showMainStage());
    }
    public void showMainStage() {
    	Stage MainStage = new Stage();
    	FXMLLoader loader1 = new FXMLLoader();
		loader1.setLocation(getClass().getResource("/application/views/MainScreen.fxml"));
		Parent tableViewParent = null;
		try {
			tableViewParent = loader1.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene tableView = new Scene(tableViewParent);
		MainStage.setScene(tableView);
		MainStage.setTitle("Historical Dictionary");
		MainStage.show();
    }
}

