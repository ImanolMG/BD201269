package vistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import persistencia.Usuarios;
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
    UsuariosDAO view = new UsuariosDAO();

    @FXML
    void ButtonLogin(ActionEvent event){
        boolean evaluarInicio = false;
        UsuariosDAO view = new UsuariosDAO();
        view.BuscarUsuario(idUser.getText(),idPass.getText());
        evaluarInicio = view.BuscarUsuario(idUser.getText(),idPass.getText());
        if(evaluarInicio==false){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "No se puedo iniciar la sesion",JOptionPane.WARNING_MESSAGE);
        }
    }
}
