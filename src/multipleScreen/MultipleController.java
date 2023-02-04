package multipleScreen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import application.utils.PathFinder;

public class MultipleController{

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private BorderPane main;
	
    @FXML
    public void pressBtn1(ActionEvent e) {
    	FxmlLoader ld = new FxmlLoader();
    	Pane view = ld.getPage("Screen1");
    	main.setCenter(view);
    }
    
    @FXML
    public void pressBtn2(ActionEvent e) {
    	FxmlLoader ld = new FxmlLoader();
    	Pane view = ld.getPage("Screen2");
    	main.setCenter(view);
    }
    
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		
//	}

}
