package application.controllers;

import application.utils.JsonConverter2;
import application.utils.PathFinder;
import application.models.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;



public class LeHoiDetailController extends DetailController implements Initializable {
	
	ObservableList<LeHoi> list = null;
			//JsonConverter2.JsonToObListLeHoi(PathFinder.getPathJson("LeHoi.json"));
    
    @FXML
    private TableColumn<LeHoi, String> idCol;
    
    @FXML
    private TableColumn<LeHoi, String> titleCol;

    @FXML
    private TableView<LeHoi> table;

    
    @FXML
    private TextArea displayArea;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
	}
	
	public void setList(ObservableList<LeHoi> inputList) {
		list = inputList;
		table.setItems(list);
	}
	
	@FXML
	public void pressDetailBtn(ActionEvent e) {
		LeHoi temp = table.getSelectionModel().getSelectedItem();
		nameLabel.setText(temp.getTitle());
		displayArea.setText(temp.toString());
//		System.out.println(temp.getTitle());

	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}

    
    public void clear() {
		nameLabel.setText("LeHoi");
		displayArea.setText("");
    }
    
}
