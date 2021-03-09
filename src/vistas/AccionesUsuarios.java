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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistencia.DueñoDAO;
import persistencia.Usuarios;
import persistencia.UsuariosDAO;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class AccionesUsuarios implements Initializable {
    @FXML
    private Button idNew;
    @FXML
    private Button idGuardar;
    @FXML
    private Button idEditar;
    @FXML
    private Button idEliminar;
    @FXML
    private TextField idIDUSER;
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idUsuario;
    @FXML
    private TextField idContraseña;
    @FXML
    private TableView<Usuarios> tableUsuarios;
    @FXML
    private TableColumn<Usuarios, Number> IdUsuario;
    @FXML
    private TableColumn<Usuarios, String> Nombre;
    @FXML
    private TableColumn<Usuarios, String> Usuario;
    @FXML
    private TableColumn<Usuarios, String> Contraseña;

    private ObservableList<Usuarios> odserbListUser ;
    private UsuariosDAO usuariosDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        odserbListUser = FXCollections.observableArrayList();
        usuariosDAO = new UsuariosDAO();
        odserbListUser.addAll(usuariosDAO.listaUsuarios());
        tableUsuarios.setItems(odserbListUser);
        IdUsuario.setCellValueFactory(tf -> tf.getValue().IdUsuario());
        Nombre.setCellValueFactory(tf -> tf.getValue().nombreCompleto());
        Usuario.setCellValueFactory(tf -> tf.getValue().usuario());
        Contraseña.setCellValueFactory(tf -> tf.getValue().contraseña());
        gestionDeEventos();
    }

    public void gestionDeEventos() {
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuarios>() {
            @Override
            public void changed(ObservableValue<? extends Usuarios> observableValue, Usuarios valorAnterior, Usuarios valorNuevo) {
                if(valorNuevo!=null) {
                    idIDUSER.setText(String.valueOf(valorNuevo.getIdUsuario()));
                    idNombre.setText(valorNuevo.getNombreCompleto());
                    idUsuario.setText(valorNuevo.getUsuario());
                    idContraseña.setText(valorNuevo.getContraseña());
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

    @FXML
    public void BtnDelete(Event event){
        UsuariosDAO dao = new UsuariosDAO();
        odserbListUser = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIDUSER.getText());
        dao.EliminarDatos(id);

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha eliminado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        odserbListUser.addAll(dao.listaUsuarios());
        tableUsuarios.setItems(odserbListUser);
        btnNuevo();
    }

    @FXML
    public void BtnSave(){
        UsuariosDAO dao = new UsuariosDAO();
        odserbListUser = FXCollections.observableArrayList();

        dao.GuardarDatos(idNombre.getText(), idUsuario.getText(), idContraseña.getText());

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("El dueño se a registrado exitosamente :D");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        odserbListUser.addAll(dao.listaUsuarios());
        tableUsuarios.setItems(odserbListUser);
        btnNuevo();
    }

    @FXML
    public void BtnEditar(){
        UsuariosDAO dao = new UsuariosDAO();
        odserbListUser = FXCollections.observableArrayList();
        Integer id = Integer.parseInt(idIDUSER.getText());

        dao.EditarDatos(id, idNombre.getText(), idUsuario.getText(), idContraseña.getText());

        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Registro exitoso");
        mensaje.setContentText("Se ha modificado el registro exitosamente");
        mensaje.setHeaderText("Resultado:");
        mensaje.show();

        odserbListUser.addAll(dao.listaUsuarios());
        tableUsuarios.setItems(odserbListUser);
        btnNuevo();
    }

    @FXML
    public void btnNuevo() {
        idIDUSER.setText("");
        idNombre.setText("");
        idUsuario.setText("");
        idContraseña.setText("");
    }
}
