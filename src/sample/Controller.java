package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import persistencia.CitaDAO;
import persistencia.DueñoDAO;
import persistencia.MascotaDAO;
import persistencia.MedicamentoDAO;


public class Controller {
    @FXML
    void buttomxD(ActionEvent event) {

        CitaDAO dao = new CitaDAO("hibernate.cfg.xml");
        dao.getCitas();
        DueñoDAO daa = new DueñoDAO("hibernate.cfg.xml");
        daa.getDueños();
        MascotaDAO dai = new MascotaDAO("hibernate.cfg.xml");
        dai.getMascotas();
        MedicamentoDAO dau = new MedicamentoDAO("hibernate.cfg.xml");
        dau.getMedicamentos();
    }
}
