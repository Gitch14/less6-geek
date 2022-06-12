package task3;

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
        String sql = "select i.BillingCountry,sum(Total) from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                double total = resultSet.getInt("sum(Total)");
                String country = resultSet.getString("BillingCountry");
                System.out.println(country + " | " + total);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
