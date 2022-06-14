package task2;

import FileCreaters.FileCreate1;
import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function4 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select * from playlisttrack pt left join playlist p on p.PlaylistId = pt.PlaylistId left join playlisttrack p2 on p.PlaylistId = p2.PlaylistId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int id1 = resultSet.getInt("pt.PlaylistId");
                String name = resultSet.getString("Name");
                int id2 = resultSet.getInt("pt.TrackId");
                System.out.println(id1 + " | " + name + " | " + id2);
            }
            writer.write(sql + "  /* sql-4*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
