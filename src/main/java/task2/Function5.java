package task2;

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function5 {

    private final Connection connection;
    // CustomerId,FirstName,LastName,Country


    public Function5() {
        connection = DBManager.getInstance().getConnection();
    }

    public void find(){
        String sql = "select max(a.Title),m.Name,g.Name from track left join album a on a.AlbumId = track.AlbumId left join mediatype m on m.MediaTypeId = track.MediaTypeId left join genre g on g.GenreId = track.GenreId group by a.Title";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String max = resultSet.getString("max(a.Title)");
                String media = resultSet.getString("m.Name");
                String genre = resultSet.getString("g.Name");
                System.out.println(media + " | " + genre + " | " + max);
            }

            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
