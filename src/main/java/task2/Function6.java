package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function6 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function6() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select InvoiceLineId,InvoiceDate,BillingCountry,BillingState,BillingCity,BillingAddress,BillingPostalCode,Total from invoiceline left join invoice i on i.InvoiceId = invoiceline.InvoiceId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
