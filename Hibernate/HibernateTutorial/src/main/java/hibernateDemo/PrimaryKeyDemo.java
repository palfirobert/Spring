package hibernateDemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try{
            Student tempStudent1=new Student("Nicolae","Chiril","palfi.robert14@yahoo.com");
            Student tempStudent2=new Student("Gia","Muras","gia123@yahoo.com");
            Student tempStudent3=new Student("Vasile","Popa","vpopa@yahoo.com");

            session.beginTransaction();

            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("Students saved!");
        }finally {
            factory.close();
        }
    }
}
