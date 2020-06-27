import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class WeatherReportTest extends DriverSetup {

    HashMap<String, Object> openMapWeather
            = new HashMap<>();

    HashMap<String, String> cityWeatherDetails
            = new HashMap<>();

    @Test(priority=1)
    public void weatherReport() {

        weatherReportPage.navigateToWeather();
        weatherReportPage.assertWeatherPage();
        weatherReportPage.selectCity("Vijayawada");
        weatherReportPage.assertSelectedCityInMap("Vijayawada");
        weatherReportPage.selectCityInMap("Vijayawada");
        weatherReportPage.getWeatherDetails(cityWeatherDetails,"Vijayawada");
    }

    @Test(priority=2)
    public void openWeatherTest() {

        Response res =  when().request("GET","http://api.openweathermap.org/data/2.5/weather?q=London&appid=7fe67bf08c80ded756e598d6f8fedaea&units=metric");
        res.then().statusCode(200).log().all();
        openMapWeather.put("City",res.getBody().as(Weather.class).getName().toString());
        openMapWeather.put("Temperature in Degrees",res.getBody().as(Weather.class).getMain().get("temp"));
        openMapWeather.put("Wind",res.getBody().as(Weather.class).getWind().get("speed"));
        openMapWeather.put("Humidity",res.getBody().as(Weather.class).getMain().get("humidity"));
        System.out.println(openMapWeather);
    }

    @Test(priority = 3)
    public void compareTemperatures() {
        compareAndVarianceLogic.compareAndVariance(openMapWeather,cityWeatherDetails,5,"Temperature in Degrees");
    }

    @Test(priority = 4)
    public void compareHumidity() {
        compareAndVarianceLogic.compareAndVariance(openMapWeather,cityWeatherDetails,10,"Humidity");
    }
}
