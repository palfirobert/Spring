package mapping.oneToOne;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.mapping.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{


            session.beginTransaction();

            Instructor instructor=session.get(Instructor.class,1);
            session.delete(instructor);

            session.getTransaction().commit();

            System.out.println("Deleted instructor "+instructor);

        }finally {
            factory.close();
        }
    }
}
