package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import persistencia.CitaDAO;
import persistencia.DueñoDAO;


public class Controller {
    @FXML
    void buttomxD(ActionEvent event) {

        CitaDAO dao = new CitaDAO("hibernate.cfg.xml");
        dao.getCitas();
        DueñoDAO daa = new DueñoDAO("hibernate.cfg.xml");
        daa.getDueños();
    }
}
