package main;

import MySQL.MySQLConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MySQLConnector msqlc = new MySQLConnector();
        Connection conn = msqlc.openConnection();
        
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from Patient");
            while(rs.next())
            {
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException sqle) {
           System.out.println(sqle);
        }
        
        msqlc.closeConnection();
        
        
        /*try {
            Statement stmt = conn.createStatement();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }*/
        
        //Connection on = connect ();
    }

    
    
    public static Connection connect () {
        try {           
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:8080/psychiclogic", "root","");
            /*access port for xampp BD: 3306*/
            /*access port for wamp BD: 8080*/
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from User");
            while(rs.next())
            {
                System.out.println(rs.getString("Num_com"));
            }
            return cn;
        }
        catch (SQLException sqle) {
           System.out.println(sqle);
        }
        return null;
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
