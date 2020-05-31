package welcome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import MySQL.Psychiclogic;

import MySQL.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setTitle("Psychiclogic");
        primaryStage.setScene(new Scene(root, 1143, 727));
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {

        Psychiclogic psy = new Psychiclogic();

        psy.seePatients();

        psy.seeRDVs("", "");
        psy.seeRDVs("2000-01-01", "2010-01-01");
        psy.seeRDVs("2010-01-01", "");

        //psy.seeRDVsPatient("b.b@mail.com");

        psy.closeConnection();


        // TODO Auto-generated method stub
        //launch(args);
    }

}
