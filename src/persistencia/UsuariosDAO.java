package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Iterator;
import java.util.List;

public class UsuariosDAO {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public UsuariosDAO() {
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

    public void BuscarUsuario(){
        Session session = factory.openSession();
        List listaUsuarios = session.createQuery(" from Usuario").list();
        for (Iterator iterator = listaUsuarios.iterator(); iterator.hasNext();){
            Usuarios dao = (Usuarios) iterator.next();
        }
    }
}
