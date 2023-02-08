package application.controllers;

import java.io.IOException;

import application.models.*;
import application.utils.JsonConverter2;
import application.utils.PathFinder;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {
	private static Pane viewDiaDiem;
	private static Pane viewLeHoi;
	private static Pane viewNhanVat;
	private static Pane viewSuKien;
	private static Pane viewTrieuDai;
	
	ObservableList<TrieuDai> listTD = JsonConverter2.JsonToObListTrieuDai(PathFinder.getPathJson("TrieuDai.json"));
	ObservableList<SuKien> listSK = JsonConverter2.JsonToObListSuKien(PathFinder.getPathJson("SuKien.json"));
	ObservableList<NhanVat> listNV = JsonConverter2.JsonToObListNhanVat(PathFinder.getPathJson("NhanVat.json"));
	ObservableList<LeHoi> listLH = JsonConverter2.JsonToObListLeHoi(PathFinder.getPathJson("LeHoi.json"));
	ObservableList<DiaDiem> listDD = JsonConverter2.JsonToObListDiaDiem(PathFinder.getPathJson("DiaDiem.json"));
	
    @FXML
    private Button DiaDiemBtn;

    @FXML
    private Button LeHoiBtn;

    @FXML
    private BorderPane MainPane;

    @FXML
    private Button NhanVatBtn;

    @FXML
    private Button SuKienBtn;

    @FXML
    private Button TrieuDaiBtn;

    @FXML
    public void switchWindow(ActionEvent e) {
    	if(e.getSource() == DiaDiemBtn) {
    		try {
    			FXMLLoader ldDD = new FXMLLoader(getClass().getResource("/application/views/DiaDiemDetail.fxml"));
    			viewDiaDiem = ldDD.load();
    			DiaDiemDetailController dcDD = ldDD.getController();
    			dcDD.setList(listDD);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	MainPane.setCenter(viewDiaDiem);
    	} else if (e.getSource() == LeHoiBtn) {
    		try {
    			FXMLLoader ldLH = new FXMLLoader(getClass().getResource("/application/views/LeHoiDetail.fxml"));
    			viewLeHoi = ldLH.load();
    			LeHoiDetailController dcLH = ldLH.getController();
    			dcLH.setList(listLH);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	MainPane.setCenter(viewLeHoi);
    	} else if(e.getSource() == NhanVatBtn) {
    		try {
    			FXMLLoader ldNV = new FXMLLoader(getClass().getResource("/application/views/NhanVatDetail.fxml"));
    			viewNhanVat = ldNV.load();
    			NhanVatDetailController dcNV = ldNV.getController();
    			dcNV.setList(listNV);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	MainPane.setCenter(viewNhanVat);
    	} else if(e.getSource() == SuKienBtn) {
    		try {
    			FXMLLoader ldSK = new FXMLLoader(getClass().getResource("/application/views/SuKienDetail.fxml"));
    			viewSuKien = ldSK.load();
    			SuKienDetailController dcSK = ldSK.getController();
    			dcSK.setList(listSK);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	MainPane.setCenter(viewSuKien);
    	} else {
    		try {
    			FXMLLoader ldTD = new FXMLLoader(getClass().getResource("/application/views/TrieuDaiDetail.fxml"));
    			viewTrieuDai = ldTD.load();
    			TrieuDaiDetailController dcTD = ldTD.getController();
    			dcTD.setList(listTD);
    			
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
        	MainPane.setCenter(viewTrieuDai);
    	}
    	
    }
}
