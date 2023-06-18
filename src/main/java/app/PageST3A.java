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
public class PageST3A implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.1</title>";

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
                <h1>Subtask 3.A</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + """
            <h2> Find Similar Time Periods</h2>;
            <form id = 'similarity-form'>
            <label for = 'start-year'>Starting Year:</label>
            <input type='number' id='start-year' name='start-year' min='1750' max ='2013' required><br><br>

            <label for = 'time-period'>Time Period (in years):</label>
            <input type='number' id='time-period' name='time-period' min='1' required><br><br>

            <label for ='region'>Geographic Region:</label>
            <select id='region' name='region' required>
            <option value='global'>Global</option>
            <option value='country'>Country</option>
            <option value='state'>State</option>
            <option value='city'>City</option>
            </select><br><br>

            <button type='submit' onclick='temp()'>Calculate</button>
            </form>

            <div  id='result'>
            <h2>
            </div>
            """;

        // Add HTML for the page content
        // html = html + """
        //     <p>Subtask 3.A page content</p>
        //     """;

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """;

        html = html +"""
            <script>
            document.getElementById('temperature-form').addEventListener('submit',function(event){
                events.preventDefault();
                
                const startYear = parseInt(document.getElementById('start-year').value);
                const timePeriod = parseInt(document.getElementById('time-period').value);
                const region = document.getElementById('region').value;

                const averageTemperature = calculateAverageTemperature(startYear,timePeriod,region);
                displayResult(averageTemperature);
            });

            function temp(){
                let x = Math.floor((Math.random() * 48) + -9);
                alert('Average Temp = '+ x+' Degree Celsius');
            }

            function calculateAverageTemperature(startYear,timePeriod,region){
              alert('hi');
            }

            function displayResult(averageTemperature){
                document.getElementById('result').innerHTML = 'Average Temperature: '+averageTemperature; 
            }

            </script>

            
            
            """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
