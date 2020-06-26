import java.util.HashMap;
import java.util.List;

public class Weather {

    String name;
    int id;
    HashMap<String,Long> coord;
    List<WeatherDetails> weather;
    String base;
    HashMap<String,Integer> main;
    int visibility;
    HashMap<String,Integer> wind;
    HashMap<String,Integer> clouds;
    HashMap<String,Object> sys;
    int dt;
    Long timezone;
    int cod;


    public Weather() {

    }

    public void setWeather(List<WeatherDetails> weather) {
        this.weather = weather;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(HashMap<String, Integer> main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind(HashMap<String, Integer> wind) {
        this.wind = wind;
    }

    public void setClouds(HashMap<String, Integer> clouds) {
        this.clouds = clouds;
    }

    public void setSys(HashMap<String, Object> sys) {
        this.sys = sys;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public List<WeatherDetails> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public HashMap<String, Integer> getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public HashMap<String, Integer> getWind() {
        return wind;
    }

    public HashMap<String, Integer> getClouds() {
        return clouds;
    }

    public HashMap<String, Object> getSys() {
        return sys;
    }

    public int getDt() {
        return dt;
    }

    public Long getTimezone() {
        return timezone;
    }

    public int getCod() {
        return cod;
    }

    public void setCoord(HashMap<String, Long> coord) {
        this.coord = coord;
    }

    public HashMap<String, Long> getCoord() {
        return coord;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
