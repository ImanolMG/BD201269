package vistas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistencia.Dueño;
import persistencia.DueñoDAO;

import java.io.IOException;
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
        olListaDueños = FXCollections.observableArrayList();



     dao.GuardarDatos(idNombre.getText(), idDireccion.getText(), idTelefono.getText());

     Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("El dueño se a registrado exitosamente :D");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

     olListaDueños.addAll(dao.listaDueños());
     tblListaDueños.setItems(olListaDueños);
    }

    @FXML
    public void BtnDelete(Event event) throws SQLException {
        DueñoDAO dao = new DueñoDAO();
        dao.EliminarDatos(idNombre.getText(),idDireccion.getText(), idTelefono.getText());
    }

    @FXML
    public void btnNuevo() {
        idNombre.setText("");
        idDireccion.setText("");



        idTelefono.setText("");
    }



    public void gestionDeEventos() {
        tblListaDueños.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dueño>() {

            @Override
            public void changed(ObservableValue<? extends Dueño> observableValue, Dueño valorAnterior, Dueño valorNuevo) {
                if(valorNuevo!=null) {
                    idNombre.setText(valorNuevo.getNombre());
                    idDireccion.setText(valorNuevo.getDireccion());
                    idTelefono.setText(valorNuevo.getTelefono());
                }
            }
        });



    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        cargarMenuprincipal();



    }



    public void cargarMenuprincipal() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page, 600, 400));
            stage.setTitle("Menu Principal");
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

