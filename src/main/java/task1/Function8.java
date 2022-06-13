package task1;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function8 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function8() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql ="select COUNT(InvoiceDate) from invoice where InvoiceDate like '%2009%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet2009 = statement.executeQuery(sql);
            while (resultSet2009.next()){
                int count = resultSet2009.getInt("COUNT(InvoiceDate)");
                System.out.println(count);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet2011 = statement.executeQuery("select COUNT(InvoiceDate) from invoice where InvoiceDate like '%2011%'");
            while (resultSet2011.next()){
                int count = resultSet2011.getInt("COUNT(InvoiceDate)");
                System.out.println(count);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
