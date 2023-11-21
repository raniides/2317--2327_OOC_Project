
package rv.hotel.management;
import java.sql.*;  
/**
 *
 * @author raani
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "Ranisona@13"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}
