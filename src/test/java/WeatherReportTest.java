import org.testng.annotations.Test;

public class WeatherReportTest extends DriverSetup {

    @Test
    public void weatherReport() {

        weatherReportPage.navigateToWeather();
        weatherReportPage.assertWeatherPage();
        weatherReportPage.selectCity("Vijayawada");
        weatherReportPage.assertSelectedCityInMap("Vijayawada");
        weatherReportPage.selectCityInMap("Vijayawada");
        weatherReportPage.getWeatherDetails();
    }
}
