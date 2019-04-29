package my.pet.mavenjavafxapp.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import my.pet.mavenjavafxapp.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton one;

    @FXML
    private JFXButton two;

    @FXML
    private JFXButton three;

    @FXML
    private JFXButton four;

    @FXML
    private JFXButton five;

    @FXML
    private JFXButton six;

    @FXML
    private JFXButton seven;

    @FXML
    private JFXButton eight;

    @FXML
    private JFXButton nine;

    @FXML
    private JFXButton zero;

    @FXML
    private JFXButton clear;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton login;

    @FXML
    private JFXPasswordField psw;

    @FXML
    private BorderPane mainPane;

    @FXML
    private StackPane stackPane;

    @FXML
    private ImageView image;

    @FXML
    public void initialize(){

        String s = "/assets/sddefault1.jpg";
        InputStream inputStream = getClass().getResourceAsStream(s);

        Image img = new Image(inputStream);

        image.setImage(img);

        User user1 = new User("Petya","0000",10);
        User user2 = new User("Volodya","5555",20);

        Map<String,User> userMap = new HashMap();
        userMap.put(user1.getPassword(), user1);
        userMap.put(user2.getPassword(), user2);

        login.setOnAction(event -> {
            System.out.println(psw.getText());

            String password = psw.getText();
            User user = userMap.get(password);

            if (password.isEmpty() || user == null){

                JFXDialogLayout layout = new JFXDialogLayout();
                layout.setHeading(new Text("Incorrect password"));
                layout.setBody(new Text("Please, use another password!"));
                JFXDialog jfxDialog = new JFXDialog(stackPane, layout,JFXDialog.DialogTransition.CENTER);


                JFXButton button = new JFXButton("Okay");
                button.setOnAction(e ->{
                    jfxDialog.close();
                });
                layout.setActions(button);
                jfxDialog.show();
                System.out.println("INCORRECT PASSWORD");
            }

           else if (!password.isEmpty() && user!= null) {

                //new screen load
                login.getScene().getWindow().hide();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcome.fxml"));
                    Parent root = loader.load();

                    //Get controller of scene2
                    AuthController authController = loader.getController();
                    authController.transferMessage(userMap.get(psw.getText()).getUsername(), userMap.get(psw.getText()).getTimer());


                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Welcome, " + userMap.get(psw.getText()).getUsername() + " !");
                    stage.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        back.setOnAction(event -> {
            String Lpsw = psw.getText();
            if(!Lpsw.isEmpty()){
                Lpsw = Lpsw.substring(0,Lpsw.length()-1);
                psw.setText(Lpsw);
            }


        });

        clear.setOnAction(event -> {
            psw.clear();
        });

        one.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "1";
            psw.setText(Lpsw);
        });

        two.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "2";
            psw.setText(Lpsw);
        });

        three.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "3";
            psw.setText(Lpsw);
        });

        four.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "4";
            psw.setText(Lpsw);
        });

        five.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "5";
            psw.setText(Lpsw);
        });

        six.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "6";
            psw.setText(Lpsw);
        });

        seven.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "7";
            psw.setText(Lpsw);
        });

        eight.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "8";
            psw.setText(Lpsw);
        });

        nine.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "9";
            psw.setText(Lpsw);
        });

        zero.setOnAction(event -> {
            String Lpsw = psw.getText();
            Lpsw = Lpsw + "0";
            psw.setText(Lpsw);
        });
    }


}
