package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function3 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;

    public Function3() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i.BillingCountry,sum(Total) from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry desc limit 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                double total = resultSet.getInt("sum(Total)");
                String country = resultSet.getString("BillingCountry");
                System.out.println(country + " | " + total);
            }
            writer.write(sql + "  /* sql-3*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
