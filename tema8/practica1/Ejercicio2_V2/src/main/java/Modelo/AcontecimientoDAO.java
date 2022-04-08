package Modelo;



import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;

public class AcontecimientoDAO {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction transaction;
    private static AcontecimientoEntity ac;

    public static String alta(AcontecimientoEntity a) throws Exception{

        String mensaje;
        try{
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(a);
            transaction.commit();
            mensaje = "ok";
        }
        catch (Exception e){
            mensaje = e.getMessage();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
        return mensaje;
    }

    public static AcontecimientoEntity consultarEvento(String nombre) {
        String mensaje;
        try{
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            ac = em.find(AcontecimientoEntity.class,nombre);
        }
        catch (Exception e){
            ac = null;
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
       return ac;
    }

    public static String borrar() {

        String mensaje;
        try{
            emf = Persistence.createEntityManagerFactory("default");
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            ac = em.find(AcontecimientoEntity.class,ac.getNombre());
            em.remove(ac);
            transaction.commit();
            mensaje = "ok";
        }
        catch (Exception e){
            mensaje = e.getMessage();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            em.close();
            emf.close();
        }
        return mensaje;

    }
}
