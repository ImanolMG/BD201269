package persistencia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.math.BigInteger;

public class Dueño implements Serializable {

    private IntegerProperty IdDueño;
    private StringProperty Nombre;
    private StringProperty Direccion;
    private StringProperty Telefono;
    private Dueño dueño;

    public Dueño() {
    }

    public Dueño(String Nombre,String Direccion,String Telefono) {
        this.Nombre = new SimpleStringProperty(Nombre);;
        this.Direccion = new SimpleStringProperty(Direccion);
        this.Telefono = new SimpleStringProperty(Telefono);
    }

    public String getNombre(){
        return Nombre.get();
    }

    public void setNombre(String Nombre ){
        this.Nombre = new SimpleStringProperty(Nombre);
    }


    public String getDireccion(){
        return Direccion.get();
    }

    public void setDireccion(String Direccion ){
        this.Direccion = new SimpleStringProperty(Direccion);
    }

    public String getTelefono(){
        return Telefono.get();
    }

    public void setTelefono(String Telefono ){
        this.Telefono = new SimpleStringProperty(Telefono);
    }



    public Integer getId(){
        return IdDueño.get();
    }
    public void setIdDueño(Integer IdDueño ){
        this.IdDueño = new SimpleIntegerProperty(IdDueño);
    }





    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    public Dueño getDueño() {
        return dueño;
    }
}
