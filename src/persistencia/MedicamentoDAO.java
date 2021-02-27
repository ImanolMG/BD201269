package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Iterator;
import java.util.List;

public class MedicamentoDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public MedicamentoDAO(String conection) {
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

    public void getMedicamentos(){
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Medicamento").list();

        System.out.println("Codigo \t Nombre_Medicamento \t Caducidad \t Sustancia_Activa");
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            Medicamento dao = (Medicamento) iterator.next();
            System.out.println( dao.getId()+ "\t\t" + dao.getNombreMedicamento()+"\t\t" + dao.getCaducidad() +"\t"+ dao.getSustanciaActiva());
        }
    }

}
