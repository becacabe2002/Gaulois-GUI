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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;



public class NhanVatDetailController extends DetailController implements Initializable {
	
	ObservableList<NhanVat> list = null;
			//JsonConverter2.JsonToObListNhanVat(PathFinder.getPathJson("NhanVat.json"));
    
    @FXML
    private TableColumn<NhanVat, String> idCol;
    
    @FXML
    private TableColumn<NhanVat, String> titleCol;

    @FXML
    private TableView<NhanVat> table;
    
    
    @FXML
    private TextArea displayAreaNV;
    
    @FXML
    private TextArea displayAreaSK;
    
    @FXML
    private TextField displayAreaDD;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		table.setItems(list);
	}
	
	public void setList(ObservableList<NhanVat> inputList) {
		list = inputList;
		table.setItems(list);
	}
	
	@FXML
	public void pressDetailBtn(ActionEvent e) {
		NhanVat temp = table.getSelectionModel().getSelectedItem();
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

    
    public void clear() {
		nameLabel.setText("NhanVat");
		displayAreaNV.setText("");
		displayAreaSK.setText("");
		displayAreaDD.setText("");
    }
    
}
