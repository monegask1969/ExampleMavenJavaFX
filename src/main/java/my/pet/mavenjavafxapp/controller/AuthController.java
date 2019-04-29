package my.pet.mavenjavafxapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label username;

    @FXML
    private Label sec;

    @FXML
    void initialize() {



    }

    public void transferMessage(String message, int timer) {
        username.setText(message);

        new Thread(() ->{
            Integer STARTTIME = timer;
            IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

            sec.textProperty().bind(timeSeconds.asString());
            sec.setTextFill(Color.RED);

            timeSeconds.set(STARTTIME);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.seconds(STARTTIME-1),
                            new KeyValue(timeSeconds, 0)));
            timeline.setOnFinished(e -> returnToMainController());
            timeline.playFromStart();


            if(sec.getText().equals("0")){
                returnToMainController();
            }
        }).start();

    }

    public void returnToMainController(){
        sec.getScene().getWindow().hide();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/hello.fxml"));
            Parent root = loader.load();

            MainController mainController = loader.getController();
            mainController.initialize();


            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login Test App");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }




