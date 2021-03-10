package persistencia;

import javafx.beans.property.*;

import java.time.chrono.Chronology;
import java.io.Serializable;
import java.util.Date;

public class Medicamento implements Serializable {
    private final IntegerProperty Codigo = new SimpleIntegerProperty();
    private final StringProperty NombreMedicamento = new SimpleStringProperty();
    private final StringProperty SustanciaActiva = new SimpleStringProperty();
    private final ObjectProperty<Date> Caducidad = new SimpleObjectProperty<>();
    private Medicamento medicamento;

    public Medicamento(){}

    public Medicamento(Integer Codigo, String NombreMedicamento, String SustanciaActiva, Date Caducidad) {
        this.Codigo.set(Codigo);
        this.NombreMedicamento.set(NombreMedicamento);
        this.SustanciaActiva.set(SustanciaActiva);
        this.Caducidad.set(Caducidad);
    }

    public Integer getCodigo() {
        return Codigo.get();
    }
    public void setCodigo(Integer Codigo) {
        this.Codigo.set(Codigo);
    }
    public IntegerProperty codigo(){
        return Codigo;
    }

    public String getNombreMedicamento(){
        return NombreMedicamento.get();
    }
    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento.set(NombreMedicamento);
    }
    public StringProperty nombreMedicamento(){ return NombreMedicamento;}

    public String getSustanciaActiva() {
        return SustanciaActiva.get();
    }
    public void setSustanciaActiva(String SustanciaActiva) {
        this.SustanciaActiva.set(SustanciaActiva);
    }
    public StringProperty sustanciaActiva(){ return SustanciaActiva;}

    public Date getCaducidad() {
        return Caducidad.get();
    }
    public void setCaducidad(Date Caducidad) {
        this.Caducidad.set(Caducidad);
    }
    public ObjectProperty<Date> caducidad(){
        return Caducidad;
    }

    public void setMedicamento(Medicamento Medicamento){
        this.medicamento = medicamento;
    }
    public Medicamento getMedicamento(){
        return medicamento;
    }
}
