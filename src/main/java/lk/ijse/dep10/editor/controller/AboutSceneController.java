package lk.ijse.dep10.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class AboutSceneController {

    public Label lblLast;
    public Label lblMain;
    @FXML
    private Button btnAbout;

    @FXML
    private Button btnCredit;

    @FXML
    private ImageView imgView;


    public void initialize() {
        lblMain.setText(
                "EditMe\n" + "1.0.0\n" +
                "EditMe is a small and lightweight text editor desktop application"
        );
        lblLast.setText("Copyright 2022 – the EditMe team");
        lblMain.setStyle("-fx-font-size: 13");
        lblLast.setStyle("-fx-font-size: 10");
    }

    @FXML
    void btnAboutOnAction(ActionEvent event) {
        initialize();
    }

    @FXML
    void btnCreditOnAction(ActionEvent event) {
        lblMain.setText(
                "Credited by  " + "Dilshan_PT"
        );
        lblLast.setText("");
    }

}
