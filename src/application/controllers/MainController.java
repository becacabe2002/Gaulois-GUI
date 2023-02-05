package application.controllers;

import java.io.IOException;

import application.utils.PathFinder;

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
    public void pressDiaDiemBtn(ActionEvent e) {
    	
		try {
			viewDiaDiem = FXMLLoader.load(getClass().getResource("/application/views/DiaDiemDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(viewDiaDiem);
    }
    
    @FXML
    public void pressLeHoiBtn(ActionEvent e) {
    	
		try {
			viewLeHoi = FXMLLoader.load(getClass().getResource("/application/views/LeHoiDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(viewLeHoi);
    }
    
    @FXML
    public void pressNhanVatBtn(ActionEvent e) {
    	
		try {
			viewNhanVat = FXMLLoader.load(getClass().getResource("/application/views/NhanVatDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(viewNhanVat);
    }
    
    @FXML
    public void pressSuKienBtn(ActionEvent e) {
    	
		try {
			viewSuKien = FXMLLoader.load(getClass().getResource("/application/views/SuKienDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(viewSuKien);
    }
    
    @FXML
    public void pressTrieuDaiBtn(ActionEvent e) {
    	
		try {
			viewTrieuDai = FXMLLoader.load(getClass().getResource("/application/views/TrieuDaiDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(viewTrieuDai);
    }
}
