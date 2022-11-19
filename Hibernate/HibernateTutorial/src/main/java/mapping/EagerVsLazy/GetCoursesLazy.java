package mapping.EagerVsLazy;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesLazy {                           //este automat Eager la one to manny
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
            Instructor instructor=session.get(Instructor.class,1);

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

            System.out.println("Saved instructor "+instructor);

        }finally {
            session.close();
            factory.close();
        }
    }
}
