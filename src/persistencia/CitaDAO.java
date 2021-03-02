package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.*;

public class CitaDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public CitaDAO() {
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

    public void BusquedaDueño(String NombreDueño){
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Dueño where Nombre="+NombreDueño).list();

        System.out.println("Codigo \t Nombre_Medicamento \t Caducidad \t Sustancia_Activa");
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            Dueño dao = (Dueño) iterator.next();
            System.out.println(dao.getNombre());
        }
    }

}
