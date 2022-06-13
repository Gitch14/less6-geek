package task2;

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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select Name,I2.Total from track left join invoiceline i on track.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId ORDER BY Total DESC");
            while (resultSet.next()){
                double total = resultSet.getInt("I2.Total");
                String name = resultSet.getString("Name");
                System.out.println(name + " | " + total);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
