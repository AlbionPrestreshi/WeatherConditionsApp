

import jdk.jfr.internal.tool.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDB {

    private static final String username = "????";
    private static final String password = "????";

    public static void save(Main main) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/current_weather?serverTimezone=EST5EDT", username, password);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO main(temp,humidity,pressure,temp_min,temp_max,sea_level,grnd_level) VALUES "
                    + "('"
                    + main.getTemp() + "','"
                    + main.getHumidity() + "','" + main.getPressure()
                    + "','" + main.getTempMin()
                    + "','" + main.getTempMax()
                    + "','" + main.getSeaLevel()
                    + "','" + main.getGrndLevel()
                    + "')";
            int rs = stmt.executeUpdate(sql);
            System.out.println("U afektuan " + rs + " rekorde.");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}