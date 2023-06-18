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
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Our Mission</title>";

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
                <h1>Our Mission</h1>
            </div>
        """;
        
 html = html+"""

        <h4>The urgent global concern of climate change is being addressed through a web application created using Java.
        This Java-based programme provides a collaborative environment to spread knowledge, provide resources, and encourage sustainable practices.  
        programme gives users access to the most recent information on climate change, including resources, scientific research, and news. 
        Additionally, it provides tailored advice on how people might lessen their environmental effects. The programme uses interactive maps, 
        data visualisations, and chatbot support to engage users and aids in their awareness of climate change concerns by using Java's flexibility and
        scalability. The online application helps to encourage environmental awareness and climate change mitigation via its Java-based implementation.</h2>
         
         
        <h2>Social Challenges</h2>

        <h2>Personas</h2>
        <div class='personas'>
        <div class = 'persona'>
        <img src='pic1.jpeg' alt='Persona' height='75'>
        <p>Person 1: Tony Edward</p>

         <div class = 'persona'>
        <img src='pic2.jpeg' alt='Persona' height='75'>
        <p>Person 1: Kushar Bajaj</p>

        <div class = 'persona'>
        <img src='pic3.jpeg' alt='Persona' height='75'>
        <p>Person 1: David John</p>

        <button type='submit' onclick='description()'> Discription about Persona </button>

       

        -----------------------------------------
        -------------------------------------------
        -----------------------------""";

        // Add HTML for the page content
        html = html+ """
            <p>Subtask 2.B page content</p>
            """;

        // Close Content div
        html = html+ "</div>";

        html = html+"""
         <script>
         function description(){

            alert(' Persona 1:\\nName: Tony Edward\\nDescription/Attributes:\\n• Tony is 35 years old, and he is Australian.\\n• He is married for 15 years and have 2 children.\\n• He is a marine engineer and working.\\n• Do consistent in discussion.\\n• His father was a marine worker, and he loved the sea and water animals and his child\\nhood was on coastal areas.\\nNeeds:\\nTony is debating climate change deniers and wants to change their views and show just how\\nendangered our world is, and he wants it.\\n• He got all the relevant and reliable information on the website because he doesn’t\\nhave time to do his own research.\\n• Dynamic graphics that can touch people’s emotions, Tony believes that deniers\\nmay not like the science of climate change and showing them the effects through\\nimages can help.\\n• The website must be easy to navigate during the presentation because it is quite\\ntechnical.\\nGoals:\\n• He wants to convince climate change deniers that climate change is real and\\npervasive.\\n• He wants to contribute to minimizing the damage caused by climate change.\\n• He is trying to protect all aquatic animals and their habitats.\\nSkills/Experience:\\n• Have a master’s in marine engineering.\\n• He is persuasive.\\n• He already have work experience.\\nPersona 2\\nName: David John\\nDescription/Attributes:\\n• He is 27 years old single.\\n• He is curious and likes to learn new things.\\n• Friendly and use every opportunity to help those in\\nneed and he is caring.\\n• He works part-time at Coles while studying for his\\nBachelor’s in Climate Science at Deakin University.\\n• He is Australian\\nNeeds:\\nDavid has a project due soon which he needs to find climate change and the effects\\nand the reason for the increasing of ocean temperature.\\n• Need to create an relevant data that shows temperature changes in various\\noceans.\\n• Websites that provide this data\\n• Need to create a website about the climate change and makes everyone easy\\nto understand.\\nGoals:\\n• David wants to finish his project on time and get a good grade.\\n• Wants to reduce the death of water animals because of the various change of climate\\nchange and difference in ocean temperature.\\n• Wants to do Masters.\\nSkills:\\n• Skilled with researching and studying new things with the help of Internet.\\n• Has a experience to make a website and knows coding.\\nPersona 3\\nName: Kushar Bajaj\\nDescription/Attributes:\\n• He is 20 years old single.\\n• He is curious and likes to learn new things about\\nthe environment.\\n• Friendly in Nature and loves planting trees in his free time.\\n• He works part-time at NGO while studying for his Bachelor’s in\\nEnvironmental Science at Indian Institute of Technology, Delhi.\\n• He is an Indian.\\nNeeds:\\nKushar has a press conference due soon about so, he needs to find climate change and the effects and\\nthe reason for the increasing of ocean temperature.\\n• He needs to find out about the data regarding climate change\\n• Need to create a website about climate change and make it easy for everyone to understand.\\nGoals:\\n• Wants to reduce the death of water animals because of the various change of climate change\\nand difference in ocean temperature.\\n• He wants to make his own organization that is working solely on the climate change and\\nincreasing ocean temperatures.\\nSkills:\\n• Skilled Public speaker\\n• Knows the emotion of the masses and knows how to meld the thinking of the youth.');
        
        }
         </script>
                
                """;


        // This example uses JDBC to lookup the LGAs
        JDBCConnection jdbc = new JDBCConnection();

        // Next we will ask this *class* for the LGAs
        ArrayList<LGA> lgas = jdbc.getLGAs2016();

        // Add HTML for the LGA list
        html = html + "<h1>All 2016 LGAs in the CTG database (using JDBC Connection)</h1>" + "<ul>";

        // Finally we can print out all of the LGAs
        for (LGA lga : lgas) {
            html = html + "<li>" + lga.getCode()
                        + " - " + lga.getName() + "</li>";
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

}
