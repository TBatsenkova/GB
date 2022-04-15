package Lesson_7;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(String City, Period period) throws IOException;

}
