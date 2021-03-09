package persistencia;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.io.Serializable;
import java.util.Date;

public class Medicamento implements Serializable {
    private IntegerProperty Codigo;
    private StringProperty NombreMedicamento;
    private StringProperty SustanciaActiva;
    private ObjectProperty<LocalDate> Caducidad;
    private Medicamento medicamento;

    public Medicamento(){}

    public Medicamento(Integer Codigo, String NombreMedicamento, String SustanciaActiva, LocalDate Caducidad) {
        this.Codigo = new SimpleIntegerProperty(Codigo);
        this.NombreMedicamento= new SimpleStringProperty ( NombreMedicamento);
        this.SustanciaActiva = new SimpleStringProperty(SustanciaActiva);
        this.Caducidad= new SimpleObjectProperty<>(Caducidad);
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

    public LocalDate getCaducidad() {
        return Caducidad.get();
    }
    public void setCaducidad(LocalDate Caducidad) {
        this.Caducidad.set(Caducidad);
    }
    public ObjectProperty<LocalDate> caducidad(){
        return Caducidad;
    }

    public void setMedicamento(Medicamento Medicamento){
        this.medicamento = medicamento;
    }
    public Medicamento getMedicamento(){
        return medicamento;
    }
}
