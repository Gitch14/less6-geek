package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {

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
            while (resultSet.next()){
                String fn = resultSet.getString("t.Na1me");
                String ln = resultSet.getString("a2.Name");
                double untitPrice = resultSet.getDouble("t.UnitPrice");
                double total = resultSet.getDouble("i.Total");
                System.out.println(fn + " " + ln + " | " + untitPrice + " | " + total);
                /*
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(id);
                fileWriter.write(fn);
                fileWriter.write(ln);
                fileWriter.write(country);
                fileWriter.write(" task2.1 ");
                        */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
