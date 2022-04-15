package Lesson_7;

import Lesson_7.Entity.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OpenWeather implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.openweathermap.org";
    private static final String DATA = "data";
    private static final String VERSION = "2.5";
    private static final String FORECAST = "forecast";
    //private static final String DAYS;
    private static final String UNITS = "metric";
    private static final String LANGUAGE = "ru";
    private static final String API_KEY = "51aef6a1eaf8bda4691e0933c5973c08";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    OkHttpClient okHttpClient = new OkHttpClient();
        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

        public void getWeather(String city, Period period) throws IOException {
            switch (period) {
                case ONE_DAY:
                    HttpUrl httpUrl_ONE_DAY = new HttpUrl.Builder()
                            .scheme(PROTOKOL)
                            .host(BASE_HOST)
                            .addPathSegment(DATA)
                            .addPathSegment(VERSION)
                            .addPathSegment(FORECAST)
                            .addQueryParameter("q", city)
                            .addQueryParameter("cnt", "1")
                            .addQueryParameter("lang", LANGUAGE)
                            .addQueryParameter("appid", API_KEY)
                            .addQueryParameter("units", UNITS)
                            .build();


                    Request request = new Request.Builder()
                            .url(httpUrl_ONE_DAY)
                            .build();

                    Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                    String OneDayForecast = oneDayForecastResponse.body().string();

                    WeatherResponse result = objectMapper.readValue(OneDayForecast, WeatherResponse.class);
                    System.out.println(result);
                    break;

                case FIVE_DAYS:
                    HttpUrl httpUrl_FIVE_DAYS = new HttpUrl.Builder()
                            .scheme(PROTOKOL)
                            .host(BASE_HOST)
                            .addPathSegment(DATA)
                            .addPathSegment(VERSION)
                            .addPathSegment(FORECAST)
                            .addQueryParameter("q", city)
                            .addQueryParameter("cnt", "5")
                            .addQueryParameter("lang", LANGUAGE)
                            .addQueryParameter("appid", API_KEY)
                            .addQueryParameter("units", UNITS)
                            .build();

                    Request request1 = new Request.Builder()
                            .url(httpUrl_FIVE_DAYS)
                            .build();

                    Response fiveDaysForecastResponse = okHttpClient.newCall(request1).execute();
                    String FiveDaysForecasts = fiveDaysForecastResponse.body().string();

                    WeatherResponse result1 = objectMapper.readValue(FiveDaysForecasts, WeatherResponse.class);
                    System.out.println(result1);
                    break;
            }
        }
}
