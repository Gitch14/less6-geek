package task1;

import db.DBManager;

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
        String sql = "select COUNT(InvoiceId) from invoiceline where InvoiceId = 37";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int count = resultSet.getInt("COUNT(InvoiceId)");
                System.out.println(count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
