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

            if(usuario.equals(listUser.getUsuario())){
                if(contraseña.equals(listUser.getContraseña())){
                    evaluar = true;
                }
            }
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
            System.out.println(usuario.get(i));
            i++;
        }
        return usuario;
    }




}
