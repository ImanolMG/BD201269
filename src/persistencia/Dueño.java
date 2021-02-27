package persistencia;

import java.io.Serializable;

public class Dueño implements Serializable {

    private Integer IdDueño;
    private String Nombre;
    private String Direccion;
    private Integer Telefono;
    private Dueño dueño;
    public Dueño() {
    }

    public Dueño(Integer IdDueño, String Nombre,String Direccion,Integer Telefono) {
        this.IdDueño = IdDueño;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }
    public void setId(Integer IdDueño){
        this.IdDueño = IdDueño;
    }
    public Integer getId(){
        return IdDueño;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String getNombre(){
        return Nombre;
    }

    public void setDireccion(String Direccion){
        this.Direccion=Direccion;
    }
    public String getDireccion(){
        return Direccion;
    }

    public void setTelefono(Integer Telefono){
        this.Telefono=Telefono;
    }
    public Integer getTelefono(){
        return Telefono;
    }


    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    public Dueño getDueño() {
        return dueño;
    }
}
