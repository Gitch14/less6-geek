package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function9 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;


    public Function9() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select concat(e.FirstName,' ',e.LastName) as FullName,sum(i.Total) as Total from employee e left outer join customer c on e.EmployeeId = c.SupportRepId left join invoice i on c.CustomerId = i.CustomerId where Title like '%Sales%' '%Agent%' and InvoiceDate like '%2011%' limit 1";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String fn = resultSet.getString("FullName");
                int count = resultSet.getInt("Total");
                System.out.println(fn + " | " + count);
            }
            writer.write(sql + "  /* sql-9*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
