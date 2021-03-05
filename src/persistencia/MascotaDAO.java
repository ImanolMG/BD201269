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

    public Mascota listaMascotas() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Mascota.class);
        ProjectionList mascotasLista = Projections.projectionList();

        mascotasLista.add(Projections.property("Nombre"), "Nombre");
        mascotasLista.add(Projections.property("Direccion"), "Direccion");
        mascotasLista.add(Projections.property("Telefono"), "Telefono");

        criteria.setProjection(mascotasLista);
        criteria.setResultTransformer(new AliasToBeanResultTransformer(Dueño.class));
        Mascota mascota = (Mascota) criteria.list().get(0);
        return mascota;

    }

}
