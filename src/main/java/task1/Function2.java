package task1;

import db.DBManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function2() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer where Country = 'Brazil'");
            while (resultSet.next()){
                int id = resultSet.getInt("CustomerId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String country = resultSet.getString("Country");
                System.out.println(id + " | " + fn + " " + ln + " | " + country);
                /*
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(id);
                fileWriter.write(fn);
                fileWriter.write(ln);
                fileWriter.write(country);
                fileWriter.write(" task2.1 ");
                        */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
