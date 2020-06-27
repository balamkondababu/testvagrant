import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeatherReportPage extends DriverSetup {

    @FindBy(id = "h_sub_menu")
    private WebElement subMenu;

    @FindBy(linkText = "WEATHER")
    private WebElement weatherlink;

    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchCity;

    @FindBy(className = "defaultChecked")
    private List<WebElement> defualtCities;

    @FindBy(className = "cityText")
    private List<WebElement> citiesInMap;

    @FindBy(xpath = "//div[@class='leaflet-popup-content']//b")
    private List<WebElement> weatherDetails;

    public WeatherReportPage(){
        driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToWeather() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(subMenu));
        subMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(weatherlink));
        weatherlink.click();
    }

    public void assertWeatherPage() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchCity));
        Assert.assertTrue(driver.getTitle().contains("NDTV Weather - Weather in your Indian City"));
    }

    public void selectCity(String cityName) {
        searchCity.clear();
        searchCity.sendKeys(cityName);
        List<String> defualtSelectedCities = new ArrayList<String>();
        for (int i = 0; i <defualtCities.size() ; i++) {
            defualtSelectedCities.add(defualtCities.get(i).getAttribute("id"));
        }
        if(!defualtSelectedCities.contains(cityName)) {
            driver.findElement(By.xpath("//input[@id='"+cityName+"']")).click();
        }
    }

    public void assertSelectedCityInMap(String cityName) {

        List<String> citiesMap = new ArrayList<String>();
        for (int i = 0; i <citiesInMap.size() ; i++) {
            citiesMap.add(citiesInMap.get(i).getText());
        }
        Assert.assertTrue(citiesMap.contains(cityName));
    }

    public void selectCityInMap(String cityName) {

        driver.findElement(By.xpath("//div[@title='"+cityName+"']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(weatherDetails.get(0)));
    }

    public void getWeatherDetails(HashMap<String,String> cityWeatherDetails, String cityName) {

        cityWeatherDetails.put("City",cityName);
        cityWeatherDetails.put("Wind",weatherDetails.get(1).getText().split(":")[1].trim().split("KPH")[0].trim());
        cityWeatherDetails.put("Humidity",weatherDetails.get(2).getText().split(":")[1].replace("%","").trim());
        cityWeatherDetails.put("Temperature in Degrees", weatherDetails.get(3).getText().split(":")[1].trim());
        System.out.println(cityWeatherDetails);
    }

}
