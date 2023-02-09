package application.controllers;

import application.utils.JSonConverter;
import application.utils.JsonConverter2;
import application.utils.Linker;
import application.utils.PathFinder;
import application.models.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;



public class SuKienDetailController extends DetailController implements Initializable {
	Pane viewNhanVat = new Pane();
	Pane viewDiaDiem = new Pane();
	FXMLLoader ld = new FXMLLoader();
	FXMLLoader ld2 = new FXMLLoader();
	ObservableList<SuKien> list = null;
	//JsonConverter2.JsonToObListSuKien(PathFinder.getPathJson("SuKien.json"));
	
    
    @FXML
    private TableColumn<SuKien, String> idCol;
    
    @FXML
    private TableColumn<SuKien, String> titleCol;

    @FXML
    private TableView<SuKien> table;
    
    
    @FXML
    private TextArea displayArea;
    
    @FXML 
    private Button RelatedNVBtn;
    
    @FXML 
    private Button RelatedDDBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		table.setItems(list);
	}
	
	public void setList(ObservableList<SuKien> inputList) {
		list = inputList;
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
	public void pressRelatedNVBtn(ActionEvent e) {
		try {
		ld.setLocation(getClass().getResource("/application/views/NhanVatDetail.fxml"));
		viewNhanVat = ld.load();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		NhanVatDetailController dcNV = ld.getController();
		SuKien temp = table.getSelectionModel().getSelectedItem();
		ObservableList<NhanVat> ObListNV = JsonConverter2.JsonToObListNhanVat(PathFinder.getPathJson("NhanVat.json"));
		dcNV.setList(Linker.NVLinkedSK(temp, ObListNV));
		Node node = RelatedNVBtn;
		while (node.getParent() != null) {
		    node = node.getParent();
		    if (node instanceof BorderPane) {
		        BorderPane borderPane1 = (BorderPane) node;
		        borderPane1.setCenter(viewNhanVat);
		        break;
		    }
		}
	}
	
	@FXML
	public void pressRelatedDDBtn(ActionEvent e) {
		try {
		ld2.setLocation(getClass().getResource("/application/views/DiaDiemDetail.fxml"));
		viewDiaDiem = ld2.load();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		DiaDiemDetailController dcDD = ld2.getController();
		SuKien temp = table.getSelectionModel().getSelectedItem();
		ObservableList<DiaDiem> ObListDD = JsonConverter2.JsonToObListDiaDiem(PathFinder.getPathJson("DiaDiem.json"));
		dcDD.setList(Linker.DDLinkedSK(temp, ObListDD));
		Node node = RelatedDDBtn;
		while (node.getParent() != null) {
		    node = node.getParent();
		    if (node instanceof BorderPane) {
		        BorderPane borderPane2 = (BorderPane) node;
		        borderPane2.setCenter(viewDiaDiem);
		        break;
		    }
		}
	}
	
	@FXML
	public void search(ActionEvent e) {
		clear();
		table.setItems(filterList(list, searchInput.getText()));
	}

    
    public void clear() {
		nameLabel.setText("SuKien");
		displayArea.setText("");
    }
    
}
