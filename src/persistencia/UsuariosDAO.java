package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import javax.swing.*;
import java.util.*;


public class UsuariosDAO {
    public ArrayList<Usuarios> listUsers = new ArrayList();

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
        Session session = factory.openSession();
        List listaUsuarios = session.createQuery(" from Usuarios").list();
        for (Iterator iterator = listaUsuarios.iterator(); iterator.hasNext();){
            Usuarios dau = (Usuarios) iterator.next();
        }
        for(Usuarios user: listUsers){
            if(usuario== user.getUser()){
                if(contraseña== user.getPassword()){
                    JOptionPane.showMessageDialog(null, "BIENVENIDO");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "No se ha podido iniciar la sesion", JOptionPane.WARNING_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "No se ha podido iniciar la sesion", JOptionPane.WARNING_MESSAGE);
        }
    }
}
