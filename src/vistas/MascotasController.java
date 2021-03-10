package vistas;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.util.converter.LocalDateTimeStringConverter;
import persistencia.Dueño;
import persistencia.DueñoDAO;
import persistencia.Mascota;
import persistencia.MascotaDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private TextField idIdMascota;
    @FXML
    private TextField idRazon;

    @FXML
    private ComboBox<Dueño> cmbNombreDueño;

    @FXML
    private ComboBox<String> cmbTipoMascota;

    @FXML private DatePicker dtpkrFechaIngreso;
    @FXML
    private ComboBox<String> cmbSexo;
    @FXML
    private TableView<Mascota> tblListaMascotas;
    @FXML
    private TableColumn<Mascota, String> clmnNombreMascota;
    @FXML
    private TableColumn<Mascota, String> clmnTipoMascota;
    @FXML
    private TableColumn<Mascota, LocalDate> clmnFechaIngreso;
    @FXML
    private TableColumn<Mascota, Number> clmnIdMascota;
    @FXML
    private TableColumn<Mascota, String> clmnNombreDueño;
    @FXML
    private TableColumn<Mascota, String> clmSexoMascota;
    @FXML
    private TableColumn<Mascota, String> clmnMotivoRazon;



    private ObservableList<Mascota> olListaMascotas;

    private ObservableList<Dueño> olListaNombresDueños;

    private MascotaDAO mascotaDAO;
private DueñoDAO dueñoDAO;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dtpkrFechaIngreso.setValue(LocalDate.now());
        olListaMascotas = FXCollections.observableArrayList();
        olListaNombresDueños = FXCollections.observableArrayList();
        mascotaDAO = new MascotaDAO();
        dueñoDAO = new DueñoDAO();
        olListaMascotas.addAll(mascotaDAO.listaMascotas());

        olListaNombresDueños.addAll(dueñoDAO.listaNombreDeDueños());
        tblListaMascotas.setItems(olListaMascotas);
        cmbTipoMascota.getItems().addAll("REPTIL", "CANINO", "MARINO");
        cmbSexo.getItems().addAll("Macho", "Hembra");
        clmnNombreMascota.setCellValueFactory(tf -> tf.getValue().nombre());
        clmnIdMascota.setCellValueFactory(tf -> tf.getValue().idMascota());
        clmnNombreDueño.setCellValueFactory(tf -> tf.getValue().NombreDueño());
        clmnTipoMascota.setCellValueFactory(tf -> tf.getValue().tipoMascota());
        clmnFechaIngreso.setCellValueFactory(new PropertyValueFactory<>("FechaIngreso"));
        clmSexoMascota.setCellValueFactory(tf -> tf.getValue().sexo());
        clmnMotivoRazon.setCellValueFactory(tf -> tf.getValue().motivo());
        gestionDeEventos();
    }



    public void gestionDeEventos() {
        tblListaMascotas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mascota>() {
            @Override
            public void changed(ObservableValue<? extends Mascota> observableValue, Mascota valorAnterior, Mascota valorNuevo) {
                if(valorNuevo!=null) {
idIdMascota.setText(String.valueOf(valorNuevo.getIdMascota()));
          idNombre.setText(valorNuevo.getNombre());
//cmbNombreDueño.setValue(valorNuevo.getNombreDueño());

cmbTipoMascota.setValue(valorNuevo.getTipoMascota());
dtpkrFechaIngreso.setValue(valorNuevo.getFechaIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
idRazon.setText(valorNuevo.getMotivo());
cmbSexo.setValue(valorNuevo.getSexo());
                }
            }
        });



    }

   @FXML
    public void BtnGuardar(){
        MascotaDAO dao = new MascotaDAO();
        olListaMascotas = FXCollections.observableArrayList();

        dao.GuardarDatos(cmbTipoMascota.getSelectionModel().getSelectedItem(), idNombre.getText(), String.valueOf(dtpkrFechaIngreso.getValue()), cmbNombreDueño.getSelectionModel().getSelectedItem(), cmbSexo.getSelectionModel().getSelectedItem() , idRazon.getText() );

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("La Mascota se a registrado exitosamente :D");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMascotas.addAll(dao.listaMascotas());
        tblListaMascotas.setItems(olListaMascotas);
    }


    @FXML
    public void BtnEditar(Event event){
        MascotaDAO dao = new MascotaDAO();
        olListaMascotas = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIdMascota.getText());

        dao.EditarDatos(id, cmbTipoMascota.getSelectionModel().getSelectedItem(), idNombre.getText(), String.valueOf(dtpkrFechaIngreso.getValue()), cmbNombreDueño.getSelectionModel().getSelectedItem(), cmbSexo.getSelectionModel().getSelectedItem() , idRazon.getText());

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha modificado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMascotas.addAll(dao.listaMascotas());
        tblListaMascotas.setItems(olListaMascotas);
    }


    @FXML
    public void BtnDelete(Event event){
        MascotaDAO dao = new MascotaDAO();
        olListaMascotas = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIdMascota.getText());
        dao.EliminarDatos(id);

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha eliminado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMascotas.addAll(dao.listaMascotas());
        tblListaMascotas.setItems(olListaMascotas);
    }


    @FXML
    public void btnNuevo() {
        idNombre.setText("");
       idIdMascota.setText("");
       dtpkrFechaIngreso.setValue(null);
       cmbNombreDueño.setValue(null);
       cmbTipoMascota.setValue(null);
       idRazon.setText("");
       cmbSexo.setValue(null);

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
