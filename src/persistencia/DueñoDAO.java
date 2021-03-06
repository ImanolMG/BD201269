package persistencia;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.service.spi.ServiceException;
import org.hibernate.transform.AliasToBeanResultTransformer;
import sun.net.ext.ExtendedSocketOptions;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DueñoDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public DueñoDAO(){
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

    public void EliminarDatos (String Nombre) throws SQLException {
        Session session = factory.openSession();
        session.beginTransaction();
        Dueño userRegister = (Dueño)session.get(Dueño.class, Nombre);

        session.delete(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public void Editar(){
        Session session = factory.openSession();
        session.beginTransaction();
        
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }

    public void GuardarDatos(String Nombre, String Direccion, String Telefono){
        Session session = factory.openSession();
        session.beginTransaction();
        Dueño userRegister = new Dueño(Nombre, Direccion, Telefono);
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }

    public List<Dueño> listaDueños(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Dueño.class);
        ProjectionList dueñosLista = Projections.projectionList();

        dueñosLista.add(Projections.property("Nombre"), "Nombre");
        dueñosLista.add(Projections.property("Direccion"), "Direccion");
        dueñosLista.add(Projections.property("Telefono"), "Telefono");
        criteria.setProjection(dueñosLista);

        List<Dueño> dueño = new ArrayList<>();
        List dueñoList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Dueño.class)).list();

        int i =0;
        for(Iterator iterator = dueñoList.iterator(); iterator.hasNext();){
            dueño.add((Dueño) iterator.next());
            i++;
        }
        return dueño;
    }

}
