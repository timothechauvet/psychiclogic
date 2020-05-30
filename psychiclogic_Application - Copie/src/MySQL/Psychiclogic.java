/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.SQLException;

/**
 *
 * @author remyc
 */
public class Psychiclogic extends MySQLConnector{
    
    public Psychiclogic () {
       super();
       this.openConnection();
   }
    
    
    public void seePatients () {
        String rqt = "SELECT * FROM Patient";
        try {
            stmnt = conn.createStatement();
            rslt = stmnt.executeQuery(rqt);
            
            int countRows = this.getNbrRows_ResultSet(rslt);
            System.out.println("i = " + countRows);
            System.out.println("CCount = " + rslt.getMetaData().getColumnCount());
            
            System.out.println("PK\t\t mail\t\t pswrd\t\t fname\t\t 2fname\t\t name \t\taddress \t\tBDate \t\tmeeting");
            rslt.beforeFirst();     //not rs.first() because the rs.next() below will move on, missing the first element
            while (rslt.next()) {
                System.out.println();
                for (int i=1; i<=rslt.getMetaData().getColumnCount(); i++) {
                    /*System.out.print(rslt.getString(1)
                        +"\t"+ rslt.getString(2)
                        +"\t"+ rslt.getString(3));*/
                    System.out.print(rslt.getString(i)+"\t\t");
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
    
}
