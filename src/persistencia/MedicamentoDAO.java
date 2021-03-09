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

    public MedicamentoDAO() {
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

    public List<Medicamento> listaMedicamentos(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Medicamento.class);
        ProjectionList medicamentoLista = Projections.projectionList();

        medicamentoLista.add(Projections.property("Codigo"), "Codigo");
        medicamentoLista.add(Projections.property("Nombre"), "NombreMedicamento");
        medicamentoLista.add(Projections.property("Fecha de caducidad"), "Caducidad");
        medicamentoLista.add(Projections.property("Sustancia Activa"), "SustanciaActiva");
        criteria.setProjection(medicamentoLista);

        List<Medicamento> medicamentos = new ArrayList<>();
        List medicamentoList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Medicamento.class)).list();

        int i =0;
        for(Iterator iterator = medicamentoList.iterator(); iterator.hasNext();){
            medicamentos.add((Medicamento) iterator.next());
            i++;
        }
        return medicamentos;
    }
}
