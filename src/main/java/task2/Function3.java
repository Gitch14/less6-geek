package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function3 {
    FileCreate2 fileCreate = new FileCreate2();

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
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int count = resultSet.getInt("count(*)");
                String country = resultSet.getString("max(BillingCountry)");
                System.out.println(country + " | " + count);
            }
            writer.write(sql + "  /* sql-3*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
