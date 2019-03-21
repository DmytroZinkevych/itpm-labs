package org.student.itpmlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
    public static List<Alien> getAll() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/maventry?serverTimezone=UTC", "root", "root");
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from alien");
            List<Alien> aliens = new ArrayList<>();
            while(resultSet.next()) {
                Alien alien = new Alien(resultSet.getInt("aid"), resultSet.getString("aname"), resultSet.getString("tech"));
                aliens.add(alien);
            }
            return aliens;
        } catch(Exception e) {
            System.out.println("Can't connect to database:\n" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
