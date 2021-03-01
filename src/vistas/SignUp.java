package vistas;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistencia.UsuariosDAO;

public class SignUp {

    @FXML
    private Button btnCancelar;
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idUsuario;
    @FXML
    private TextField idContraseña;




    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void RegistrarUsuario(ActionEvent event){
        UsuariosDAO dao = new UsuariosDAO();
        dao.RegistrarUsuarios(idNombre.getText(), idUsuario.getText(), idContraseña.getText());
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
