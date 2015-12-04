/*
 * CMIS 440
 * mySqlUTIL.java
 * Rolodex Database Final
 * 10 OCT 2015
 * Schulze, Brent
 */
package databaseConnector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//database connector class
public class mySqlUTIL 
{

    private static Connection connection = null;

    public static Connection getConnection() 
    {
        if (connection != null)
            return connection;
        else 
        {
            try 
            {
                //sets method to retrieve driver, url, username, and password from file
                Properties prop = new Properties();
                InputStream inputStream = mySqlUTIL.class.getClassLoader().getResourceAsStream("/mySQL.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } 
            catch (ClassNotFoundException e) 
            {
                e.printStackTrace();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
            catch (FileNotFoundException e) 
            {
                e.printStackTrace();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
