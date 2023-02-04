package application.controllers;

import application.utils.JSonConverter;
import application.utils.JsonConverter2;
import application.utils.PathFinder;
import application.models.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;



public class LeHoiDetailController implements Initializable {
	
	ObservableList<LeHoi> list = JsonConverter2.JsonToObListLeHoi(PathFinder.getPathJson("LeHoi.json"));
	
	@FXML
    private Button detailBtn;
    
    @FXML
    private TableColumn<LeHoi, String> idCol;
    
    @FXML
    private TableColumn<LeHoi, String> titleCol;

    @FXML
    private TableView<LeHoi> table;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private TextArea displayArea;
    
    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchInput;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
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

    private ObservableList<LeHoi> filterList(List<LeHoi> ls, String searchText){
        List<LeHoi> filteredList = new ArrayList<>();

        for (LeHoi d : ls){
            if(searchFindsOrder(d, searchText)){
                filteredList.add(d);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(LeHoi lehoi, String searchText){
        return (lehoi.getTitle().toLowerCase().contains(searchText));
//                (order.getState().toLowerCase().contains(searchText)) ||
//                Integer.valueOf(order.getId()).toString().equals(searchText);
    }
    
    public void clear() {
		nameLabel.setText("LeHoi");
		displayArea.setText("");
    }
    
}
