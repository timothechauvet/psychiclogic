package welcome;

import MySQL.MySQLConnector;
import MySQL.Psychiclogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    //TABLE VIEW AND DATA
    private ResultSet data;
    private TableView tableview;
    private MySQLConnector m;
    private Psychiclogic p;

    @FXML
    private void handleButtonClick(javafx.event.ActionEvent mouseEvent) throws SQLException {
        if(mouseEvent.getSource() == btn_patients)
        {
            LoadStages("/welcome/patients.fxml");
        } else
        if(mouseEvent.getSource() == btn_settings)
        {
            LoadStages("welcome/settings.fxml");
        } else
        if(mouseEvent.getSource() == btn_update)
        {
            LoadStages("welcome/update.fxml");
        } else
        if(mouseEvent.getSource() == btn_logout)
        {
            LoadStages("welcome/signin.fxml");
        } else
        if(mouseEvent.getSource() == btn_calendar)
        {
            LoadStages("welcome/calendar.fxml");
        } else
        if(mouseEvent.getSource() == btn_addpatient)
        {
            LoadStages("welcome/addpatient.fxml");
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
