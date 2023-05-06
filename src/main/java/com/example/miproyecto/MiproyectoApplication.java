package com.example.miproyecto;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiproyectoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(MiproyectoApplication.class, args);
//        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
//        Statement stmt = (Statement) conn.createStatement();
    }

}
