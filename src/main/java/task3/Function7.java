package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function7 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;

    public Function7() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select m.Name as Media,count(i.InvoiceId) as Count from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId left join track t on t.TrackId = invoiceline.TrackId left join mediatype m on m.MediaTypeId = t.MediaTypeId group by m.Name order by count(i.InvoiceId) desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String name = resultSet.getString("Media");
                int count = resultSet.getInt("Count");
                System.out.println(name + " | " + count);
            }
            writer.write(sql + "  /* sql-7*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
