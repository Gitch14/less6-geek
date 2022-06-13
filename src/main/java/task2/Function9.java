package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function9 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function9() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select e.FirstName,e.LastName,sum(i.Total) from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' and InvoiceDate like '%2011%' limit 1";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String fn = resultSet.getString("e.FirstName");
                String ln = resultSet.getString("e.LastName");
                int count = resultSet.getInt("sum(i.Total)");
                System.out.println(fn + " " + ln + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
