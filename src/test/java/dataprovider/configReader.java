package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private Properties properties;
	private static configReader configReader;

    public configReader() {
		BufferedReader reader;
	    	String propertyFilePath = System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	        }		
	}

    public static configReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new configReader();
    	}
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base_Url");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }

    public String getToken() {
        String tokenId = properties.getProperty("token");
        if(tokenId != null) return tokenId;
        else throw new RuntimeException("tokenId not specified in the Configuration.properties file.");
    }
    
    public String getInvalidToken() {
        String tokenId = properties.getProperty("getInvalidToken");
        if(tokenId != null) return tokenId;
        else throw new RuntimeException("tokenId not specified in the Configuration.properties file.");
    }
    
    public String binID() {
        String UniqueBInId = properties.getProperty("binID");
        if(UniqueBInId != null) return UniqueBInId;
        else throw new RuntimeException("BinID not specified in the Configuration.properties file.");
    }
    
    public String binIDupdate() {
        String BinIDUpdate = properties.getProperty("binIDUpdate");
        if(BinIDUpdate != null) return BinIDUpdate;
        else throw new RuntimeException("BinID not specified in the Configuration.properties file.");
    }

    public String binsampleupdate() {
        String BinsampleUpdate = properties.getProperty("binIDsample");
        if(BinsampleUpdate != null) return BinsampleUpdate;
        else throw new RuntimeException("BinID not specified in the Configuration.properties file.");
    }
    
    public String binroute() {
        String route = properties.getProperty("binRoute");
        if(route != null) return route;
        else throw new RuntimeException("route not specified in the Configuration.properties file.");
    }
    
    public String binDelete() {
        String deleteBin = properties.getProperty("binDelete");
        if(deleteBin != null) return deleteBin;
        else throw new RuntimeException("route not specified in the Configuration.properties file.");
    }
    
    public String binToBeDelete() {
        String deleteBin = properties.getProperty("binToDelete");
        if(deleteBin != null) return deleteBin;
        else throw new RuntimeException("route not specified in the Configuration.properties file.");
    }
    
  
}


