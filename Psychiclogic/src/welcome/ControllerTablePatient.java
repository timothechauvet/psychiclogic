package welcome;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablePatient implements Initializable {

    @FXML
    private TableView<Patient> patients_table;
    @FXML
    public TableColumn<Patient, Integer> t_id;
    @FXML
    public TableColumn<Patient, String> t_email;
    @FXML
    public TableColumn<Patient, String> t_prenom;
    @FXML
    public TableColumn<Patient, String> t_2eprenom;
    @FXML
    public TableColumn<Patient, String> t_nom;
    @FXML
    public TableColumn<Patient, String> t_adresse;
    @FXML
    public TableColumn<Patient, String> t_naissance;
    @FXML
    public TableColumn<Patient, String> t_rencontre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        t_id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("pk_patient"));
        t_email.setCellValueFactory(new PropertyValueFactory<Patient, String>("mail"));
        t_prenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
        t_2eprenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom2"));
        t_nom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        t_adresse.setCellValueFactory(new PropertyValueFactory<Patient, String>("adresse"));
        t_naissance.setCellValueFactory(new PropertyValueFactory<Patient, String>("dnaissance"));
        t_rencontre.setCellValueFactory(new PropertyValueFactory<Patient, String>("moyenrencontre"));
        //add your data to the table here.
        patients_table.setItems(patientsModels);
    }

    private ObservableList<Patient> patientsModels = FXCollections.observableArrayList(
            new Patient(new SimpleIntegerProperty(1),new SimpleStringProperty("b.b@mail.com"), new SimpleStringProperty("Billy"), new SimpleStringProperty(""), new SimpleStringProperty("McGregor"), new SimpleStringProperty("1 allée de la peine"), new SimpleStringProperty("2003-02-01"), new SimpleStringProperty("Une brochure")),
            new Patient(new SimpleIntegerProperty(4),new SimpleStringProperty("gr@gmail.com"), new SimpleStringProperty("Gregoire"), new SimpleStringProperty("Greg"), new SimpleStringProperty("Roy"), new SimpleStringProperty("Rue de la Fame"), new SimpleStringProperty("2006-06-06"), new SimpleStringProperty("internet")),
            new Patient(new SimpleIntegerProperty(6),new SimpleStringProperty("jc@hotmail.fr"), new SimpleStringProperty("Jesus"), new SimpleStringProperty("God"), new SimpleStringProperty("Christ"), new SimpleStringProperty("heaven"), new SimpleStringProperty("0000-01-01"), new SimpleStringProperty("Bible"))
    );
/*
    // add your data here from any source

    */
}
