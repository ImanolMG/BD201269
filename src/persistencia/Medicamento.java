package persistencia;

import java.io.Serializable;

public class Medicamento implements Serializable {

    private Integer Codigo;
    private String NombreMedicamento;
    private String SustanciaActiva;
    private String Caducidad;

    public Medicamento(Integer codigo, String nombreMedicamento, String sustanciaActiva, String caducidad) {
        Codigo = codigo;
        NombreMedicamento = nombreMedicamento;
        SustanciaActiva = sustanciaActiva;
        Caducidad = caducidad;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public Medicamento setCodigo(Integer codigo) {
        Codigo = codigo;
        return this;
    }

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public Medicamento setNombreMedicamento(String nombreMedicamento) {
        NombreMedicamento = nombreMedicamento;
        return this;
    }

    public String getSustanciaActiva() {
        return SustanciaActiva;
    }

    public Medicamento setSustanciaActiva(String sustanciaActiva) {
        SustanciaActiva = sustanciaActiva;
        return this;
    }

    public String getCaducidad() {
        return Caducidad;
    }

    public Medicamento setCaducidad(String caducidad) {
        Caducidad = caducidad;
        return this;
    }
}
