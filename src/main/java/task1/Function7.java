package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function7 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function7() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select concat(c.FirstName,' ', c.LastName) as FullNameCustomer,c.Country,concat(e.FirstName,' ', e.LastName) as FullNameEmployee,Total from invoice left outer join customer c on c.CustomerId = invoice.CustomerId left join employee e on c.SupportRepId = e.EmployeeId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                double total = resultSet.getDouble("Total");
                String fn = resultSet.getString("FullNameCustomer");;
                String country = resultSet.getString("c.Country");
                String fn1 = resultSet.getString("FullNameEmployee");

                System.out.println(total + " | " + fn + " | " + country + " | " + fn1);
            }
            writer.write(sql + "  /* sql-7*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
