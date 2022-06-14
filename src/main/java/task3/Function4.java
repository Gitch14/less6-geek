package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function4 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;

    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i.TrackId,Name,COUNT(CustomerId) from track left join invoiceline i on track.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId where InvoiceDate like '%2013%' group by Name order by count(Total) desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("TrackId");
                String name = resultSet.getString("Name");
                int count = resultSet.getInt("COUNT(CustomerId)");
                System.out.println(id + " | " + name + " | " + count);
            }
            writer.write(sql + "  /* sql-4*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
