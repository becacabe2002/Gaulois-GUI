package application.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import application.models.HistoricalItem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import application.models.HistoricalItem;

public class DetailController{
	@FXML
    protected Button detailBtn;
    
    @FXML
    protected Label nameLabel;

    @FXML
    protected Button searchBtn;

    @FXML
    protected TextField searchInput;
    
    protected void setT(TextInputControl text, String input) {
    	text.setText(input);
    }
    
    protected <T extends HistoricalItem> boolean searchFindsOrder(T t, String searchText){
        return (t.getTitle().toLowerCase().contains(searchText));
    }
    
    protected <T extends HistoricalItem> ObservableList<T> filterList(List<T> ls, String searchText){
        List<T> filteredList = new ArrayList<>();

        for (T t : ls){
            if(searchFindsOrder(t, searchText)){
                filteredList.add(t);
            }
        }
        return FXCollections.observableList(filteredList);
    }

}
