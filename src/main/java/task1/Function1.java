package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function1 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function1() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select CustomerId, concat(FirstName,' ', LastName) as FullName, Country from customer where Country != 'USA'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("CustomerId");
                String fn = resultSet.getString("FullName");
                String country = resultSet.getString("Country");
                System.out.println(id + " | " + fn + " | " + country);
            }
            writer.write(sql + "  /* sql-1*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
