package Lesson_7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Start {
    public static void main(String[] args) {
        UserInterfaceView userInterfaceView = new UserInterfaceView();

        userInterfaceView.runInterface();
    }
}
