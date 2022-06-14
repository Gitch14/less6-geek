package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function6 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function6() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select employee.FirstName,employee.LastName, i.Total from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId group by i.Total desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                double total = resultSet.getDouble("i.Total");
                System.out.println(fn + " " + ln + " | " + total);
            }
            writer.write(sql + "  /* sql-6*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
