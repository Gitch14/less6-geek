package task2;

import FileCreaters.FileCreate2;
import db.DBManager;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function5 {
    FileCreate2 fileCreate = new FileCreate2();

    private final Connection connection;


    public Function5() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select max(a.Title),m.Name,g.Name from track left join album a on a.AlbumId = track.AlbumId left join mediatype m on m.MediaTypeId = track.MediaTypeId left join genre g on g.GenreId = track.GenreId group by a.Title";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FileWriter writer = new FileWriter(String.valueOf(fileCreate.getFile()),true);
            while (resultSet.next()){
                String max = resultSet.getString("max(a.Title)");
                String media = resultSet.getString("m.Name");
                String genre = resultSet.getString("g.Name");
                System.out.println(media + " | " + genre + " | " + max);
            }
            writer.write(sql + "  /* sql-5*/\n");
            writer.close();

            } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
