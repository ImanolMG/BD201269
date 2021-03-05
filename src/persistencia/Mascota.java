package persistencia;

import javafx.beans.property.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


public class Mascota implements Serializable {


    private IntegerProperty IdMascota = new SimpleIntegerProperty();
    private StringProperty TipoMascota = new SimpleStringProperty();
    private StringProperty Nombre = new SimpleStringProperty();
    private ObjectProperty<LocalDateTime> FechaIngreso = new SimpleObjectProperty<>();
    private IntegerProperty IdDueño = new SimpleIntegerProperty();
    private StringProperty Sexo = new SimpleStringProperty();
    private StringProperty Motivo = new SimpleStringProperty();
    private Mascota mascota;



    public Mascota(){
    }



    public Mascota(String TipoMascota, String Nombre, LocalDateTime FechaIngreso, Integer IdDueño, String Sexo, String Motivo) {
        this.TipoMascota.set(TipoMascota);
        this.Nombre.set(Nombre);
        this.FechaIngreso.set(FechaIngreso);
        this.IdDueño.set(IdDueño);
        this.Sexo.set(Sexo);
        this.Motivo.set(Motivo);
    }


    public Integer getId() {
        return IdMascota.get();
    }

    public void setId(Integer IdMascota) {
        this.IdMascota.set(IdMascota);
    }


    public IntegerProperty idMascota(){
        return IdMascota;
    }



    public String getTipoMascota() {
        return TipoMascota.get();
    }

    public void setTipoMascota(String TipoMascota) {
        this.TipoMascota.set(TipoMascota);
    }

    public StringProperty tipoMascota(){
        return TipoMascota;
    }




    public String getNombre() {
        return Nombre.get();
    }
    public void setNombre(String Nombre) {
        this.Nombre.set(Nombre);
    }
    public StringProperty nombre(){
        return Nombre;
    }



    public LocalDateTime getFechaIngreso() {
        return FechaIngreso.get();
    }
    public void setFechaIngreso(LocalDateTime FechaIngreso) {
        this.FechaIngreso.set(FechaIngreso);
    }
    public ObjectProperty fechaIngreso(){
        return FechaIngreso;
    }


    public Integer getIdDueño() {
        return IdDueño.get();
    }
    public void setIdDueño(Integer IdDueño) {
        this.IdDueño.set(IdDueño);
    }


    public IntegerProperty idDueño(){
        return IdDueño;
    }




    public String getSexo() {
        return Sexo.get();
    }
    public void setSexo(String Sexo) {
        this.Sexo.set(Sexo);
    }
    public StringProperty sexo(){
        return Sexo;
    }


    public String getMotivo() {
        return Motivo.get();
    }
    public void setMotivo(String Motivo) {
        this.Motivo.set(Motivo);
    }
    public StringProperty motivo(){
        return Motivo;
    }



    public void setMascota(Mascota mascota){
        this.mascota = mascota;
    }
    public Mascota getMascota(){
        return mascota;
    }
}
