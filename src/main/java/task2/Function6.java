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
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                System.out.println(fn + " " + ln );
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
