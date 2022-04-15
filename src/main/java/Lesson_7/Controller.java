package Lesson_7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final WeatherModel weatherModel = new OpenWeather();
    private final Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.ONE_DAY);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String City) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case ONE_DAY:
                weatherModel.getWeather(City, Period.ONE_DAY);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(City, Period.FIVE_DAYS);
        }
    }
}
