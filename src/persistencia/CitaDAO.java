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

    public CitaDAO(String conection) {
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

    public void getCitas() {
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Cita").list();

        System.out.println("IdCita \t Nombre Mascota \t Fecha \t Servicio");
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            Cita dao = (Cita) iterator.next();
            System.out.println( dao.getId()+ "\t" + dao.getNombreMascota()+"\t" + dao.getFecha() +"\t"+ dao.getServicio());
        }
    }
}
