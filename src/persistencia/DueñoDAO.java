package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.*;

public class DueñoDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public DueñoDAO(String conection) {
        System.err.println("Iniciando conexionn");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure(conection);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void getDueños() {
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Dueño").list();

        System.out.println("IdDueño \t Nombre_Dueño \t Direccion \t Telefono");
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            Dueño dao = (Dueño) iterator.next();
            System.out.println( dao.getId()+ "\t\t"+dao.getNombre()+"\t\t" + dao.getDireccion() +"\t"+ dao.getTelefono());
        }
    }
}
