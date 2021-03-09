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

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MascotaDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public MascotaDAO() {
        System.err.println("Iniciando conexionn");
        try {
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion.");
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void GuardarDatos(String TipoMascota, String Nombre, String FechaIngreso, Mascota NombreDueño, String Sexo, String Motivo ){
        Session session = factory.openSession();
        session.beginTransaction();
        Mascota userRegister = new Mascota(TipoMascota, Nombre , Date.valueOf(FechaIngreso), String.valueOf(NombreDueño) ,Sexo, Motivo,0 );
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }


    public void EliminarDatos (Integer id){
        Session session = factory.openSession();
        session.beginTransaction();

        Mascota userRegister = (Mascota)session.get(Mascota.class, id);
        session.delete(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public List<Mascota> listaMascotas() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Mascota.class);
        ProjectionList mascotasLista = Projections.projectionList();



        mascotasLista.add(Projections.property("idMascota"), "idMascota");
        mascotasLista.add(Projections.property("TipoMascota"), "TipoMascota");
        mascotasLista.add(Projections.property("FechaIngreso"), "FechaIngreso");
        mascotasLista.add(Projections.property("Nombre"), "Nombre");
        mascotasLista.add(Projections.property("Sexo"), "Sexo");
        mascotasLista.add(Projections.property("Motivo"), "Motivo");
        mascotasLista.add(Projections.property("NombreDueño"), "NombreDueño");
        criteria.setProjection(mascotasLista);

        List<Mascota> mascotas = new ArrayList<>();
        List mascotaList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Mascota.class)).list();

        int i =0;
        for(Iterator iterator = mascotaList.iterator(); iterator.hasNext();){
            mascotas.add((Mascota) iterator.next());
            i++;
        }
        return mascotas;

    }

    public List<Mascota.DueñoLista> listaNombreDeDueños() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Mascota.DueñoLista.class);
        ProjectionList nombreDueñosLista = Projections.projectionList();

        nombreDueñosLista.add(Projections.property("Nombre"), "Nombre");

        criteria.setProjection(nombreDueñosLista);

        List<Mascota.DueñoLista> dueños = new ArrayList<>();
        List dueñosNombresList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Mascota.DueñoLista.class)).list();

        int i =0;
        for(Iterator iterator = dueñosNombresList.iterator(); iterator.hasNext();){
            dueños.add((Mascota.DueñoLista) iterator.next());
            i++;
        }
        return dueños;
    }

}
