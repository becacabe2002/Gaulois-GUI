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
	private static Pane view;
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
			view = FXMLLoader.load(getClass().getResource("/application/views/DiaDiemDetail.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	MainPane.setCenter(view);
    }
}
