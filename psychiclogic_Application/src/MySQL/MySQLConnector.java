/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author remyc
 */
public class MySQLConnector {
    //JDBC driver name and database URL
    private String JDBC_DRIVER;  
    private String DB_URL;
    //Database credentials
    private String USER;
    private String PASS;
    private Connection conn;
    //Interraction with database
    private Statement stmnt;
    private ResultSet rslt;
    
    /*Classe                            Rôle
    DriverManager                       Charger et configurer le driver de la base de données.
    Connection                          Réaliser la connexion et l'authentification à la base de données.
    Statement (et PreparedStatement)	Contenir la requête SQL et la transmettre à la base de données.
    ResultSet                           Parcourir les informations retournées par la base de données dans le cas d'une sélection de données*/
    
    
    public MySQLConnector () {
        this.JDBC_DRIVER = "com.mysql.jdbc.Driver";
        this.DB_URL = "jdbc:mysql://localhost:3308/psychiclogic";
            /*for me it seems to be port 3308*/
            /*access port for xampp BD: 3306*/
            /*access port for wamp BD: 8080 or 8888 idk*/
            
        this.USER = "root";
        this.PASS = "";
        this.conn = null;
        
        this.stmnt = null;
        this.rslt = null;
    }
    
    
    
    public Connection openConnection () {
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Open a connection
            System.out.println("Connecting to data base\t" + DB_URL);
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection established:\t" + DB_URL);
            
            return this.conn;
        }
        catch (Exception e) {
            //Handle errors for JDBC
            System.out.println("\nERROR:\tCould not connect to database: "+DB_URL);
            e.printStackTrace();
        }
        return null;
    }
    
    
    public void executeRequest (String rqt) {
        try {
            Statement st = conn.createStatement();
                System.out.println("a");
           rslt = stmnt.executeQuery(rqt);
                System.out.println("b");
            while(rslt.next())
            {
                System.out.println(rslt.getString(1));
            }
            rslt.close();
            stmnt.close();
        }
        catch (SQLException sqle) {
           System.out.println("\nERROR:\tCould not satisfy request: \n\t" + rqt);
           System.out.println(sqle);
        }
    }
    
     
    public void closeConnection () {
        try {
            if(this.conn != null)
            conn.close();
        }
        catch (SQLException se) {
            System.out.println("\nERROR:\tCould not close database: "+DB_URL);
            se.printStackTrace();
        }
        System.out.println("Connection closed: \t"+ DB_URL);
    }
    
    
    
    
    /*Pour dialoguer avec une base de données en Java, vous devez suivre les sept étapes suivantes :
        Chargement d’un pilote JDBC
        Définition de l’URL de connexion à la base de données
        Connexion avec la base de données
        Création d’un objet Statement
        Exécution d’une requête SQL
        Traitement des résultats
        Fermeture de la connexion*/
    
    
    
    
    
    /*Results of port 3308 testing:
    ***** Test which uses port 3308 *****

    ===== Tested by command netstat filtered on port 3308 =====


    Test for TCP
    Your port 3308 is used by a processus with PID = 14696
    The processus of PID 14696 is 'mysqld.exe' Session: Services
    The service of PID 14696 for 'mysqld.exe' is 'N/A'
    N/A means that there are no service related to PID 14696
    Processus 'mysqld.exe' is launched by service 'wampmysqld64' with PID 9032

    Test for TCPv6
    Your port 3308 is used by a processus with PID = 14696
    The processus of PID 14696 is 'mysqld.exe' Session: Services
    The service of PID 14696 for 'mysqld.exe' is 'N/A'
    N/A means that there are no service related to PID 14696
    Processus 'mysqld.exe' is launched by service 'wampmysqld64' with PID 9032
    */
    
}