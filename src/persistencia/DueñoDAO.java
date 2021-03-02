package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DueñoDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public DueñoDAO() {
        System.err.println("Iniciando conexionn");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void GuardarDatos(String Nombre, String Direccion, String Telefono){
        Session session = factory.openSession();
        session.beginTransaction();

        Dueño userRegister = new Dueño(Nombre, Direccion, Telefono);
        session.save(userRegister);

        session.getTransaction().commit();
    }



    public List<Dueño> getAll() throws SQLException {

        List<Dueño> lista = new ArrayList<>();
        Session session = factory.openSession();
Dueño d = null;
        ResultSet rs = (ResultSet) session.createQuery("SELECT Nombre, Direccion, Telefono " +
                "FROM dueño;");

        while(rs.next()){
d = new Dueño();
d.setNombre(rs.getString("Nombre").trim());
d.setDireccion(rs.getString("Direccion").trim());
d.setTelefono(rs.getString("Telefono").trim());
lista.add(d);



        }
        return lista;
    }



}
