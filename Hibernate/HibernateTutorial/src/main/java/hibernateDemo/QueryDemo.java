package hibernateDemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{

            session.beginTransaction();

            //Query all the students
            List students=session.createQuery("from Student").list(); // Project structure->Facets-> +  -> JPA ->Hibernate

            for(Object student:students)
                System.out.println(student.toString());

            // Query the student with @gmail
            List students2=session.createQuery("from Student s where"+" s.email like '%@gmail.com'").getResultList();

            System.out.println(students2);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}

