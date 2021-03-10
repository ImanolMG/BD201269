package vistas;

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
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;

import persistencia.*;


public class MedicamentosController implements Initializable {
    @FXML
    private Button idNuevo;
    @FXML
    private Button idGuardar;
    @FXML
    private Button idEliminar;
    @FXML
    private Button idActualizar;
    @FXML
    private TextField idIDMed;
    @FXML
    private TextField idCodigoM;
    @FXML
    private TextField idNombreM;
    @FXML
    private TextField idSustanciaM;
    @FXML
    private DatePicker idCaducidadM;
    @FXML
    private TableView<Medicamento> tableMedica;
    @FXML
    private TableColumn<Medicamento, Number> clmnId;
    @FXML
    private TableColumn<Medicamento, Number> clmnCodigo;
    @FXML
    private TableColumn<Medicamento, String> clmnNombreM;
    @FXML
    private TableColumn<Medicamento, Date> clmnCaducidad;
    @FXML
    private TableColumn<Medicamento, String> clmnSustancia;




    private ObservableList<Medicamento> olListaMedicamentos ;
    private MedicamentoDAO medicaDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        olListaMedicamentos = FXCollections.observableArrayList();
        medicaDAO = new MedicamentoDAO();
        olListaMedicamentos.addAll(medicaDAO.listaMedicamentos());
        tableMedica.setItems(olListaMedicamentos);
        clmnId.setCellValueFactory(tf -> tf.getValue().idMedicamento());
        clmnCodigo.setCellValueFactory(tf -> tf.getValue().codigo());
        clmnNombreM.setCellValueFactory(tf -> tf.getValue().nombreMedicamento());
        clmnCaducidad.setCellValueFactory(new PropertyValueFactory<>("Caducidad"));
        clmnSustancia.setCellValueFactory(tf -> tf.getValue().sustanciaActiva());
        gestionDeEventos();
    }

    public void gestionDeEventos() {
        tableMedica.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Medicamento>() {
            @Override
            public void changed(ObservableValue<? extends Medicamento> observableValue, Medicamento valorAnterior, Medicamento valorNuevo) {
                if(valorNuevo!=null) {
                    idIDMed.setText(String.valueOf(valorNuevo.getIdMedicamento()));
                    idCodigoM.setText(String.valueOf(valorNuevo.getCodigo()));
                    idNombreM.setText(valorNuevo.getNombreMedicamento());
                    idSustanciaM.setText(valorNuevo.getSustanciaActiva());
                    idCaducidadM.setValue(valorNuevo.getCaducidad().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                }
            }
        });
    }

    @FXML
    private void cerrarVentana(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        cargarMenuprincipal();
    }

    public void cargarMenuprincipal(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuPrincipal.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(page, 600, 400));
            stage.setTitle("Menu Principal");
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void BtnGuardar(){
        MedicamentoDAO dao = new MedicamentoDAO();
        olListaMedicamentos = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIDMed.getText());
        Integer codigo = Integer.parseInt(idCodigoM.getText());
        dao.GuardarDatos(id, codigo, idNombreM.getText(), idSustanciaM.getText(), String.valueOf(idCaducidadM.getValue()) );

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("El medicamento se a registrado exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMedicamentos.addAll(dao.listaMedicamentos());
        tableMedica.setItems(olListaMedicamentos);
        btnNuevo();
    }

    @FXML
    public void BtnEditar(){
        MedicamentoDAO daa = new MedicamentoDAO();
        olListaMedicamentos = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIDMed.getText());

        daa.EditarDatos(id,Integer.parseInt(idCodigoM.getText()), idNombreM.getText(), idSustanciaM.getText(), String.valueOf(idCaducidadM.getValue()));

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha modificado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMedicamentos.addAll(daa.listaMedicamentos());
        tableMedica.setItems(olListaMedicamentos);
        btnNuevo();
    }

    @FXML
    public void BtnDelete(Event event){
        MedicamentoDAO dao = new MedicamentoDAO();
        olListaMedicamentos = FXCollections.observableArrayList();

        dao.EliminarDatos(Integer.parseInt(idIDMed.getText()));

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha eliminado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        olListaMedicamentos.addAll(dao.listaMedicamentos());
        tableMedica.setItems(olListaMedicamentos);
        btnNuevo();
    }

    @FXML
    public void btnNuevo() {
        idCodigoM.setText("");
        idNombreM.setText("");
        idSustanciaM.setText("");
        idCaducidadM.setValue(null);
    }
}
