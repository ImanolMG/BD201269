package persistencia;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;



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



    public Dueño listaDueños() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Dueño.class);
        ProjectionList dueñosLista = Projections.projectionList();


            dueñosLista.add(Projections.property("Nombre"), "Nombre");
            dueñosLista.add(Projections.property("Direccion"), "Direccion");
            dueñosLista.add(Projections.property("Telefono"), "Telefono");

            criteria.setProjection(dueñosLista);
            criteria.setResultTransformer(new AliasToBeanResultTransformer(Dueño.class));



Dueño dueño = (Dueño) criteria.list().get(0);
return dueño;
    }

}
