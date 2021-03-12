package persistencia;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;
import java.util.ArrayList;
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
            System.err.println("No se puede crear la Sesion " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public boolean BuscarUsuario(String usuario, String contraseña){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);

        Criterion nombre = Restrictions.like("Usuario", usuario);
        Criterion contra = Restrictions.like("Contraseña", contraseña);

        LogicalExpression andNombreContra = Restrictions.and(nombre, contra);
        criteria.add(andNombreContra);

        List listaUser = criteria.list();
        Usuarios usuarios = new Usuarios();
        boolean evaluar;
        int i =0;
        for(Iterator iterator = listaUser.iterator(); iterator.hasNext();){
            usuarios = (Usuarios) iterator.next();
        }
        if(usuario.equals(usuarios.getUsuario())){
            if(contraseña.equals(usuarios.getContraseña())){
                evaluar = true;
            }else {
                evaluar = false;
            }
        }
        else{
            evaluar = false;
        }
        return evaluar;
    }

    public List<Usuarios> listaUsuarios(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Usuarios.class);
        ProjectionList usuariosLista = Projections.projectionList();

        usuariosLista.add(Projections.property("idUsuario"), "idUsuario");
        usuariosLista.add(Projections.property("NombreCompleto"), "NombreCompleto");
        usuariosLista.add(Projections.property("Usuario"), "Usuario");
        usuariosLista.add(Projections.property("Contraseña"), "Contraseña");
        criteria.setProjection(usuariosLista);

        List<Usuarios> usuario = new ArrayList<>();
        List usuariosList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Usuarios.class)).list();

        int i =0;
        for(Iterator iterator = usuariosList.iterator(); iterator.hasNext();){
            usuario.add((Usuarios) iterator.next());
            i++;
        }
        return usuario;
    }

    public void EliminarDatos (Integer id){
        Session session = factory.openSession();
        session.beginTransaction();

        Usuarios userRegister = (Usuarios)session.get(Usuarios.class, id);
        session.delete(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public void EditarDatos(Integer id, String nombre, String usuario, String contraseña){
        Session session = factory.openSession();
        session.beginTransaction();

        Usuarios userRegister = (Usuarios)session.get(Usuarios.class, id);

        userRegister.setNombreCompleto(nombre);
        userRegister.setUsuario(usuario);
        userRegister.setContraseña(contraseña);
        session.update(userRegister);

        session.getTransaction().commit();
        session.close();
    }

    public void GuardarDatos(String Nombre, String Usuario, String Contraseña){
        Session session = factory.openSession();
        session.beginTransaction();
        Usuarios userRegister = new Usuarios(0,Nombre, Usuario, Contraseña);
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }


}
