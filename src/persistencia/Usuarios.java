package persistencia;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private Integer Id;
    private String Name;
    private String User;
    private String Password;
    private Usuarios usuarios;

    public Usuarios(){}

    public Usuarios(String Name, String User, String Password){
        this.Name = Name;
        this.User =  User;
        this.Password = Password;
    }

    public void setId(Integer Id){
        this.Id = Id;
    }
    public Integer getId(){
        return Id;
    }

    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }

    public void setUser(String User){
        this.User = User;
    }
    public String getUser(){
        return User;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getPassword(){
        return Password;
    }

    public void setUsuarios(Usuarios usuarios){
        this.usuarios = usuarios;
    }
    public Usuarios getUsuarios() {
        return usuarios;
    }
}
