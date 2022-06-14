package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function6 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;


    public Function6() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select InvoiceLineId,InvoiceDate,BillingCountry,BillingState,BillingCity,BillingAddress,BillingPostalCode,Total from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("InvoiceLineId");
                String date = resultSet.getString("InvoiceDate");
                String country = resultSet.getString("BillingCountry");
                String state = resultSet.getString("BillingState");
                String city = resultSet.getString("BillingCity");
                String address = resultSet.getString("BillingAddress");
                String code = resultSet.getString("BillingPostalCode");
                double total = resultSet.getDouble("Total");

                System.out.println(id + " | " + date + " | " + country + " | " + state + " | " + city + " | " + address + " | " + code + " | " + total);
            }
            writer.write(sql + "  /* sql-6*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
