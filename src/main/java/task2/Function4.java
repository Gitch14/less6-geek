package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function4 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select * from playlisttrack pt left join playlist p on p.PlaylistId = pt.PlaylistId left join playlisttrack p2 on p.PlaylistId = p2.PlaylistId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee where Title like '%Sales%'");
            while (resultSet.next()){
                int id = resultSet.getInt("EmployeeId");
                String fn = resultSet.getString("FirstName");
                String ln = resultSet.getString("LastName");
                String title = resultSet.getString("Title");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                System.out.println(id + " | " + fn + " " + ln + " | " + title + " | " + email + " | " + phone);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
