package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.math.BigInteger;
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

    public void GuardarDatos(String Nombre, String Direccion, BigInteger Telefono){
        Session session = factory.openSession();
        session.beginTransaction();

        Dueño userRegister = new Dueño(Nombre, Direccion, Telefono);
        session.save(userRegister);

        session.getTransaction().commit();
    }



}
