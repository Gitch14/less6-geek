package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function10 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function10() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select employee.FirstName,employee.LastName,count(InvoiceId) from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId group by employee.FirstName, employee.LastName order by count(InvoiceId) desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String fn = resultSet.getString("employee.FirstName");
                String ln = resultSet.getString("employee.LastName");
                int count = resultSet.getInt("count(InvoiceId)");
                System.out.println(fn + " " + ln + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
