package welcome;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btn_patients;
    @FXML
    private Button btn_settings;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_logout;
    @FXML
    private Button btn_calendar;
    @FXML
    private Button btn_addpatient;

    @FXML
    private void handleButtonClick(javafx.event.ActionEvent mouseEvent)
    {
        if(mouseEvent.getSource() == btn_patients)
        {
            LoadStages("/welcome/patients.fxml");
        } else
        if(mouseEvent.getSource() == btn_settings)
        {
            new FXMLLoader(getClass().getResource("welcome/settings.fxml"));
        } else
        if(mouseEvent.getSource() == btn_update)
        {
            new FXMLLoader(getClass().getResource("welcome/update.fxml"));
        } else
        if(mouseEvent.getSource() == btn_logout)
        {
            new FXMLLoader(getClass().getResource("welcome/signin.fxml"));
        } else
        if(mouseEvent.getSource() == btn_calendar)
        {
            new FXMLLoader(getClass().getResource("welcome/calendar.fxml"));
        } else
        if(mouseEvent.getSource() == btn_addpatient)
        {
            new FXMLLoader(getClass().getResource("welcome/addpatient.fxml"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void LoadStages(String fxml)  {
        try{
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
