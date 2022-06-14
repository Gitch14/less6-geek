package task3;

import FileCreaters.FileCreate3;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function2 {
    FileCreate3 fileCreate = new FileCreate3();

    private final Connection connection;


    public Function2() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select i.BillingCountry,count(Total) from customer left join invoice i on customer.CustomerId = i.CustomerId group by i.BillingCountry order by count(Total) desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String country = resultSet.getString("BillingCountry");
                int count = resultSet.getInt("count(Total)");
                System.out.println(country + " | " + count);
            }
            writer.write(sql + "  /* sql-2*/\n");
            writer.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
