package mapping.oneToOne;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://"+"localhost"+":"+"3306"+"/hb-01-one-to-one-uni?useSSL=false";
        String user="hbstudent";
        String password="hbstudent";
        try{
            System.out.println("Connecting to database "+jdbcUrl);
            Connection connection= DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Connection successful");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
