package mapping.oneToOne;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteBidirectional {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.mapping.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{


            session.beginTransaction();

            InstructorDetail detail=session.get(InstructorDetail.class,3);
// daca stergerea obiectului nu trebuie sa fie cascadata trebuie rupta legatura bidirectionala
            detail.getInstructor().setInstructorDetail(null);
            session.delete(detail);

            session.getTransaction().commit();


            System.out.println("Deleted instructor "+detail);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
