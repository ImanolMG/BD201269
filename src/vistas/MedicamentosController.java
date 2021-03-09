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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import persistencia.Dueño;
import persistencia.DueñoDAO;
import persistencia.MedicamentoDAO;
import persistencia.Medicamento;


public class MedicamentosController implements Initializable {
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
    private TableColumn<Medicamento, Number> clmnCodigo;
    @FXML
    private TableColumn<Medicamento, String> clmnNombreM;
    @FXML
    private TableColumn<Medicamento, LocalDate> clmnCaducidad;
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
        clmnCodigo.setCellValueFactory(tf -> tf.getValue().codigo());
        clmnNombreM.setCellValueFactory(tf -> tf.getValue().nombreMedicamento());
        clmnCaducidad.setCellValueFactory(cellData -> cellData.getValue().caducidad());
        clmnSustancia.setCellValueFactory(tf -> tf.getValue().sustanciaActiva());
        gestionDeEventos();
    }

    public void gestionDeEventos() {
        tableMedica.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Medicamento>() {
            @Override
            public void changed(ObservableValue<? extends Medicamento> observableValue, Medicamento valorAnterior, Medicamento valorNuevo) {
                if(valorNuevo!=null) {
                    idCodigoM.setText(String.valueOf(valorNuevo.getCodigo()));
                    idNombreM.setText(valorNuevo.getNombreMedicamento());
                    idSustanciaM.setText(valorNuevo.getSustanciaActiva());
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
}
