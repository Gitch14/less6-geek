package task3;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function5 {

    //task3.5

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function5() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select Name,count(Total/track.UnitPrice) from track left join invoiceline i on track.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId left join customer c on c.CustomerId = i2.CustomerId group by Name order by count(Total/track.UnitPrice) desc limit 5";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String Name = resultSet.getString("Name");
                int count = resultSet.getInt("count(Total/track.UnitPrice)");
                System.out.println(Name + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
