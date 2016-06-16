package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static final String SELECT_TEAM = "nhl-bos";
    private Properties properties;
    private InputStream input;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	    
		init(args);
		String securityToken = properties.getProperty("key");
		
		PlayersByTeam pbt = new PlayersByTeam(securityToken);
		if (args != null && args.length > 0) {
			for (String arg : args) {
				log.info("Display team: " + arg);
				pbt.getPlayerByTeam(arg);
				displayRESTData(pbt);
			}
		}
		else {
            pbt.getPlayerByTeam(SELECT_TEAM);
            displayRESTData(pbt);
		}

	}

	private void displayRESTData(AbstractREST data) {
	    data.displayData();
    }

    private void init(String[] args) throws IOException {
        properties = new Properties();
        input = new FileInputStream("security.key");
        properties.load(input);
    }

}
