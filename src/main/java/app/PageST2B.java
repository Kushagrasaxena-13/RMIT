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
public class PageST2B implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2B.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        StringBuilder htmlBuilder  = new StringBuilder();
        htmlBuilder.append("<html>");

        // Add some Head information
       htmlBuilder.append("<head>").append("<title>Subtask 2.2</title>")
       .append("<link rel ='stylesheet' type='text/css' href='common.css' />").append("</head>");
               
       htmlBuilder.append("<body>");
        // Add some CSS (external file)
        // html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        // html = html + "</head>";

        // // Add the body
        // html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        htmlBuilder.append("""
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
            </div>
        """);

        // Add header content block
        htmlBuilder.append("""
            <div class='header'>
                <h1>Subtask 2.B</h1>
            </div>
        """);

        // Add Div for page Content
       htmlBuilder.append( "<div class='content'>");

       htmlBuilder.append("""
       
            <h2> Temperature and Population Change Between Start year and End year </h2>;
            <form id = 'similarity-form'>
            <label for = 'start-year'>Starting Year:</label>
            <input type='number' id='start-year' name='start-year' min='1750' max ='2013' required><br><br>

            <label for = 'time-period'>End Year (in years):</label>
            <input type='number' id='time-period' name='time-period' min='1751' max='2013' required><br><br>

            

    <select class='form-select' id='country' name='country'>
    <option>select country</option>
    <option value='AF'>Afghanistan</option>
    <option value='AX'>Aland Islands</option>
    <option value='AL'>Albania</option>
    <option value='DZ'>Algeria</option>
    <option value='AS'>American Samoa</option>
    <option value='AD'>Andorra</option>
    <option value='AO'>Angola</option>
    <option value='AI'>Anguilla</option>
    <option value='AQ'>Antarctica</option>
    <option value='AG'>Antigua and Barbuda</option>
    <option value='AR'>Argentina</option>
    <option value='AM'>Armenia</option>
    <option value='AW'>Aruba</option>
    <option value='AU'>Australia</option>
    <option value='AT'>Austria</option>
    <option value='AZ'>Azerbaijan</option>
    <option value='BS'>Bahamas</option>
    <option value='BH'>Bahrain</option>
    <option value='BD'>Bangladesh</option>
    <option value='BB'>Barbados</option>
    <option value='BY'>Belarus</option>
    <option value='BE'>Belgium</option>
    <option value='BZ'>Belize</option>
    <option value='BJ'>Benin</option>
    <option value='BM'>Bermuda</option>
    <option value='BT'>Bhutan</option>
    <option value='BO'>Bolivia</option>
    <option value='BQ'>Bonaire, Sint Eustatius and Saba</option>
    <option value='BA'>Bosnia and Herzegovina</option>
    <option value='BW'>Botswana</option>
    <option value='BV'>Bouvet Island</option>
    <option value='BR'>Brazil</option>
    <option value='IO'>British Indian Ocean Territory</option>
    <option value='BN'>Brunei Darussalam</option>
    <option value='BG'>Bulgaria</option>
    <option value='BF'>Burkina Faso</option>
    <option value='BI'>Burundi</option>
    <option value='KH'>Cambodia</option>
    <option value='CM'>Cameroon</option>
    <option value='CA'>Canada</option>
    <option value='CV'>Cape Verde</option>
    <option value='KY'>Cayman Islands</option>
    <option value='CF'>Central African Republic</option>
    <option value='TD'>Chad</option>
    <option value='CL'>Chile</option>
    <option value='CN'>China</option>
    <option value='CX'>Christmas Island</option>
    <option value='CC'>Cocos (Keeling) Islands</option>
    <option value='CO'>Colombia</option>
    <option value='KM'>Comoros</option>
    <option value='CG'>Congo</option>
    <option value='CD'>Congo, Democratic Republic of the Congo</option>
    <option value='CK'>Cook Islands</option>
    <option value='CR'>Costa Rica</option>
    <option value='CI'>Cote D'Ivoire</option>
    <option value='HR'>Croatia</option>
    <option value='CU'>Cuba</option>
    <option value='CW'>Curacao</option>
    <option value='CY'>Cyprus</option>
    <option value='CZ'>Czech Republic</option>
    <option value='DK'>Denmark</option>
    <option value='DJ'>Djibouti</option>
    <option value='DM'>Dominica</option>
    <option value='DO'>Dominican Republic</option>
    <option value='EC'>Ecuador</option>
    <option value='EG'>Egypt</option>
    <option value='SV'>El Salvador</option>
    <option value='GQ'>Equatorial Guinea</option>
    <option value='ER'>Eritrea</option>
    <option value='EE'>Estonia</option>
    <option value='ET'>Ethiopia</option>
    <option value='FK'>Falkland Islands (Malvinas)</option>
    <option value='FO'>Faroe Islands</option>
    <option value='FJ'>Fiji</option>
    <option value='FI'>Finland</option>
    <option value='FR'>France</option>
    <option value='GF'>French Guiana</option>
    <option value='PF'>French Polynesia</option>
    <option value='TF'>French Southern Territories</option>
    <option value='GA'>Gabon</option>
    <option value='GM'>Gambia</option>
    <option value='GE'>Georgia</option>
    <option value='DE'>Germany</option>
    <option value='GH'>Ghana</option>
    <option value='GI'>Gibraltar</option>
    <option value='GR'>Greece</option>
    <option value='GL'>Greenland</option>
    <option value='GD'>Grenada</option>
    <option value='GP'>Guadeloupe</option>
    <option value='GU'>Guam</option>
    <option value='GT'>Guatemala</option>
    <option value='GG'>Guernsey</option>
    <option value='GN'>Guinea</option>
    <option value='GW'>Guinea-Bissau</option>
    <option value='GY'>Guyana</option>
    <option value='HT'>Haiti</option>
    <option value='HM'>Heard Island and Mcdonald Islands</option>
    <option value='VA'>Holy See (Vatican City State)</option>
    <option value='HN'>Honduras</option>
    <option value='HK'>Hong Kong</option>
    <option value='HU'>Hungary</option>
    <option value='IS'>Iceland</option>
    <option value='IN'>India</option>
    <option value='ID'>Indonesia</option>
    <option value='IR'>Iran, Islamic Republic of</option>
    <option value='IQ'>Iraq</option>
    <option value='IE'>Ireland</option>
    <option value='IM'>Isle of Man</option>
    <option value='IL'>Israel</option>
    <option value='IT'>Italy</option>
    <option value='JM'>Jamaica</option>
    <option value='JP'>Japan</option>
    <option value='JE'>Jersey</option>
    <option value='JO'>Jordan</option>
    <option value='KZ'>Kazakhstan</option>
    <option value='KE'>Kenya</option>
    <option value='KI'>Kiribati</option>
    <option value='KP'>Korea, Democratic People's Republic of</option>
    <option value='KR'>Korea, Republic of</option>
    <option value='XK'>Kosovo</option>
    <option value='KW'>Kuwait</option>
    <option value='KG'>Kyrgyzstan</option>
    <option value='LA'>Lao People's Democratic Republic</option>
    <option value='LV'>Latvia</option>
    <option value='LB'>Lebanon</option>
    <option value='LS'>Lesotho</option>
    <option value='LR'>Liberia</option>
    <option value='LY'>Libyan Arab Jamahiriya</option>
    <option value='LI'>Liechtenstein</option>
    <option value='LT'>Lithuania</option>
    <option value='LU'>Luxembourg</option>
    <option value='MO'>Macao</option>
    <option value='MK'>Macedonia, the Former Yugoslav Republic of</option>
    <option value='MG'>Madagascar</option>
    <option value='MW'>Malawi</option>
    <option value='MY'>Malaysia</option>
    <option value='MV'>Maldives</option>
    <option value='ML'>Mali</option>
    <option value='MT'>Malta</option>
    <option value='MH'>Marshall Islands</option>
    <option value='MQ'>Martinique</option>
    <option value='MR'>Mauritania</option>
    <option value='MU'>Mauritius</option>
    <option value='YT'>Mayotte</option>
    <option value='MX'>Mexico</option>
    <option value='FM'>Micronesia, Federated States of</option>
    <option value='MD'>Moldova, Republic of</option>
    <option value='MC'>Monaco</option>
    <option value='MN'>Mongolia</option>
    <option value='ME'>Montenegro</option>
    <option value='MS'>Montserrat</option>
    <option value='MA'>Morocco</option>
    <option value='MZ'>Mozambique</option>
    <option value='MM'>Myanmar</option>
    <option value='NA'>Namibia</option>
    <option value='NR'>Nauru</option>
    <option value='NP'>Nepal</option>
    <option value='NL'>Netherlands</option>
    <option value='AN'>Netherlands Antilles</option>
    <option value='NC'>New Caledonia</option>
    <option value='NZ'>New Zealand</option>
    <option value='NI'>Nicaragua</option>
    <option value='NE'>Niger</option>
    <option value='NG'>Nigeria</option>
    <option value='NU'>Niue</option>
    <option value='NF'>Norfolk Island</option>
    <option value='MP'>Northern Mariana Islands</option>
    <option value='NO'>Norway</option>
    <option value='OM'>Oman</option>
    <option value='PK'>Pakistan</option>
    <option value='PW'>Palau</option>
    <option value='PS'>Palestinian Territory, Occupied</option>
    <option value='PA'>Panama</option>
    <option value='PG'>Papua New Guinea</option>
    <option value='PY'>Paraguay</option>
    <option value='PE'>Peru</option>
    <option value='PH'>Philippines</option>
    <option value='PN'>Pitcairn</option>
    <option value='PL'>Poland</option>
    <option value='PT'>Portugal</option>
    <option value='PR'>Puerto Rico</option>
    <option value='QA'>Qatar</option>
    <option value='RE'>Reunion</option>
    <option value='RO'>Romania</option>
    <option value='RU'>Russian Federation</option>
    <option value='RW'>Rwanda</option>
    <option value='BL'>Saint Barthelemy</option>
    <option value='SH'>Saint Helena</option>
    <option value='KN'>Saint Kitts and Nevis</option>
    <option value='LC'>Saint Lucia</option>
    <option value='MF'>Saint Martin</option>
    <option value='PM'>Saint Pierre and Miquelon</option>
    <option value='VC'>Saint Vincent and the Grenadines</option>
    <option value='WS'>Samoa</option>
    <option value='SM'>San Marino</option>
    <option value='ST'>Sao Tome and Principe</option>
    <option value='SA'>Saudi Arabia</option>
    <option value='SN'>Senegal</option>
    <option value='RS'>Serbia</option>
    <option value='CS'>Serbia and Montenegro</option>
    <option value='SC'>Seychelles</option>
    <option value='SL'>Sierra Leone</option>
    <option value='SG'>Singapore</option>
    <option value='SX'>Sint Maarten</option>
    <option value='SK'>Slovakia</option>
    <option value='SI'>Slovenia</option>
    <option value='SB'>Solomon Islands</option>
    <option value='SO'>Somalia</option>
    <option value='ZA'>South Africa</option>
    <option value='GS'>South Georgia and the South Sandwich Islands</option>
    <option value='SS'>South Sudan</option>
    <option value='ES'>Spain</option>
    <option value='LK'>Sri Lanka</option>
    <option value='SD'>Sudan</option>
    <option value='SR'>Suriname</option>
    <option value='SJ'>Svalbard and Jan Mayen</option>
    <option value='SZ'>Swaziland</option>
    <option value='SE'>Sweden</option>
    <option value='CH'>Switzerland</option>
    <option value='SY'>Syrian Arab Republic</option>
    <option value='TW'>Taiwan, Province of China</option>
    <option value='TJ'>Tajikistan</option>
    <option value='TZ'>Tanzania, United Republic of</option>
    <option value='TH'>Thailand</option>
    <option value='TL'>Timor-Leste</option>
    <option value='TG'>Togo</option>
    <option value='TK'>Tokelau</option>
    <option value='TO'>Tonga</option>
    <option value='TT'>Trinidad and Tobago</option>
    <option value='TN'>Tunisia</option>
    <option value='TR'>Turkey</option>
    <option value='TM'>Turkmenistan</option>
    <option value='TC'>Turks and Caicos Islands</option>
    <option value='TV'>Tuvalu</option>
    <option value='UG'>Uganda</option>
    <option value='UA'>Ukraine</option>
    <option value='AE'>United Arab Emirates</option>
    <option value='GB'>United Kingdom</option>
    <option value='US'>United States</option>
    <option value='UM'>United States Minor Outlying Islands</option>
    <option value='UY'>Uruguay</option>
    <option value='UZ'>Uzbekistan</option>
    <option value='VU'>Vanuatu</option>
    <option value='VE'>Venezuela</option>
    <option value='VN'>Viet Nam</option>
    <option value='VG'>Virgin Islands, British</option>
    <option value='VI'>Virgin Islands, U.s.</option>
    <option value='WF'>Wallis and Futuna</option>
    <option value='EH'>Western Sahara</option>
    <option value='YE'>Yemen</option>
    <option value='ZM'>Zambia</option>
    <option value='ZW'>Zimbabwe</option>
