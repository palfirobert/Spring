package hibernateDemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{
            Student tempStudent=new Student("Robert","Palfi","palfi.robert14@yahoo.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Student saved!");
        }finally {
            factory.close();
        }
    }
}
