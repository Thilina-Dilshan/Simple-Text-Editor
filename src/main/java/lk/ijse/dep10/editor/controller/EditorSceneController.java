package lk.ijse.dep10.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

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
        txtEditor.textProperty().addListener((value, previous, current) -> {
            if (current == null) return;
            root = (Stage) txtEditor.getScene().getWindow();
            if (!txtEditor.getText().isBlank() || isEdited) {
                if (!root.getTitle().contains("*")) {//txtEditor.getText().length()==1
                    root.setTitle("*".concat(root.getTitle()));
                    isEdited = true;
                    System.out.println("isEdited= " + isEdited);
                }
            }
        });
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
        if (isEdited) {
//            if (!isSaved) {
            System.out.println("isEdited= " + isEdited + "\tisSaved= " + isSaved);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "",
                    ButtonType.CANCEL, ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Text will be lost. Do you want to save changes before closing?");
            Optional<ButtonType> alertResult = alert.showAndWait();
            if (alertResult.isEmpty() || alertResult.get() == ButtonType.CANCEL) return;
            if (alertResult.get() == ButtonType.NO) {
                root.close();
                System.out.println("root is not null");
            }
            if (alertResult.get() == ButtonType.YES) {
                mnSave.fire();
                isSaved = true;
            }
//            }
        }
        System.out.println("isEdit= " + isEdited + "\tisSaved= " + isSaved);
        root.close();
    }


    public void mnNewOnAction(ActionEvent event) {
        System.out.println("New text");
        if (isEdited) {
//            if (!isSaved) {
            System.out.println("new=" + isEdited);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "",
                    ButtonType.CANCEL, ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Text will be lost. Do you want to save before open a new one?");
            Optional<ButtonType> alertResult = alert.showAndWait();
            if (alertResult.isEmpty() || alertResult.get() == ButtonType.CANCEL) return;
            if (alertResult.get() == ButtonType.YES) mnSave.fire();
            if (alertResult.get() == ButtonType.NO) {
                txtEditor.clear();
                root.setTitle("Untitled");
                isEdited = false;
            }
//            }
        }
        if (isSaved) {
            txtEditor.clear();
            root = (Stage) txtEditor.getScene().getWindow();
            root.setTitle("Untitled");
            isEdited = false;
            isSaved = false;
        }
    }


    public void mnOpen(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        File file = fileChooser.showOpenDialog(txtEditor.getScene().getWindow());
        if (file == null) return;

        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();
        fis.close();

        txtEditor.setText(new String(bytes));

    }


    public void mnPrintOnAction(ActionEvent event) {

    }


    public void mnSave(ActionEvent event) throws IOException {
        if (!isSaved) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save a file");
            file = fileChooser.showSaveDialog(txtEditor.getScene().getWindow());
            if (file == null) return;
        }

        fos = new FileOutputStream(file);
        String text = txtEditor.getText();
        byte[] bytes = text.getBytes();
        fos.write(bytes);
        fos.close();
        isSaved = true;
        isEdited = false;
        System.out.println("isSaved==true");
        System.out.println("isEdited==false");
        root.setTitle(file.getName());
    }


    public void rootPaneOnDragDropped(DragEvent dragEvent) throws IOException {
        File droppedFile = dragEvent.getDragboard().getFiles().get(0);


        FileInputStream fis = new FileInputStream(droppedFile);
        byte[] bytes = fis.readAllBytes();
        fis.close();
        System.out.println("Dropped file :" + droppedFile.getName());
        txtEditor.setText(new String(bytes));
        root.setTitle(droppedFile.getName());
        isEdited = true;
    }

    public void rootPaneOnDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);

    }

    public void mnSaveAsOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save a file");
        File file = fileChooser.showSaveDialog(txtEditor.getScene().getWindow());
        if (file == null) return;
        FileOutputStream fos = new FileOutputStream(file);
        String text = txtEditor.getText();
        byte[] bytes = text.getBytes();
        fos.write(bytes);
        fos.close();
        isSaved = true;
        isEdited = false;
        System.out.println("isSaved==true");
        System.out.println("isEdited==false");
        root.setTitle(file.getName());
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
