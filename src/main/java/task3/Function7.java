package task3;

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
        String sql = "select m.Name,count(i.InvoiceId) from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join track t on t.TrackId = invoiceline.TrackId left join mediatype m on m.MediaTypeId = t.MediaTypeId group by m.Name order by count(i.InvoiceId) desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("Name");
                int count = resultSet.getInt("count(i.InvoiceId)");
                System.out.println(name + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
