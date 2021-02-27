package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Iterator;
import java.util.List;

public class MascotaDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public MascotaDAO(String conection) {
        System.err.println("Iniciando conexionn");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure(conection);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void getMascotas(){
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Mascota").list();

        System.out.println("IdMascota \t Nombre \t Tipo \t Dueño\t Sexo \t Fecha Ingreso");
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            Mascota dao = (Mascota) iterator.next();
            System.out.println( dao.getId()+ "\t\t" + dao.getNombre()+"\t\t" + dao.getTipoMascota() +"\t"+ dao.getIdDueño()+"\t"+dao.getSexo()+"\t"+dao.getFechaIngreso());
        }
    }


}
