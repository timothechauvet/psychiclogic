/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.*;

/**
 *
 * @author remyc
 */
public class Psychiclogic extends MySQLConnector {

    public Psychiclogic () {
        super();
        this.openConnection();
    }

    
    public void seePatients () {
        String rqt = "SELECT * FROM Patient";
        executeRequest(rqt);
        System.out.println("\n\nPK\t\t mail\t\t pswrd\t\t fname\t\t 2fname\t\t name \t\taddress \t\tBDate \t\tmeeting");
        displayResultSet();
    }



    public void seeRDVs (String SDate, String EDate) {
        /*gets all rendez-vous' happening between two timestamps : YYY-MM-DD*/
        String rqt = "";
        if (SDate != "" && EDate != "") {
            rqt = "SELECT * FROM RDV WHERE SDate > '" + SDate + "' AND SDate < '" + EDate + "'";
        } else if (SDate != "") {
            rqt = "SELECT * FROM RDV WHERE SDate > '" + SDate + "'";
        } else if (EDate != "") {
            rqt = "SELECT * FROM RDV WHERE SDate < '" + EDate + "'";
        }
        else rqt = "SELECT * FROM RDV";

        if (rqt != "") {
            executeRequest(rqt);
            System.out.println("\n\nPK\t\t SDate\t\t montant\t\t moyenPayment");
            displayResultSet();
        }
    }



    public void seeRDVsPatient (String patientMail) {
        String rqt = "SELECT Patient.name, RDV.SDate"
                + " FROM Participation"
                + " JOIN Patient ON Patient.PK_Patient = Participation.FK_Patient"
                + " WHERE Patient.mail = '"+patientMail+"'";
        this.executeRequest(rqt);
        System.out.println("RDVs for patient with mail:\t" + patientMail);
        this.displayResultSet();
    }

}
