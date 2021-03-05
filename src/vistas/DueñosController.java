package vistas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import persistencia.Dueño;
import persistencia.DueñoDAO;

import java.math.BigInteger;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DueñosController implements Initializable {
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
    private TableView<Dueño> tblListaDueños;

    @FXML
    private TableColumn<Dueño, String> clmnNombre;
    @FXML
    private TableColumn<Dueño, String> clmnDireccion;
    @FXML
    private TableColumn<Dueño, String> clmnTelefono;



    private ObservableList<Dueño> olListaDueños ;

private DueñoDAO dueñoDAO;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        olListaDueños = FXCollections.observableArrayList();

            dueñoDAO = new DueñoDAO();
            olListaDueños.addAll(dueñoDAO.listaDueños());
            tblListaDueños.setItems(olListaDueños);
            clmnNombre.setCellValueFactory(tf -> tf.getValue().nombre());
            clmnDireccion.setCellValueFactory(tf -> tf.getValue().direccion());
            clmnTelefono.setCellValueFactory(tf -> tf.getValue().telefono());
            gestionDeEventos();



    }


    @FXML
    public void BtnGuardar(){
        DueñoDAO dao = new DueñoDAO();

        dao.GuardarDatos(idNombre.getText(), idDireccion.getText(), idTelefono.getText());
        gestionDeEventos();
    }

    @FXML
    public void btnNuevo() {
        idNombre.setText("");
        idDireccion.setText("");
        idTelefono.setText("");
gestionDeEventos();
    }



    public void gestionDeEventos() {

        tblListaDueños.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dueño>() {

            @Override
            public void changed(ObservableValue<? extends Dueño> observableValue, Dueño valorAnterior, Dueño valorNuevo) {
                if(valorNuevo!=null)
                    idNombre.setText(valorNuevo.getNombre());
                idDireccion.setText(valorNuevo.getDireccion());
                idTelefono.setText(valorNuevo.getTelefono());

            }
        });
    }



}

