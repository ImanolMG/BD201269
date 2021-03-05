package persistencia;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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

    public boolean BuscarUsuario(String usuario, String contraseña){
        Session session = factory.openSession();
        List empList1 = session.createQuery(" from Usuarios").list();
        boolean evaluar = false;
        Usuarios listUser;
        for (Iterator iterator = empList1.iterator(); iterator.hasNext();){
            listUser = (Usuarios) iterator.next();

            if(usuario.equals(listUser.getUser())){
                if(contraseña.equals(listUser.getPassword())){
                    evaluar = true;
                }
            }
        }
        return evaluar;
    }

    public void RegistrarUsuarios(String nombre, String usuario, String contraseña){
        Session session = factory.openSession();
        session.beginTransaction();

        Usuarios userRegister = new Usuarios(nombre, usuario, contraseña);
        session.save(userRegister);

        session.getTransaction().commit();
        session.close();
    }



}
