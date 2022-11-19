package mapping.oneToManny;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorWithCourses {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.oneToManny.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{
//            Instructor instructor=new Instructor("Gia","Muratura","giaM@gmail.com");
//            InstructorDetail instructorDetail=new InstructorDetail("sarmale.youtube","Masini");
//            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();
            Instructor instructor=session.get(Instructor.class,1);
            Course course1=new Course("Python");instructor.add(course1);session.save(course1);
            Course course2=new Course("Java");instructor.add(course2);session.save(course2);
            Course course3=new Course("C++");instructor.add(course3);session.save(course3);
            Course course4=new Course("Ruby");instructor.add(course4);session.save(course4);

//            session.save(instructor);

            session.getTransaction().commit();

            System.out.println("Saved instructor "+instructor);

        }finally {
            session.close();
            factory.close();
        }
    }
}
