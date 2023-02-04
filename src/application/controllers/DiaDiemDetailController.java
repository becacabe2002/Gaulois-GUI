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



public class DiaDiemDetailController implements Initializable {
	
	ObservableList<DiaDiem> list = JsonConverter2.JsonToObListDiaDiem(PathFinder.getPathJson("DiaDiem.json"));
	//ObservableList<DiaDiem> list = JSonConverter.toObListDiaDiem("C:\\Users\\becac\\OneDrive - Hanoi University of Science and Technology\\Documents\\A_HUST\\2022.1\\OOP\\Gaulois-GUI\\src\\jsonTest\\dataSource\\DiaDiem.json");
	@FXML
    private Button detailBtn;
    
    @FXML
    private TableColumn<DiaDiem, String> idCol;
    
    @FXML
    private TableColumn<DiaDiem, String> titleCol;

    @FXML
    private TableView<DiaDiem> table;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private TextArea displayAreaNV;
    
    @FXML
    private TextArea displayAreaSK;
    
    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchInput;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
		table.setItems(list);
	}
	
	@FXML
	public void pressDetailBtn(ActionEvent e) {
		DiaDiem temp = table.getSelectionModel().getSelectedItem();
		nameLabel.setText(temp.getTitle());
		displayAreaNV.setText(temp.toStringNV());
		displayAreaSK.setText(temp.toStringSK());
//		System.out.println(temp.getTitle());

	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}

    private ObservableList<DiaDiem> filterList(List<DiaDiem> ls, String searchText){
        List<DiaDiem> filteredList = new ArrayList<>();

        for (DiaDiem d : ls){
            if(searchFindsOrder(d, searchText)){
                filteredList.add(d);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(DiaDiem diadiem, String searchText){
        return (diadiem.getTitle().toLowerCase().contains(searchText));
//                (order.getState().toLowerCase().contains(searchText)) ||
//                Integer.valueOf(order.getId()).toString().equals(searchText);
    }
    
    public void clear() {
		nameLabel.setText("DiaDiem");
		displayAreaNV.setText("");
		displayAreaSK.setText("");
    }
    
}
