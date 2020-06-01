package welcome;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Patient implements Serializable {
    private SimpleIntegerProperty pk_patient;
    private SimpleStringProperty mail;
    private SimpleStringProperty prenom;
    private SimpleStringProperty prenom2;
    private SimpleStringProperty nom;
    private SimpleStringProperty adresse;
    private SimpleStringProperty dnaissance;
    private SimpleStringProperty moyenrencontre;

    public Patient(SimpleIntegerProperty pk_patient, SimpleStringProperty mail, SimpleStringProperty prenom, SimpleStringProperty prenom2, SimpleStringProperty nom, SimpleStringProperty adresse, SimpleStringProperty dnaissance, SimpleStringProperty moyenrencontre) {
        this.pk_patient = pk_patient;
        this.mail = mail;
        this.prenom = prenom;
        this.prenom2 = prenom2;
        this.nom = nom;
        this.adresse = adresse;
        this.dnaissance = dnaissance;
        this.moyenrencontre = moyenrencontre;
    }

    public int getPk_patient() {
        return pk_patient.get();
    }

    public SimpleIntegerProperty pk_patientProperty() {
        return pk_patient;
    }

    public String getMail() {
        return mail.get();
    }

    public SimpleStringProperty mailProperty() {
        return mail;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public String getPrenom2() {
        return prenom2.get();
    }

    public SimpleStringProperty prenom2Property() {
        return prenom2;
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public String getAdresse() {
        return adresse.get();
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public String getDnaissance() {
        return dnaissance.get();
    }

    public SimpleStringProperty dnaissanceProperty() {
        return dnaissance;
    }

    public String getMoyenrencontre() {
        return moyenrencontre.get();
    }

    public SimpleStringProperty moyenrencontreProperty() {
        return moyenrencontre;
    }
}
