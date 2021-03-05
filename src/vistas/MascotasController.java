package vistas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistencia.Dueño;
import persistencia.DueñoDAO;
import persistencia.Mascota;
import persistencia.MascotaDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MascotasController implements Initializable {


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
    private TextField idIdDueño;
    @FXML
    private TextField idRazon;

    @FXML
    private ComboBox<Dueño> cmbDueño;

    @FXML
    private ComboBox<Mascota> cmbTipoMascota;

    @FXML private DatePicker dtpkrFechaIngreso;

    @FXML
    private ComboBox<Mascota> cmbSexo;


    @FXML
    private TableView<Mascota> tblListaMascotas;
    @FXML
    private TableColumn<Mascota, String> clmnNombreMascota;
    @FXML
    private TableColumn<Mascota, String> clmnTipoMascota;
    @FXML
    private TableColumn<Mascota, String> clmnFechaIngreso;
    @FXML
    private TableColumn<Mascota, Number> clmnIdDueño;
    @FXML
    private TableColumn<Mascota, String> clmnNombreDueño;
    @FXML
    private TableColumn<Mascota, String> clmSexoMascota;
    @FXML
    private TableColumn<Mascota, String> clmnMotivoRazon;



    private ObservableList<Mascota> olListaMascotas;

    private MascotaDAO mascotaDAO;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        olListaMascotas = FXCollections.observableArrayList();
        mascotaDAO = new MascotaDAO();
       olListaMascotas.addAll(mascotaDAO.listaMascotas());
        tblListaMascotas.setItems(olListaMascotas);

        clmnNombreMascota.setCellValueFactory(tf -> tf.getValue().nombre());
clmnIdDueño.setCellValueFactory(tf -> tf.getValue().IdDueño());
clmnNombreDueño.setCellValueFactory(tf -> tf.getValue().NombreDueño());
clmnTipoMascota.setCellValueFactory(tf -> tf.getValue().tipoMascota());
clmnFechaIngreso.setCellValueFactory(tf -> tf.getValue().fechaIngreso().asString());
clmSexoMascota.setCellValueFactory(tf -> tf.getValue().sexo());
clmnMotivoRazon.setCellValueFactory(tf -> tf.getValue().motivo());

        gestionDeEventos();
    }



    public void gestionDeEventos() {
        tblListaMascotas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mascota>() {

            @Override
            public void changed(ObservableValue<? extends Mascota> observableValue, Mascota valorAnterior, Mascota valorNuevo) {
                if(valorNuevo!=null) {


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
