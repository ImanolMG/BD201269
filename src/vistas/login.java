package vistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import persistencia.UsuariosDAO;
import javax.swing.*;
import java.util.*;

public class login {
    @FXML
    private TextField idUser;
    @FXML
    private PasswordField idPass;
    @FXML
    private Button btnLogin;

    @FXML
    void ButtonLogin(ActionEvent event){
        UsuariosDAO view = new UsuariosDAO();
        view.BuscarUsuario(idUser.getText(),idPass.getText());
    }
}
