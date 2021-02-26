package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import persistencia.CitaDAO;


public class Controller {
    @FXML
    void buttomxD(ActionEvent event) {
        CitaDAO dao = new CitaDAO("hibernate.cfg.xml");
        dao.getCitas();
    }
}
