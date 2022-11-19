package hibernateDemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{
            session.beginTransaction();

            Student tempStudent=session.get(Student.class,2);

            System.out.println(tempStudent.toString());

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