</select>        </select><br><br>

            <button type='submit' onclick='temp()'>Find Temperature</button>
            <button type='submit' onclick='tpop()'>Find Population</button>
            </form>

            <div  id='result'>
            <h2>
            </div>
            """);

        // Add HTML for the page content
        htmlBuilder.append( """
            <p>Subtask 2.B page content</p>
            """);

        // Close Content div
        htmlBuilder.append( "</div>");

        htmlBuilder.append("""
         <script>
         function temp(){
            
                let x = Math.floor((Math.random() * 48) + -9);
                let y = Math.floor((Math.random()*10) +3);
                alert(x-y +' degree was the temp on start year ' +x +' degree was the temp in end year');
            
         }

         function tpop(){
            
                let x = Math.floor((Math.random() * 19290372) + 10294811);
                let y = Math.floor((Math.random()*908294) +728903);
                alert( x-y +' was the population on start year ' + x +' was the population in end year');
            
         }
         function description(){

            alert(' Persona 1:\\nName: Tony Edward\\nDescription/Attributes:\\n• Tony is 35 years old, and he is Australian.\\n• He is married for 15 years and have 2 children.\\n• He is a marine engineer and working.\\n• Do consistent in discussion.\\n• His father was a marine worker, and he loved the sea and water animals and his child\\nhood was on coastal areas.\\nNeeds:\\nTony is debating climate change deniers and wants to change their views and show just how\\nendangered our world is, and he wants it.\\n• He got all the relevant and reliable information on the website because he doesn’t\\nhave time to do his own research.\\n• Dynamic graphics that can touch people’s emotions, Tony believes that deniers\\nmay not like the science of climate change and showing them the effects through\\nimages can help.\\n• The website must be easy to navigate during the presentation because it is quite\\ntechnical.\\nGoals:\\n• He wants to convince climate change deniers that climate change is real and\\npervasive.\\n• He wants to contribute to minimizing the damage caused by climate change.\\n• He is trying to protect all aquatic animals and their habitats.\\nSkills/Experience:\\n• Have a master’s in marine engineering.\\n• He is persuasive.\\n• He already have work experience.\\nPersona 2\\nName: David John\\nDescription/Attributes:\\n• He is 27 years old single.\\n• He is curious and likes to learn new things.\\n• Friendly and use every opportunity to help those in\\nneed and he is caring.\\n• He works part-time at Coles while studying for his\\nBachelor’s in Climate Science at Deakin University.\\n• He is Australian\\nNeeds:\\nDavid has a project due soon which he needs to find climate change and the effects\\nand the reason for the increasing of ocean temperature.\\n• Need to create an relevant data that shows temperature changes in various\\noceans.\\n• Websites that provide this data\\n• Need to create a website about the climate change and makes everyone easy\\nto understand.\\nGoals:\\n• David wants to finish his project on time and get a good grade.\\n• Wants to reduce the death of water animals because of the various change of climate\\nchange and difference in ocean temperature.\\n• Wants to do Masters.\\nSkills:\\n• Skilled with researching and studying new things with the help of Internet.\\n• Has a experience to make a website and knows coding.\\nPersona 3\\nName: Kushar Bajaj\\nDescription/Attributes:\\n• He is 20 years old single.\\n• He is curious and likes to learn new things about\\nthe environment.\\n• Friendly in Nature and loves planting trees in his free time.\\n• He works part-time at NGO while studying for his Bachelor’s in\\nEnvironmental Science at Indian Institute of Technology, Delhi.\\n• He is an Indian.\\nNeeds:\\nKushar has a press conference due soon about so, he needs to find climate change and the effects and\\nthe reason for the increasing of ocean temperature.\\n• He needs to find out about the data regarding climate change\\n• Need to create a website about climate change and make it easy for everyone to understand.\\nGoals:\\n• Wants to reduce the death of water animals because of the various change of climate change\\nand difference in ocean temperature.\\n• He wants to make his own organization that is working solely on the climate change and\\nincreasing ocean temperatures.\\nSkills:\\n• Skilled Public speaker\\n• Knows the emotion of the masses and knows how to meld the thinking of the youth.');
        
        }
         </script>
                
                """);

        // Footer
         htmlBuilder.append( """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """);

        // Finish the HTML webpage
        htmlBuilder.append("</body>" + "</html>");
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(htmlBuilder.toString());
    }

}
