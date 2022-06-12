package task3;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function4 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i.TrackId,Name,COUNT(CustomerId) from track left join invoiceline i on track.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId where InvoiceDate like '%2013%' group by Name order by count(Total) desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("TrackId");
                String name = resultSet.getString("Name");
                int count = resultSet.getInt("COUNT(CustomerId)");
                System.out.println(id + " | " + name + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
