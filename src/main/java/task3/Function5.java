package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function5 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;


    public Function5() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select Name,count(i.TrackId) as Count from track t left join invoiceline i on t.TrackId = i.TrackId left join invoice i2 on i2.InvoiceId = i.InvoiceId left join customer c on c.CustomerId = i2.CustomerId group by t.Name order by Count desc limit 5";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String Name = resultSet.getString("Name");
                int count = resultSet.getInt("Count");
                System.out.println(Name + " | " + count);
            }
            writer.write(sql + "  /* sql-5*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
