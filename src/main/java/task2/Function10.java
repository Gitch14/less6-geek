package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function10 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;


    public Function10() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select concat(employee.FirstName,employee.LastName) as FullName,count(InvoiceId) as Count from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId group by employee.FirstName, employee.LastName order by count(InvoiceId) desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String fn = resultSet.getString("FullName");
                int count = resultSet.getInt("Count");
                System.out.println(fn + " | " + count);
            }
            writer.write(sql + "  /* sql-10*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
