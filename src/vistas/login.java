package vistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistencia.Usuarios;
import persistencia.UsuariosDAO;
import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class login {
    @FXML
    private TextField idUser;
    @FXML
    private PasswordField idPass;
    @FXML
    private Button btnLogin;
    @FXML
    private  Button btnSignUp;
    UsuariosDAO view = new UsuariosDAO();

    @FXML
    void ButtonLogin(ActionEvent event){
        boolean evaluarInicio = view.BuscarUsuario(idUser.getText(),idPass.getText());
        System.out.println(evaluarInicio);

        if(evaluarInicio){
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Error al iniciar session");
            mensaje.setContentText("Usuario o contraseña incorrectos");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
        else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
                AnchorPane page = (AnchorPane) loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(page));
                stage.setTitle("Menu");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void handlerVistaSignUp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page));
            stage.setTitle("Registrarse");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
