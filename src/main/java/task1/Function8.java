package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function8 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function8() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql ="select count(i.InvoiceId) as Count,YEAR(InvoiceDate) as Year from invoice i left join invoiceline i2 on i.InvoiceId = i2.InvoiceId where YEAR(InvoiceDate) in ('2009', '2011') group by YEAR(InvoiceDate)";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String year = resultSet.getString("Year");
                int count = resultSet.getInt("Count");
                System.out.println(count + " | " + year);
            }
            writer.write(sql + "  /* sql-8*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
