package task3;

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
        String sql = "select a2.Name,count(i.InvoiceId) from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join track t on t.TrackId = invoiceline.TrackId left join album a on a.AlbumId = t.AlbumId left join artist a2 on a2.ArtistId = a.ArtistId group by a2.Name order by count(i.InvoiceId) desc limit 3";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("a2.Name");
                int count  = resultSet.getInt("count(i.InvoiceId)");
                System.out.println(name + " | " + count );
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
