package hibernateDemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{

            session.beginTransaction();

            Student student=session.get(Student.class,1);
            session.delete(student);

            //or without retrieving the object
            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
