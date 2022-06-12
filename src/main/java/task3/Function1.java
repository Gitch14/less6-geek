package task3;

import db.DBManager;

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
        String sql = "select e.FirstName,e.LastName, count(CustomerId) from employee e left outer join customer c on e.EmployeeId = c.SupportRepId where c.FirstName is not null group by e.FirstName, e.LastName";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                double total = resultSet.getInt("count(CustomerId)");
                System.out.println(firstName + "  " + lastName + " | " + total);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
