package persistencia;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;

import java.util.Iterator;
import java.util.*;

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

    public Medicamento getMedicamentos(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Mascota.class);
        ProjectionList medicamentoLista = Projections.projectionList();

        medicamentoLista.add(Projections.property("Codigo"), "Codigo");
        medicamentoLista.add(Projections.property("NombreMedicamento"), "NombreMedicamento");
        medicamentoLista.add(Projections.property("SustanciaActiva"), "SustanciaActiva");
        medicamentoLista.add(Projections.property("Caducidad"), "Caducidad");

        criteria.setProjection(medicamentoLista);
        criteria.setResultTransformer(new AliasToBeanResultTransformer(Medicamento.class));

        Medicamento medicamento = (Medicamento) criteria.list().get(0);
        return medicamento;
    }

}
