package persistencia;

import java.io.Serializable;

public class Cita implements Serializable {

    private Integer idCita;
    private String NombreMascota;
    private String Fecha;
    private String Servicio;
    private Cita cita;

    public Cita() {
    }

    public Cita(String NombreMascota,String Fecha,String Servicio) {
        this.NombreMascota=NombreMascota;
        this.Fecha=Fecha;
        this.Servicio=Servicio;
    }

    public void setId(Integer idCita){
        this.idCita=idCita;
    }
    public Integer getId(){
        return idCita;
    }

    public void setNombreMascota(String NombreMascota){
        this.NombreMascota=NombreMascota;
    }
    public String getNombreMascota(){
        return NombreMascota;
    }

    public void setFecha(String Fecha){
        this.Fecha=Fecha;
    }
    public String getFecha(){
        return Fecha;
    }

    public void setServicio(String Servicio){this.Servicio=Servicio;}
    public String getServicio(){
        return Servicio;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
    public Cita getCita() {
        return cita;
    }

}

