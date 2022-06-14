package task1;

import FileCreaters.FileCreate1;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function4 {

    FileCreate1 fileCreate = new FileCreate1();
    private final Connection connection;


    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql ="select * from employee where Title like '%Sales%' '%Agent%'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id = resultSet.getInt("EmployeeId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String title = resultSet.getString("Title");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                System.out.println(id + " | " + fn + " " + ln + " | " + title + " | " + email + " | " + phone);
            }
            writer.write(sql + "  /* sql-4*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
