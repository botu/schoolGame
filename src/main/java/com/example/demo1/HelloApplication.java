package com.example.demo1;

import com.example.demo1.model.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group group = new Group();

        Label label = new Label("some text");

        Player player = new Player(100d,900d,30d);

        player.addToStage(group);

        player.testMove();



        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                player.move();
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask,100L,100L);


        group.getChildren().add(label);


        group.setOnKeyPressed(
                keyEvent -> {}
        );


        Scene scene = new Scene(group, 1000, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}