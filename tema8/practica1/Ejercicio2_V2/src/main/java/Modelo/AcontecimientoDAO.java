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

    public static String alta(Acontecimiento a) throws Exception{

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

}
