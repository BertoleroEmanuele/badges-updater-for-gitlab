package it.iubar.SonarQube_badges_into_GitLab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesFile {

	private static final Logger LOGGER = Logger.getLogger(GitlabApiClient.class.getName());
	
	public PropertiesFile() {
        super();
    }
    
    public Properties getPropertiesFile(String propertiesFilename)
    {
    	Properties fileProperties = new Properties();
    	FileInputStream objFileInputStream = null;
        //InputStream objInputStream = null;
    	
        try {
            
            
            // Metodo 1 (Funziona! interno al JAR)
             //ClassLoader loader = Thread.currentThread().getContextClassLoader();
             //objInputStream = loader.getResourceAsStream(propertiesFilename);
    
             //Metodo 2 (Funziona! esterno al JAR)
             objFileInputStream = new FileInputStream(propertiesFilename);
         
            // Metodo 3 (Funziona! interno al JAR)
             //objInputStream = ClassLoader.getSystemResourceAsStream(propertiesFilename);

            // Metodo 5 (Funziona esterno al JAR)
//             File propertiesFile = new File(propertiesFilename);
//             if (!propertiesFile.exists()) {
//                System.out.println("ERROR: properties file " + propertiesFilename + " was not found !");
//             } else {
//                 objFileInputStream = new FileInputStream(propertiesFile);
//             }
             
             
             
             fileProperties.load(objFileInputStream);
             
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            LOGGER.warning("File di configurazione vuoto");
        }catch (IOException ex) {
            ex.printStackTrace();
            LOGGER.warning("Errori interni al file, controlla la sintassi ed i valori inseriti");
        }

        return fileProperties;
    }
    	
}
