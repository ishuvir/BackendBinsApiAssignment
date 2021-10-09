package helper;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * 
 * @author Ishuvir Singh
 *
 */
public class loggerHelper {

	private static boolean root=false;
	
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}
	
	public static void main(String[] args) {
		Logger log = loggerHelper.getLogger(loggerHelper.class);
		log.info("I am test");
		log.info("I am test");
		log.info("I am test");
				
	}
}
