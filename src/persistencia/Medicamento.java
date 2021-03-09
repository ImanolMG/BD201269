package persistencia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

public class Medicamento implements Serializable {
    private final IntegerProperty Codigo = new SimpleIntegerProperty();
    private final StringProperty NombreMedicamento = new SimpleStringProperty();
    private final StringProperty SustanciaActiva = new SimpleStringProperty();
    private final StringProperty Caducidad = new SimpleStringProperty();
    private Medicamento medicamento;

    public Medicamento(){}

    public Medicamento(Integer Codigo, String NombreMedicamento, String SustanciaActiva, String Caducidad) {
        this.Codigo.set(Codigo);
        this.NombreMedicamento.set(NombreMedicamento);
        this.SustanciaActiva.set(SustanciaActiva);
        this.Caducidad.set(Caducidad);
    }

    public Integer getId() {
        return Codigo.get();
    }
    public void setId(Integer Codigo) {
        this.Codigo.set(Codigo);
    }
    public IntegerProperty idMedicamento(){
        return Codigo;
    }

    public String getNombreMedicamento(){
        return NombreMedicamento.get();
    }
    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento.set(NombreMedicamento);
    }
    public StringProperty NombreMedicamento(){ return NombreMedicamento;}

    public String getSustanciaActiva() {
        return SustanciaActiva.get();
    }
    public void setSustanciaActiva(String SustanciaActiva) {
        this.SustanciaActiva.set(SustanciaActiva);
    }
    public StringProperty SustanciaActiva(){ return SustanciaActiva;}

    public String getCaducidad() {
        return Caducidad.get();
    }
    public void setCaducidad(String Caducidad) {
        this.Caducidad.set(Caducidad);
    }
    public StringProperty Caducidad(){
        return Caducidad;
    }

    public void setMedicamento(Medicamento Medicamento){
        this.medicamento = medicamento;
    }
    public Medicamento getMedicamento(){
        return medicamento;
    }
}
