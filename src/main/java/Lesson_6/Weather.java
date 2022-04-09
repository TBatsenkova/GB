package Lesson_6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Weather {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "api.openweathermap.org";
    private static final String DATA = "data";
    private static final String VERSION = "2.5";
    private static final String FORECAST = "forecast";
    private static final String DAYS = "5";
    //private static final String latitude = "55.75396";
    //private static final String longitude = "37.620393";
    private static final String CITY = "Moscow";
    private static final String UNITS = "metric";
    private static final String LANGUAGE = "ru";
    private static final String API_KEY = "51aef6a1eaf8bda4691e0933c5973c08";

    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST)
                //.addQueryParameter("lat",latitude)
                //.addQueryParameter("lon",longitude)
                .addQueryParameter("q", CITY)
                .addQueryParameter("cnt", DAYS)
                .addQueryParameter("lang", LANGUAGE)
                .addQueryParameter("appid",API_KEY)
                .addQueryParameter("units",UNITS)
                .build();

        System.out.println(httpUrl.toString());

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.isSuccessful());

        String responseBody = response.body().string();

        System.out.println(responseBody);

    }
}
