package persistencia;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DueñoDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public DueñoDAO(){
        System.err.println("Iniciando conexion");
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



    public void EliminarDatos (Integer id){
        Session session = factory.openSession();
        session.beginTransaction();

        Dueño userRegister_ImanStringProperty_CriteriaUpdate;
        Dueño userRegister = (Dueño)session.get(Dueño.class, id);
        session.delete(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public void EditarDatos(Integer id, String nombre, String direccion, String telefono){
        Session session = factory.openSession();
        session.beginTransaction();

        Dueño userRegister = (Dueño)session.get(Dueño.class, id);

        userRegister.setNombre(nombre);
        userRegister.setDireccion(direccion);
        userRegister.setTelefono(telefono);
        session.update(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public void GuardarDatos(String Nombre, String Direccion, String Telefono){
        Session session = factory.openSession();
        session.beginTransaction();
        Dueño userRegister = new Dueño(0,Nombre, Direccion, Telefono);
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }

    public List<Dueño> listaDueños(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Dueño.class);
        ProjectionList dueñosLista = Projections.projectionList();
        
        dueñosLista.add(Projections.property("idDueño"),"idDueño");
        dueñosLista.add(Projections.property("Nombre"), "Nombre");
        dueñosLista.add(Projections.property("Direccion"), "Direccion");
        dueñosLista.add(Projections.property("Telefono"), "Telefono");
        criteria.setProjection(dueñosLista);

        List<Dueño> dueño = new ArrayList<>();
        List<Dueño> dueñoList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Dueño.class)).list();

        int i =0;
        for(Iterator iterator = dueñoList.iterator(); iterator.hasNext();){
            dueño.add((Dueño) iterator.next());
            i++;
        }
        return dueño;
    }

    public List<Dueño> listaNombreDeDueños() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Dueño.class);
        ProjectionList nombreDueñosLista = Projections.projectionList();

        nombreDueñosLista.add(Projections.property("Nombre"), "Nombre");

        criteria.setProjection(nombreDueñosLista);

        List<Dueño> dueños = new ArrayList<>();
        List dueñosNombresList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Dueño.class)).list();

        int i =0;
        for(Iterator iterator = dueñosNombresList.iterator(); iterator.hasNext();){
            dueños.add((Dueño) iterator.next());
            i++;
        }
        return dueños;
    }


}
