package mapping.EagerVsLazy;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoin {                           //este automat Eager la one to manny
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.oneToManny.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{


            session.beginTransaction();

            Query<Instructor> query=session.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"where i.id=:theInstructorId",Instructor.class);
            Instructor instructor=query.getSingleResult();
            System.out.println(instructor);
            session.getTransaction().commit();


        }finally {
            session.close();
            factory.close();
        }
    }
}
