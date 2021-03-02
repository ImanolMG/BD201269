package vistas;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persistencia.CitaDAO;

public class CitasController {
    @FXML
    private TextField idNombreDueño;
    @FXML
    private Button idBuscarDueño;

    @FXML
    public void BtnBusqueda(Event event){
        CitaDAO daoCita = new CitaDAO();
        daoCita.BusquedaDueño(idNombreDueño.getText());
    }

}
