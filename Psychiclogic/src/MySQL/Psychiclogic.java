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
    /*
    /*inherited attributs should not need to be implemented in child class but JAVA/InteliJ seems to hate me so...
    //JDBC driver name and database URL
    protected String JDBC_DRIVER;
    protected String DB_URL;
    //Database credentials
    protected String USER;
    protected String PASS;
    protected Connection conn;
    //Interraction with database
    protected Statement stmnt;
    protected ResultSet rslt;
    */



    public Psychiclogic () {
        super();
        this.openConnection();
    }

    
    public void seePatients () {
        String rqt = "SELECT * FROM Patient";
        try {
            stmnt = conn.createStatement();
            rslt = stmnt.executeQuery(rqt);

            System.out.println("\n\nPK\t\t mail\t\t pswrd\t\t fname\t\t 2fname\t\t name \t\taddress \t\tBDate \t\tmeeting");
            rslt.beforeFirst();     //not rs.first() because the rs.next() below will move on, missing the first element
            while (rslt.next()) {
                System.out.println();
                for (int i=1; i<=rslt.getMetaData().getColumnCount(); i++) {
                    System.out.print(rslt.getString(i)+"\t\t ");
                }
            }
            rslt.close();
            stmnt.close();
        }
        catch (SQLException sqle) {
           System.out.println("\nERROR:\tCould not satisfy request: \n\t" + rqt);
           sqle.printStackTrace();
        }
    }


    /*public void seeRDVs () {
        String rqt = "SELECT * FROM RDV";
        try {
            stmnt = conn.createStatement();
            rslt = stmnt.executeQuery(rqt);

            System.out.println("\n\nPK\t\t SDate\t\t montant\t\t moyenPayment");
            rslt.beforeFirst();     //not rs.first() because the rs.next() below will move on, missing the first element
            while (rslt.next()) {
                System.out.println();
                for (int i=1; i<=rslt.getMetaData().getColumnCount(); i++) {
                    System.out.print(rslt.getString(i)+"\t\t ");
                }
            }
            rslt.close();
            stmnt.close();
        }
        catch (SQLException sqle) {
           System.out.println("\nERROR:\tCould not satisfy request: \n\t" + rqt);
           sqle.printStackTrace();
        }
    }*/

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
            try {
                stmnt = conn.createStatement();
                rslt = stmnt.executeQuery(rqt);

                System.out.println("\n\nPK\t\t SDate\t\t montant\t\t moyenPayment");
                rslt.beforeFirst();     //not rs.first() because the rs.next() below will move on, missing the first element
                while (rslt.next()) {
                    System.out.println();
                    for (int i = 1; i <= rslt.getMetaData().getColumnCount(); i++) {
                        System.out.print(rslt.getString(i) + "\t\t ");
                    }
                }
                rslt.close();
                stmnt.close();
            } catch (SQLException sqle) {
                System.out.println("\nERROR:\tCould not satisfy request: \n\t" + rqt);
                sqle.printStackTrace();
            }
        }
    }

}
