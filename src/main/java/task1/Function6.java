package task1;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function6 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function6() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select employee.FirstName,employee.LastName, i.Total from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId group by i.Total desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                double total = resultSet.getDouble("i.Total");
                System.out.println(fn + " " + ln + " | " + total);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
