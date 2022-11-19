package mapping.oneToOne;

import entity.Instructor;
import entity.InstructorDetail;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.mapping.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{
            Instructor instructor=new Instructor("Gia","Muratura","giaM@gmail.com");
            InstructorDetail instructorDetail=new InstructorDetail("sarmale.youtube","Masini");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Saved instructor "+instructor);

        }finally {
            factory.close();
        }
    }
}
