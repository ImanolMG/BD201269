package persistencia;

import javafx.beans.property.*;

import java.io.Serializable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Mascota implements Serializable {

    private final IntegerProperty idMascota = new SimpleIntegerProperty();
    private final  StringProperty TipoMascota = new SimpleStringProperty();
    private final StringProperty Nombre = new SimpleStringProperty();
    private final ObjectProperty<Date> FechaIngreso = new SimpleObjectProperty<>();
    private final StringProperty NombreDueño = new SimpleStringProperty();
    private final StringProperty Sexo = new SimpleStringProperty();
    private final StringProperty Motivo = new SimpleStringProperty();
    private Mascota mascota;
    private Dueño dueño;

    public Mascota(){

    }

    public Mascota( String TipoMascota, String Nombre, Date FechaIngreso, String NombreDueño, String Sexo, String Motivo, Integer idMascota) {

        this.TipoMascota.set(TipoMascota);
        this.Nombre.set(Nombre);
        this.FechaIngreso.set(FechaIngreso);
        this.idMascota.set(idMascota);
        this.NombreDueño.set(NombreDueño);
        this.Sexo.set(Sexo);
        this.Motivo.set(Motivo);

    }


    public Integer getIdMascota() {
        return idMascota.get();
    }
    public void setIdMascota(Integer idMascota) {
        this.idMascota.set(idMascota);
    }
    public IntegerProperty idMascota(){
        return idMascota;
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


    public  Date getFechaIngreso(){
        return FechaIngreso.get();
    }
    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso.set(FechaIngreso);
    }
    public ObjectProperty<Date> fechaIngreso(){
        return FechaIngreso;
    }

    public String getNombreDueño() {
        return NombreDueño.get();
    }
    public void setNombreDueño(String NombreDueño) {
        this.NombreDueño.set(NombreDueño);
    }
    public StringProperty NombreDueño(){
        return NombreDueño;
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

    public Dueño getDueño(){
    return dueño;
    }

    public void setCiudad(Dueño dueño) {
        this.dueño = dueño;
    }





}
