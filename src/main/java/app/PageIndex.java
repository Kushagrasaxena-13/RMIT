package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Climalie</title>";

             
        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
       
        
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>
                 <img src='https://cdn-icons-png.flaticon.com/512/5208/5208410.png' class='top-image' alt='logo' height='135'>;
<h2 style='color:black;text-align:top-left; font-size: 1cm;position: relative;'>Climalie</h2>;
                    <img src='logo.png' class='top-image' alt='RMIT logo' height='75'>
                    Homepage
                </h1>
            </div>
        """;

      StringBuilder htmlBuilder = new StringBuilder();

        // Retrieve the corresponding world population and temperature during these years
        

        // Display the information to the user
        html = html +"""
         <h2>Welcome to our Website!</h2>
            <p>Here, you will find information about population and temperature data.</p>
        <div class='content'>
                <img src='https://images.unsplash.com/photo-1552799446-159ba9523315?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80' alt='Ocean and Land Temperature' style='display: block; margin: 0 auto; border: 1px solid #ccc; width: 100%; max-width: 800px; height: auto;'>
            </div><br><br>

                <h3> Data Summary:
                <p>Year Range for Available Data: 1750 - 2013
                </p>
                <p>World Population during this Period: 3745.0 - 4307.82 
                </p>
                <p>Temperature during this Period: 19.0 - 22.0 
                </p>
                <p>Total Number of Years of Available Data: 264 """;
                

        // Close Content div
        

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <p>Homepage content</p>
            """;

        // Get the ArrayList of Strings of all LGAs
        ArrayList<String> lgaNames = getLGAs2016();

        // Add HTML for the LGA list
        html = html + "<h1>All 2016 LGAs in the CTG database</h1>" + "<ul>";

        // Finally we can print out all of the LGAs
        for (String name : lgaNames) {
            html = html + "<li>" + name + "</li>";
        }

        // Finish the List HTML
        html = html + "</ul>";

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }


    /**
     * Get the names of the LGAs in the database.
     */
    public ArrayList<String> getLGAs2016() {
        // Create the ArrayList of LGA objects to return
        ArrayList<String> lgas = new ArrayList<String>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(JDBCConnection.DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA WHERE year='2016'";
            
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                String name16  = results.getString("name");

                // Add the lga object to the array
                lgas.add(name16);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }
}
