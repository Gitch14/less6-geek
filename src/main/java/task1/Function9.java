package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function9 {
    FileCreate1 fileCreate = new FileCreate1();

    private final Connection connection;


    public Function9() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select COUNT(InvoiceId) from invoiceline where InvoiceId = 37";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int count = resultSet.getInt("COUNT(InvoiceId)");
                System.out.println(count);
            }
            writer.write(sql + "  /* sql-9*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
