package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function1 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;

    public Function1() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select e.FirstName,e.LastName, count(CustomerId) from employee e left outer join customer c on e.EmployeeId = c.SupportRepId where c.FirstName is not null group by e.FirstName, e.LastName";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                double total = resultSet.getInt("count(CustomerId)");
                System.out.println(firstName + "  " + lastName + " | " + total);
            }
            writer.write(sql + "  /* sql-1*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
