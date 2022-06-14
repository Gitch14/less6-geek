package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function7 {
    FileCreate2 fileCreate = new FileCreate2();
    private final Connection connection;


    public Function7() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select e.FirstName,e.LastName,sum(i.Total) from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' group by e.FirstName, e.LastName";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                double total = resultSet.getDouble("sum(i.Total)");
                String fn1 = resultSet.getString("e.FirstName");
                String ln1 = resultSet.getString("e.LastName");
                System.out.println(fn1 + " " + ln1 + " | " + total);
            }
            writer.write(sql + "  /* sql-7*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
