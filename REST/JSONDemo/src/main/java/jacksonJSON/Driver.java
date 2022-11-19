package jacksonJSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        Student student=mapper.readValue(new File("data/sample-full.json"), Student.class);
        System.out.println(student.getLanguages().get(0));
    }
}
