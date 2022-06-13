package task1;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function5 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function5() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select BillingCountry from invoice group by BillingCountry";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String BillingCountry = resultSet.getString("BillingCountry");
                System.out.println(BillingCountry);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
