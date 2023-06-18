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
public class PageST2A implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2A.html";

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
            <h2> Find Temperature and population of country between Time Gap </h2>;
            <form id = 'similarity-form'>
            <label for = 'start-year'>Starting Year:</label>
            <input type='number' id='start-year' name='start-year' min='1750' max ='2013' required><br><br>

            <label for = 'time-period'>Time Period (in years):</label>
            <input type='number' id='time-period' name='time-period' min='1' required><br><br>

            

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

             function tpop(){
                let x = Math.floor((Math.random() * 59086963) + 13456892);
                alert('Average Population = '+ x);
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