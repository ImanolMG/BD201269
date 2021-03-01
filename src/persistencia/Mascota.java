package persistencia;

import java.io.Serializable;

public class Mascota implements Serializable {

    private Integer IdMascota;
    private String TipoMascota;
    private String Nombre;
    private String FechaIngreso;
    private Integer IdDueño;
    private String Sexo;
    private String Motivo;
    private Mascota mascota;

    public Mascota(){
    }
    public Mascota(String TipoMascota, String Nombre, String FechaIngreso, Integer IdDueño, String Sexo, String Motivo) {
        this.TipoMascota = TipoMascota;
        this.Nombre = Nombre;
        this.FechaIngreso = FechaIngreso;
        this.IdDueño = IdDueño;
        this.Sexo = Sexo;
        this.Motivo = Motivo;
    }


    public Integer getId() {
        return IdMascota;
    }
    public void setId(Integer IdMascota) {
        this.IdMascota = IdMascota;
    }

    public String getTipoMascota() {
        return TipoMascota;
    }
    public void setTipoMascota(String tipoMascota) {
        this.TipoMascota = TipoMascota;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }
    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public Integer getIdDueño() {
        return IdDueño;
    }
    public void setIdDueño(Integer IdDueño) {
        this.IdDueño = IdDueño;
    }

    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getMotivo() {
        return Motivo;
    }
    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
    public Mascota getMascota(){
        return mascota;
    }
}
