package task2;

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


    public Function4() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select CONCAT(playlist.PlaylistId,' ',Name) as PlayList,COUNT(p.TrackId) as Count from playlist left join playlisttrack p on playlist.PlaylistId = p.PlaylistId group by PlayList";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                int count = resultSet.getInt("Count");
                String name = resultSet.getString("PlayList");
                System.out.println(name + " | " + count);
            }
            writer.write(sql + "  /* sql-4*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
