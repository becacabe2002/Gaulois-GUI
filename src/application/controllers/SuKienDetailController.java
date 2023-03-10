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



public class SuKienDetailController implements Initializable {
	
	ObservableList<SuKien> list = JsonConverter2.JsonToObListSuKien(PathFinder.getPathJson("SuKien.json"));
	
	@FXML
    private Button detailBtn;
    
    @FXML
    private TableColumn<SuKien, String> idCol;
    
    @FXML
    private TableColumn<SuKien, String> titleCol;

    @FXML
    private TableView<SuKien> table;
    
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
		SuKien temp = table.getSelectionModel().getSelectedItem();
		nameLabel.setText(temp.getTitle());
		displayArea.setText(temp.toString());
//		System.out.println(temp.getTitle());

	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}

    private ObservableList<SuKien> filterList(List<SuKien> ls, String searchText){
        List<SuKien> filteredList = new ArrayList<>();

        for (SuKien d : ls){
            if(searchFindsOrder(d, searchText)){
                filteredList.add(d);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(SuKien sukien, String searchText){
        return (sukien.getTitle().toLowerCase().contains(searchText.toLowerCase()));
//                (order.getState().toLowerCase().contains(searchText)) ||
//                Integer.valueOf(order.getId()).toString().equals(searchText);
    }
    
    public void clear() {
		nameLabel.setText("SuKien");
		displayArea.setText("");
    }
    
}
