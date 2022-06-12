package task1;

import db.DBManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function9 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function9() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select COUNT(InvoiceId) from invoiceline where InvoiceId = 37");
            while (resultSet.next()){
                int count = resultSet.getInt("COUNT(InvoiceId)");
                System.out.println(count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
