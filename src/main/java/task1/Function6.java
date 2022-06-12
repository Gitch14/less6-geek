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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT employee.FirstName,employee.LastName from employee left outer join customer c on employee.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId");
            while (resultSet.next()){
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                System.out.println(fn + " " + ln );
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
