package welcome;

import java.io.Serializable;

public class Patient implements Serializable {
    private int pk_patient;
    private String mail;
    private String prenom;
    private String prenom2;
    private String nom;
    private String adresse;
    private String dnaissance;
    private String moyenrencontre;

    public int getPk_patient() {
        return pk_patient;
    }

    public String getMail() {
        return mail;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPrenom2() {
        return prenom2;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDnaissance() {
        return dnaissance;
    }

    public String getMoyenrencontre() {
        return moyenrencontre;
    }

    public Patient(int pk_patient, String mail, String prenom, String prenom2, String nom, String adresse, String dnaissance, String moyenrencontre) {
        this.pk_patient = pk_patient;
        this.mail = mail;
        this.prenom = prenom;
        this.prenom2 = prenom2;
        this.nom = nom;
        this.adresse = adresse;
        this.dnaissance = dnaissance;
        this.moyenrencontre = moyenrencontre;
    }
}
