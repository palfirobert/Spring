package mapping.oneToManny;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourses {
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
            Course course=session.get(Course.class,10);

            session.delete(course);

            session.getTransaction().commit();



        }finally {
            session.close();
            factory.close();
        }
    }
}
