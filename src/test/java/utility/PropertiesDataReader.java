package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  This class contains method for reading properties file
 *  
 * @author Alokesh Dey
 */
public class PropertiesDataReader {

	// Variables
	
	FileInputStream fis = null;
	Properties prop = null;

	/**
	 * Constructor of the class to load the properties file
	 * 
	 * @throws IOException
	 */
	public PropertiesDataReader() throws IOException {

		try {

			fis = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

		}
	}

	// Methods
	
	/**
	 * Read value from the Config.properties file
	 * 
	 * @param value key value to be provided
	 * @return value of the key to be returned
	 */
	public String getProperty(String value) {

		return prop.getProperty(value);
	}
}
