package application.controllers;
import application.utils.JsonConverter2;
import application.utils.PathFinder;
import application.models.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;



public class DiaDiemDetailController extends DetailController implements Initializable{
	
	private ObservableList<DiaDiem> list = null;
			//JsonConverter2.JsonToObListDiaDiem(PathFinder.getPathJson("DiaDiem.json"));
	
	
    @FXML
    private TableColumn<DiaDiem, String> idCol;
    
    @FXML
    private TableColumn<DiaDiem, String> titleCol;

    @FXML
    private TableView<DiaDiem> table;
    
    
    @FXML
    private TextArea displayAreaNV;
    
    @FXML
    private TextArea displayAreaSK;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
	}
	
	public void setList(ObservableList<DiaDiem> inputList) {
		list = inputList;
		table.setItems(list);
	}
	
	@FXML
	public void pressDetailBtn(ActionEvent e) {
		DiaDiem temp = table.getSelectionModel().getSelectedItem();
		nameLabel.setText(temp.getTitle());
		setT(displayAreaNV, temp.toStringNV());
		setT(displayAreaSK, temp.toStringSK());
//		System.out.println(temp.getTitle());

	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}
    
    
    public void clear() {
		nameLabel.setText("DiaDiem");
		setT(displayAreaNV,"");
		setT(displayAreaSK,"");
    }
    
}
