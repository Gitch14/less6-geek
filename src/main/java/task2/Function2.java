package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function2() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select t.Name,a2.Name,t.UnitPrice,i.Total from invoiceline left join track t on invoiceline.TrackId = t.TrackId left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join album a on a.AlbumId = t.AlbumId left join artist a2 on a2.ArtistId = a.ArtistId order by UnitPrice desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String fn = resultSet.getString("t.Name");
                String ln = resultSet.getString("a2.Name");
                double untitPrice = resultSet.getDouble("t.UnitPrice");
                double total = resultSet.getDouble("i.Total");
                System.out.println(fn + " " + ln + " | " + untitPrice + " | " + total);
            }
            writer.write(sql + "  /* sql-2*/\n");
            writer.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
