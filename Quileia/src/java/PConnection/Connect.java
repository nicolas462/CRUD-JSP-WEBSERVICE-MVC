package PConnection;

import java.sql.*;

/**
 *
 * @author Nicolas
 */
public class Connect 
{
    Connection con;

    private String url = "jdbc:mysql://localhost:3306/quileia";
    private String user = "root";
    private String password = "";

    public Connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);            
        } catch (Exception ex) {System.out.println("Error conexión; " + ex);}
    }    
    
    public Connection getConnection() 
    {
        return con;
    }
}
