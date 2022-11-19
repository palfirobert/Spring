package entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Id //cheie primara
    @GeneratedValue(strategy = GenerationType.IDENTITY) //asta e optional
    @Column(name = "id")
    private int id;

    public Student(){}
    public Student(String firstName,String lastName,String email)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
