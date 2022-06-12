package task2;

import db.DBManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function7 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function7() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select e.FirstName,e.LastName,sum(i.Total) from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' group by e.FirstName, e.LastName";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                BigDecimal bigDecimal = BigDecimal.valueOf(resultSet.getInt("Total"));
                String fn = resultSet.getString("c.FirstName");
                String ln = resultSet.getString("c.LastName");
                String fn1 = resultSet.getString("e.FirstName");
                String ln1 = resultSet.getString("e.LastName");
                System.out.println(bigDecimal + " | " + fn + " " + ln + " | " + fn1 + " " + ln1 + " | ");
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
