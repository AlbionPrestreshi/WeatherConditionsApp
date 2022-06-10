import org.tick.weather.net.WeatherDataProvider;
import org.*;

public class LaunchWeatherApp {
    public static void main(String[] args) {

        try {

            WeatherDataProvider dataProvider = new WebRequest();
            CurrentWeatherFrame frm = new CurrentWeatherFrame(dataProvider);
            frm.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}