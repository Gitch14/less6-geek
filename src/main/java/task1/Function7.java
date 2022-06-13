package task1;

import db.DBManager;

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
        String sql = "select c.FirstName,c.LastName,c.Country,e.FirstName,e.LastName,Total from invoice left outer join customer c on c.CustomerId = invoice.CustomerId left join employee e on c.SupportRepId = e.EmployeeId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                double total = resultSet.getDouble("Total");
                String fn = resultSet.getString("c.FirstName");
                String ln = resultSet.getString("c.LastName");
                String country = resultSet.getString("c.Country");
                String fn1 = resultSet.getString("e.FirstName");
                String ln1 = resultSet.getString("e.LastName");
                System.out.println(total + " | " + fn + " " + ln + " | " + country + " | " + fn1 + " " + ln1 + " | ");
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
