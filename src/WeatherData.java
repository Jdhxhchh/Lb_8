import java.time.LocalDate;

public class WeatherData {
    private LocalDate date;
    private int stationId;
    private double temperature;
    private double humidity;
    private double precipitation;
    private double windSpeed;

    public WeatherData(LocalDate date, int stationId, double temperature, double humidity, double precipitation, double windSpeed) {
        this.date = date;
        this.stationId = stationId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

    public int getStationId() {
        return stationId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}
