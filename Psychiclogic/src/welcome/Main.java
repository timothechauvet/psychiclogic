package welcome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import MySQL.MySQLConnector;
import MySQL.Psychiclogic;

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
        launch(args);

        // TODO Auto-generated method stub
        
        //connectionTest ();
        
        
        Psychiclogic psy = new Psychiclogic();
        psy.seePatients();
    }

    public static void connect () {
        MySQLConnector msqlc = new MySQLConnector();
        msqlc.openConnection();
        
        
        msqlc.executeRequest("SELECT * FROM Patient");  
        
        //Create a RDV
        msqlc.executeRequest("INSERT INTO rdv"
            + " (SDate)"
            + " VALUES (2003-02-01)");
        
        
        msqlc.closeConnection();
    }
    
    
    /*
    public static void viewTable(Connection con, String dbName) throws SQLException {
        Statement stmt = null;
        String query = "select COF_NAME, SUP_ID, PRICE, " +
                       "SALES, TOTAL " +
                       "from " + dbName + ".COFFEES";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
         = rs.getString("COF_NAME");
         Statement stmt = nullZName
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + "\t" + supplierID +
                                   "\t" + price + "\t" + sales +
                                   "\t" + total);
            }
        } catch (SQLException e ) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) stmt.close();}
        }
    }*/
}
