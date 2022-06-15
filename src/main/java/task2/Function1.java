package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function1 {

    private final Connection connection;

    FileCreate2 fileCreate = new FileCreate2();



    public Function1() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i2.InvoiceId as Id,t.Name as Track from invoiceline i2 left join track t on t.TrackId = i2.TrackId group by i2.InvoiceId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                double total = resultSet.getInt("Id");
                String name = resultSet.getString("Track");
                System.out.println(name + " | " + total);

            }
            writer.write(sql + "  /* sql-1*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
