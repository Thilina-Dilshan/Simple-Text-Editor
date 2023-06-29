package lk.ijse.dep10.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditorSceneController {

    public TextArea txtEditor;
    public AnchorPane rootPane;
    public MenuItem mnSaveAs;
    public TextField txtFind;
    public Button btnDown;
    public Button btnUp;
    public CheckBox chkMatchCase;
    public TextField txtReplace;
    public Button btnReplace;
    public Button btnReplaceAll;
    public Label lblResult;
     
    public MenuItem mnAbout;
     
    public MenuItem mnClose;
     
    public MenuItem mnNew;
     
    public MenuItem mnOpen;
     
    public MenuItem mnPrint;
     
    public MenuItem mnSave;
    public Stage root;
    public boolean isEdited;
    public boolean isSaved;
    public FileOutputStream fos;
    public File file;


     public void initialize() {

    }

     
    public void mnAboutOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/AboutScene.fxml"));
        AnchorPane rootAbout = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootAbout));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(txtEditor.getScene().getWindow());
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

     
    public void mnCloseOnAction(ActionEvent event) {

    }

     
    public void mnNewOnAction(ActionEvent event) {


    }

     
    public void mnOpen(ActionEvent event) throws IOException {

    }

     
    public void mnPrintOnAction(ActionEvent event) {

    }

     
    public void mnSave(ActionEvent event) throws IOException {

    }



     public void rootPaneOnDragDropped(DragEvent dragEvent) throws IOException {

    }

     public void rootPaneOnDragOver(DragEvent dragEvent) {

    }

     public void mnSaveAsOnAction(ActionEvent actionEvent) throws IOException {

    }

    

     public void btnReplaceOnAction(ActionEvent event) {
        
    }

     public void btnReplaceAllOnAction(ActionEvent event) {
       
    }

     public void chkMatchCaseOnAction(ActionEvent event) {
        
    }

    public void btnDownOnAction(ActionEvent actionEvent) {

    }

    public void btnUpOnAction(ActionEvent actionEvent) {

    }
}
