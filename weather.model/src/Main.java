import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Main {

    private double temp;
    private int humidity;
    private int pressure;
    private double tempMin;
    private double tempMax;
    private double seaLevel;
    private double grndLevel;
    private double feelsLike;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;

    }

    @JsonGetter("temp_min")
    public double getTempMin() {
        return tempMin;
    }

    @JsonSetter("temp_min")
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonGetter("temp_max")
    public double getTempMax() {
        return tempMax;
    }

    @JsonSetter("temp_max")
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    @JsonGetter("sea_level")
    public double getSeaLevel() {
        return seaLevel;
    }

    @JsonSetter("sea_level")
    public void setSeaLevel(double seaLevel) {
        this.seaLevel = seaLevel;
    }

    @JsonGetter("grnd_level")
    public double getGrndLevel() {
        return grndLevel;
    }

    @JsonSetter("grnd_level")
    public void setGrndLevel(double grndLevel) {
        this.grndLevel = grndLevel;
    }

    @JsonGetter("feels_like")
    public double getFeelsLike() {
        return feelsLike;
    }

    @JsonSetter("feels_like")
    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

}