
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Match {
    List<Soldier> soldiers = new ArrayList<>();


    public void SQL() {

        Connection myConn;
        Statement myStmt;
        ResultSet myRs;

        String dbUrl = "jdbc:mysql://localhost:3306/java_kombat_harakat";
        String user = "root";
        String pass = "Srood123";

        try {

            myConn = DriverManager.getConnection(dbUrl, user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from fighters");

            while (myRs.next()) {
                soldiers.add(new Soldier(myRs.getString("name"), myRs.getString("motto")));
            }

            Collections.shuffle(soldiers);
            System.out.println("Kombat beginns with " + soldiers.size() + " fighters!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalFighters() {
        return soldiers.size();
    }
}