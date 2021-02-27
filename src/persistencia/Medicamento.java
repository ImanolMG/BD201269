package persistencia;

import java.io.Serializable;

public class Medicamento implements Serializable {

    private Integer Codigo;
    private String NombreMedicamento;
    private String SustanciaActiva;
    private String Caducidad;
    private Medicamento medicamento;

    public Medicamento(){}

    public Medicamento(Integer codigo, String nombreMedicamento, String sustanciaActiva, String caducidad) {
        Codigo = codigo;
        NombreMedicamento = nombreMedicamento;
        SustanciaActiva = sustanciaActiva;
        Caducidad = caducidad;
    }

    public Integer getId() {
        return Codigo;
    }
    public void setId(Integer Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }
    public void setNombreMedicamento(String nombreMedicamento) {
        NombreMedicamento = nombreMedicamento;
    }

    public String getSustanciaActiva() {
        return SustanciaActiva;
    }
    public void setSustanciaActiva(String sustanciaActiva) {
        SustanciaActiva = sustanciaActiva;
    }

    public String getCaducidad() {
        return Caducidad;
    }
    public void setCaducidad(String caducidad) {
        Caducidad = caducidad;
    }

    public void setMedicamento(Medicamento Medicamento){
        this.medicamento = medicamento;
    }
    public Medicamento getMedicamento(){
        return medicamento;
    }
}
