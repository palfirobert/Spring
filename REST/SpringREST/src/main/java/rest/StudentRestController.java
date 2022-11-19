package main.java.rest;

import main.java.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student>students;

    @PostConstruct
    public void loadData()
    {
        students=new ArrayList<>();
        students.add(new Student("Palfi","Robert"));
        students.add(new Student("Murat","Gia"));
        students.add(new Student("Hex","Jimmy"));
    }
    @GetMapping("/students")
    public List<Student> getStudents()
    {

        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId>students.size() || studentId<0)
            throw new StudentNotFoundException("Student id not found "+studentId);

        return students.get(studentId);
    }


}
