package persistencia;

public class Mascota {

    private Integer IdMascota;
    private String TipoMascota;
    private String Nombre;
    private String FechaIngreso;
    private Integer IdDueño;
    private String Sexo;
    private String Motivo;


    public Mascota(Integer idMascota, String tipoMascota, String nombre, String fechaIngreso, Integer idDueño, String sexo, String motivo) {
        IdMascota = idMascota;
        TipoMascota = tipoMascota;
        Nombre = nombre;
        FechaIngreso = fechaIngreso;
        IdDueño = idDueño;
        Sexo = sexo;
        Motivo = motivo;
    }


    public Integer getIdMascota() {
        return IdMascota;
    }

    public Mascota setIdMascota(Integer idMascota) {
        IdMascota = idMascota;
        return this;
    }

    public String getTipoMascota() {
        return TipoMascota;
    }

    public Mascota setTipoMascota(String tipoMascota) {
        TipoMascota = tipoMascota;
        return this;
    }

    public String getNombre() {
        return Nombre;
    }

    public Mascota setNombre(String nombre) {
        Nombre = nombre;
        return this;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public Mascota setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
        return this;
    }

    public Integer getIdDueño() {
        return IdDueño;
    }

    public Mascota setIdDueño(Integer idDueño) {
        IdDueño = idDueño;
        return this;
    }

    public String getSexo() {
        return Sexo;
    }

    public Mascota setSexo(String sexo) {
        Sexo = sexo;
        return this;
    }

    public String getMotivo() {
        return Motivo;
    }

    public Mascota setMotivo(String motivo) {
        Motivo = motivo;
        return this;
    }
}
