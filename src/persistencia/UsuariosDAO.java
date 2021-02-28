package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import javax.swing.*;
import java.util.*;


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

    public void BuscarUsuario(String usuario, String contraseña){
        ArrayList<Usuarios> users = new ArrayList();
        Session session = factory.openSession();
        List listaUsuarios = session.createQuery(" from Usuarios").list();

        for (Iterator iterator = listaUsuarios.iterator(); iterator.hasNext();){
            Usuarios dau = (Usuarios) iterator.next();
        }

    }
}
