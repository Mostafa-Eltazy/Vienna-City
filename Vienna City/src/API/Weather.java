/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author glori
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;


    
public class Weather {
    public static String returnWeather(String city) throws APIException {
        String weather = "";
        try {
            // declaring object of "OWM" class
            OWM owm = new OWM("dbdcdc075f41578ed7dc6ae780322b2c");
            
            // getting current weather data for the "London" city
            CurrentWeather cwd = owm.currentWeatherByCityName(city);
            
            //printing city name from the retrieved data
            weather="City: \n" + cwd.getCityName()+"\n";
            
            // printing the max./min. temperature
            weather+="Temperature: \n" + (cwd.getMainData().getTempMax()-273.15) + "/" + (cwd.getMainData().getTempMin()-273.15) + "\'C";
        } catch (APIException ex) {
            Logger.getLogger(Weather.class.getName()).log(Level.SEVERE, null, ex);
        }
    return weather;
   
  }

}
