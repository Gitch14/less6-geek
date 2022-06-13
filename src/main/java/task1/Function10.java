package task1;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function10 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function10() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select InvoiceId, count(*) from invoiceline group by InvoiceId order by count(*) desc";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("InvoiceId");
                int count = resultSet.getInt("count(*)");
                System.out.println(id + " | " + count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
