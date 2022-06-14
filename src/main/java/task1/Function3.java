package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function3 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function3() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql ="select c.FirstName,c.LastName,InvoiceId,InvoiceDate,BillingCountry from invoice inner join customer c on invoice.CustomerId = c.CustomerId where c.Country = 'Brazil'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("InvoiceId");
                String fn = resultSet.getString("c.FirstName");
                String ln = resultSet.getString("c.LastName");
                String invoiceDate = resultSet.getString("InvoiceDate");
                String country = resultSet.getString("BillingCountry");
                System.out.println(id + " | " + fn + " " + ln + " | " + invoiceDate + " | " + country);
            }
            writer.write(sql + "  /* sql-3*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
