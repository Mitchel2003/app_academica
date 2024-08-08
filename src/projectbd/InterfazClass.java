package projectbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InterfazClass {
    Connection cn;
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/institucion","root","");
            System.out.println("Se hizo la conexion exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }return cn;
    }
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }
}