package vistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        boolean evaluarInicio = false;
        UsuariosDAO view = new UsuariosDAO();
        view.BuscarUsuario(idUser.getText(),idPass.getText());
        evaluarInicio = view.BuscarUsuario(idUser.getText(),idPass.getText());
        if(evaluarInicio==false){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "No se pudo iniciar la sesion",JOptionPane.WARNING_MESSAGE);
        }
    }

@FXML
    public void handlerVistaSignUp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
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
