package task3;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function2() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i.BillingCountry,count(Total) from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry order by count(Total) desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String country = resultSet.getString("BillingCountry");
                int count = resultSet.getInt("count(Total)");
                System.out.println(country + " | " + count);
                /*
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(id);
                fileWriter.write(fn);
                fileWriter.write(ln);
                fileWriter.write(country);
                fileWriter.write(" task2.1 ");
                        */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
