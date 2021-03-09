package persistencia;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;

public class Usuarios implements Serializable {

    private final IntegerProperty idUsuario = new SimpleIntegerProperty();
    private final StringProperty NombreCompleto = new SimpleStringProperty();
    private final StringProperty Usuario = new SimpleStringProperty();
    private final StringProperty Contraseña = new SimpleStringProperty();
    private Usuarios usuarios;

    public Usuarios(){}

    public Usuarios(Integer idUsuario, String NombreCompleto, String Usuario, String Contraseña){
        this.idUsuario.set(idUsuario);
        this.NombreCompleto.set(NombreCompleto);
        this.Usuario.set(Usuario);
        this.Contraseña.set(Contraseña);
    }

    public void setIdUsuario(Integer IdUsuario){
        this.idUsuario.set(IdUsuario);
    }
    public Integer getIdUsuario(){
        return idUsuario.get();
    }
    public IntegerProperty IdUsuario(){
        return idUsuario;
    }

    public void setNombreCompleto(String NombreCompleto){
        this.NombreCompleto.set(NombreCompleto);
    }
    public String getNombreCompleto(){
        return NombreCompleto.getName();
    }
    public StringProperty nombreCompleto(){
        return NombreCompleto;
    }

    public void setUsuario(String Usuario){
        this.Usuario.set(Usuario);
    }
    public String getUsuario(){
        return Usuario.get();
    }
    public StringProperty usuario(){
        return Usuario;
    }

    public void setContraseña(String Contraseña){
        this.Contraseña.set(Contraseña);
    }
    public String getContraseña(){
        return Contraseña.get();
    }
    public StringProperty contraseña(){
        return Contraseña;
    }

    public void setUsuarios(Usuarios usuarios){
        this.usuarios = usuarios;
    }
    public Usuarios getUsuarios() {
        return usuarios;
    }
}
