package task1;

import db.DBManager;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function1 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function1() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer");
            while (resultSet.next()){
                int id = resultSet.getInt("CustomerId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String country = resultSet.getString("Country");
                System.out.println(id + " | " + fn + " " + ln + " | " + country);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
