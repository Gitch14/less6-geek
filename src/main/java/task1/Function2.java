package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function2() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select * from customer where Country = 'Brazil'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("CustomerId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String country = resultSet.getString("Country");
                System.out.println(id + " | " + fn + " " + ln + " | " + country);
            }
            writer.write(sql + "  /* sql-2*/\n");
            writer.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
