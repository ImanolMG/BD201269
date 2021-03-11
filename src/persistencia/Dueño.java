package persistencia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

public class Dueño implements Serializable {

    private final IntegerProperty idDueño = new SimpleIntegerProperty();
    private final StringProperty Nombre = new SimpleStringProperty();
    private final StringProperty Direccion = new SimpleStringProperty();
    private final StringProperty Telefono = new SimpleStringProperty();
    private Dueño dueño;

    public Dueño(){
    }

    public Dueño(Integer idDueño, String Nombre,String Direccion,String Telefono) {
        this.idDueño.set(idDueño);
        this.Nombre.set(Nombre);
        this.Direccion.set(Direccion);
        this.Telefono.set(Telefono);
    }

    public void setIdDueño(Integer IdDueño){
        this.idDueño.set(IdDueño);
    }
    public Integer getIdDueño(){
        return idDueño.get();
    }
    public IntegerProperty idDueño(){
        return idDueño;
    }


    public void setNombre(String Nombre){
        this.Nombre.set(Nombre);
    }
    public String getNombre(){
        return Nombre.get();
    }
    public StringProperty nombre(){
        return Nombre;
    }


    public void setDireccion(String Direccion){
        this.Direccion.set(Direccion);
    }
    public String getDireccion(){
        return Direccion.get();
    }

    public StringProperty direccion(){
        return Direccion;
    }

    public void setTelefono(String Telefono){
        this.Telefono.set(Telefono);
    }
    public String getTelefono(){
        return Telefono.get();
    }

    public StringProperty telefono(){
        return Telefono;
    }


    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    public Dueño getDueño() {
        return dueño;
    }

}
