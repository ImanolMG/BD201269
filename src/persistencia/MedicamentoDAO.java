package persistencia;

import javafx.scene.control.Alert;
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
import java.util.*;

public class MedicamentoDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public MedicamentoDAO(){
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

    public List<Medicamento> listaMedicamentos(){
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Medicamento.class);
        ProjectionList medicamentoLista = Projections.projectionList();

        medicamentoLista.add(Projections.property("Codigo"), "Codigo");
        medicamentoLista.add(Projections.property("NombreMedicamento"), "NombreMedicamento");
        medicamentoLista.add(Projections.property("SustanciaActiva"), "SustanciaActiva");
        medicamentoLista.add(Projections.property("Caducidad"), "Caducidad");

        criteria.setProjection(medicamentoLista);

        List<Medicamento> medicamento = new ArrayList<>();
        List medicamentoList = criteria.setResultTransformer(new AliasToBeanResultTransformer(Medicamento.class)).list();

        int i =0;
        for(Iterator iterator = medicamentoList.iterator(); iterator.hasNext();){
            medicamento.add((Medicamento) iterator.next());
            i++;
        }
        return medicamento;
    }

    public void GuardarDatos(Integer Codigo, String NombreMedicamento, String SustanciaActiva, String Caducidad){
        Session session = factory.openSession();
        session.beginTransaction();
        Medicamento userRegister = new Medicamento(Codigo, NombreMedicamento , SustanciaActiva,  Date.valueOf(Caducidad) );
        session.save(userRegister);
        session.getTransaction().commit();
        session.close();
    }

    public void EditarDatos(Integer Codigo, String NombreMedicamento, String SustanciaActiva, String Caducidad){
        Session session = factory.openSession();
        try {

            session.beginTransaction();

            Medicamento userRegister = (Medicamento) session.get(Medicamento.class, Codigo);

            userRegister.setCodigo(Codigo);
            userRegister.setNombreMedicamento(NombreMedicamento);
            userRegister.setSustanciaActiva(SustanciaActiva);
            userRegister.setCaducidad(Date.valueOf(Caducidad));
            session.update(userRegister);

            session.getTransaction().commit();
        }catch (Throwable throwable){
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle(throwable.getMessage());
            mensaje.setContentText("No se ha realizado el registro, asegurese que los datos son correctos");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
        session.close();
    }

    public void EliminarDatos (Integer Codigo){
        Session session = factory.openSession();
        session.beginTransaction();

        Medicamento userRegister = (Medicamento)session.get(Medicamento.class, Codigo);
        session.delete(userRegister);

        session.getTransaction().commit();
        session.close();
    }
}