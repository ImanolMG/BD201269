package vistas;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persistencia.DueñoDAO;

import java.math.BigInteger;

public class DueñosController {
    @FXML
    private Button idNew;
    @FXML
    private Button idGuardar;
    @FXML
    private Button idEditar;
    @FXML
    private Button idEliminar;
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idDireccion;
    @FXML
    private TextField idTelefono;


    @FXML
    public void BtnGuardar(Event event){
        DueñoDAO dao = new DueñoDAO();

        dao.GuardarDatos(idNombre.getText(), idDireccion.getText(), idTelefono.getText());
    }

}
