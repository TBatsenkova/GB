package Lesson_7.Entity;

import Lesson_7.Entity.City;
import Lesson_7.Entity.SituateWeather;

import java.util.List;

public class WeatherResponse {
    String cod;
    Integer message;
    Integer cnt;
    List<SituateWeather> list;
    City city;

    // конструкторы и геттеры
    public WeatherResponse() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<SituateWeather> getList() {
        return list;
    }

    public void setList(List<SituateWeather> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isEmpty(){
        return this.city == null || this.list == null;
    }

    // преобразование в строку
    @Override
    public String toString() {
        if (isEmpty()) return "";
        String result = "Прогноз погоды " +
                " в городе " + getCity() + getList();
        return result.replace("[","").replace("]","");
    }
}
