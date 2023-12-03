import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class WeatherAnalysis {

    public static void main(String[] args) {
        List<WeatherData> weatherDataList = fetchDataFromAPI();

        List<WeatherData> hottestStations = findHottestStations(weatherDataList);
        List<WeatherData> coldestStations = findColdestStations(weatherDataList);
        List<WeatherData> rainiestStations = findRainiestStations(weatherDataList);

        displayResults("Hottest Stations", hottestStations);
        displayResults("Coldest Stations", coldestStations);
        displayResults("Rainiest Stations", rainiestStations);

    }

    public static List<WeatherData> fetchDataFromAPI() {

        List<WeatherData> testData = new ArrayList<>();
        testData.add(new WeatherData(LocalDate.of(2023, 1, 1), 1, 25.5, 80.0, 5.0, 3.5));
        testData.add(new WeatherData(LocalDate.of(2023, 1, 2), 1, 26.0, 78.0, 4.0, 4.0));
        testData.add(new WeatherData(LocalDate.of(2023, 1, 3), 2, 20.0, 75.0, 10.0, 2.0));
        testData.add(new WeatherData(LocalDate.of(2023, 1, 4), 2, 22.0, 70.0, 8.0, 3.0));
        return testData;
    }

    public static List<WeatherData> findHottestStations(List<WeatherData> data) {

        return data.stream()
                .sorted((a, b) -> Double.compare(b.getTemperature(), a.getTemperature()))
                .limit(2)
                .collect(Collectors.toList());
    }

    public static List<WeatherData> findColdestStations(List<WeatherData> data) {

        return data.stream()
                .sorted((a, b) -> Double.compare(a.getTemperature(), b.getTemperature()))
                .limit(2)
                .collect(Collectors.toList());
    }

    public static List<WeatherData> findRainiestStations(List<WeatherData> data) {

        return data.stream()
                .sorted((a, b) -> Double.compare(b.getPrecipitation(), a.getPrecipitation()))
                .limit(2)
                .collect(Collectors.toList());
    }

    public static void displayResults(String title, List<WeatherData> stations) {
        System.out.println(title + ":");
        for (WeatherData data : stations) {
            System.out.println("Station ID: " + data.getStationId() + ", Temperature: " + data.getTemperature());
        }
        System.out.println();
    }
}
