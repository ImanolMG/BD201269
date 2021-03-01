package vistas;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalController {


    @FXML
    private Button btnDueños;
    @FXML
    private Button btnMascotas;
    @FXML
    private Button btnCitas;
    @FXML
    private Button btnMedicamentos;

    @FXML
    public void vistaDueños() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mascotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page));
            stage.setTitle("Caja");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }



    @FXML
    public void vistaMascotas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mascotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page));
            stage.setTitle("Caja");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void vistaCitas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mascotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page));
            stage.setTitle("Caja");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void vistaMedicamentos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mascotas.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page));
            stage.setTitle("Caja");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
