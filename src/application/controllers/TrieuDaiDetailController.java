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



public class TrieuDaiDetailController implements Initializable {
	
	ObservableList<TrieuDai> list = JsonConverter2.JsonToObListTrieuDai(PathFinder.getPathJson("TrieuDai.json"));
	//ObservableList<DiaDiem> list = JSonConverter.toObListDiaDiem("C:\\Users\\becac\\OneDrive - Hanoi University of Science and Technology\\Documents\\A_HUST\\2022.1\\OOP\\Gaulois-GUI\\src\\jsonTest\\dataSource\\DiaDiem.json");
	@FXML
    private Button detailBtn;
    
    @FXML
    private TableColumn<TrieuDai, String> idCol;
    
    @FXML
    private TableColumn<TrieuDai, String> titleCol;

    @FXML
    private TableView<TrieuDai> table;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private TextArea displayAreaNV;
    
    @FXML
    private TextArea displayAreaSK;
    
    @FXML
    private TextArea displayAreaDD;
    
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
		TrieuDai temp = table.getSelectionModel().getSelectedItem();
		nameLabel.setText(temp.getTitle());
		displayAreaDD.setText(temp.toStringDD());
		displayAreaNV.setText(temp.toStringNV());
		displayAreaSK.setText(temp.toStringSK());
//		System.out.println(temp.getTitle());

	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}

    private ObservableList<TrieuDai> filterList(List<TrieuDai> ls, String searchText){
        List<TrieuDai> filteredList = new ArrayList<>();

        for (TrieuDai d : ls){
            if(searchFindsOrder(d, searchText)){
                filteredList.add(d);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(TrieuDai trieudai, String searchText){
        return (trieudai.getTitle().toLowerCase().contains(searchText.toLowerCase()));
//                (order.getState().toLowerCase().contains(searchText)) ||
//                Integer.valueOf(order.getId()).toString().equals(searchText);
    }
    
    public void clear() {
		nameLabel.setText("TrieuDai");
		displayAreaNV.setText("");
		displayAreaSK.setText("");
		displayAreaDD.setText("");
    }
    
}
