package persistencia;

import java.io.Serializable;

public class Dueño implements Serializable {

    private String Nombre;
    private String Direccion;
    private Integer Numero;
    private Dueño dueño;
    public Dueño() {
    }

    public Dueño(String Nombre,String Direccion,Integer Numero) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Numero = Numero;
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

    public void setNumero(Integer Numero){
        this.Numero=Numero;
    }
    public Integer getNumero(){
        return Numero;
    }


    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
    public Dueño getDueño() {
        return dueño;
    }
}
