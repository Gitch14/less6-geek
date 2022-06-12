package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function3 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function3() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select max(BillingCountry),count(*) from invoice group by BillingCountry order by 2 desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("InvoiceId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String invoiceDate = resultSet.getString("InvoiceDate");
                String country = resultSet.getString("BillingCountry");
                System.out.println(id + " | " + fn + " " + ln + " | " + invoiceDate + " | " + country);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}