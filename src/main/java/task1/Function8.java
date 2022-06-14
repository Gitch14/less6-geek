package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function8 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function8() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql ="select COUNT(InvoiceDate) from invoice where InvoiceDate like '%2009%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet2009 = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet2009.next()){
                int count = resultSet2009.getInt("COUNT(InvoiceDate)");
                System.out.println(count);
            }
            writer.write(sql + "  /* sql-8.1*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet2011 = statement.executeQuery("select COUNT(InvoiceDate) from invoice where InvoiceDate like '%2011%'");
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet2011.next()){
                int count = resultSet2011.getInt("COUNT(InvoiceDate)");
                System.out.println(count);
            }
            writer.write(sql + "  /* sql-8.2*/\n");
            writer.close();

        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
