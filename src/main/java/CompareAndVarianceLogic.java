import org.testng.Assert;

import java.util.HashMap;

public class CompareAndVarianceLogic {

    public void compareAndVariance(HashMap<String,Object> openMapWeather, HashMap<String,String> cityWeatherDetails, int range, String parameter) {

        if (openMapWeather.get(parameter) == cityWeatherDetails.get(parameter)) {
            Assert.assertTrue(true);
        } else {
            int temp1 = (Integer) openMapWeather.get(parameter);
            int temp2 = Integer.parseInt(cityWeatherDetails.get(parameter));
            if(Math.abs(temp1-temp2) < range) {
                Assert.assertTrue(true,parameter+" difference between"+ openMapWeather.get("City")+" and "+cityWeatherDetails.get("City")+" within range "+range);
            } else {
                Assert.assertTrue(false,parameter+" difference between "+ openMapWeather.get("City")+" and "+cityWeatherDetails.get("City")+" not within range "+range);
            }
        }
    }

}
