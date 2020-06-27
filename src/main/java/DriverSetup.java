import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverSetup {

    Properties config = new Properties();
    public static WebDriver driver = null;
    public static WeatherReportPage weatherReportPage = null;
    public static CompareAndVarianceLogic compareAndVarianceLogic =null;

    public void loadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//resources//config.properties");
        config.load(ip);
    }

    public void configureDriverPath() throws IOException {

        if (config.getProperty("os").startsWith("Linux")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/linux/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/linux/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        if (config.getProperty("os").startsWith("Mac")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/mac/geckodriver";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/driver/mac/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
        if (config.getProperty("os").startsWith("Windows")) {
            String firefoxDriverPath = System.getProperty("user.dir") + "//src//main//resources//driver//windows//geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            String chromeDriverPath = System.getProperty("user.dir") + "//src//main//resources//driver//windows//chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        }
    }

    @BeforeTest
    public void openBrowser() throws IOException {
        loadConfigProperty();
        configureDriverPath();
        if (config.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();

        } else if (config.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
        weatherReportPage = new WeatherReportPage();
        compareAndVarianceLogic = new CompareAndVarianceLogic();
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
