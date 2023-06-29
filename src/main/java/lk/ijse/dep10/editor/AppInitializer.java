package lk.ijse.dep10.editor;

import com.sun.javafx.charts.Legend;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dep10.editor.controller.EditorSceneController;

import java.io.IOException;
import java.util.Optional;

public class AppInitializer extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/EditorScene.fxml"));
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.setTitle("Untitled");
        primaryStage.show();
        primaryStage.centerOnScreen();
        EditorSceneController ctrl = fxmlLoader.getController();

        primaryStage.setOnCloseRequest(event -> {
            if (ctrl.isEdited) {
                System.out.println("gonna close");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "",
                        ButtonType.CANCEL, ButtonType.YES, ButtonType.NO);
                alert.setHeaderText("Text will be lost. Do you want to save changes before closing?");
                Optional<ButtonType> alertResult = alert.showAndWait();
                if (alertResult.isEmpty() || alertResult.get() == ButtonType.CANCEL) event.consume();
                if (alertResult.get() == ButtonType.NO) primaryStage.close();
                if (alertResult.get() == ButtonType.YES) {
                    ctrl.mnSave.fire();
                    if (!ctrl.isSaved) event.consume();
                }
            }

        });
    }
}
