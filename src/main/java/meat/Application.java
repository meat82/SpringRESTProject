package meat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

    private Properties properties;
    private InputStream input;
    private String securityToken;
	
	public static void main(String[] args) {
	    String mikko = "";
	    
		SpringApplication.run(Application.class, args);

	}

	@Autowired
	public Application(ApplicationArguments args) {
	    boolean debug = args.containsOption("debug");
	    log.info("debug: " + debug);
    }
	
	@Override
	public void run(String... args) throws Exception {
	    
		init(args);
		securityToken = properties.getProperty("key");
		log.info("User token: " + securityToken);

	}
	
    private void init(String[] args) throws IOException {
        properties = new Properties();
        input = new FileInputStream("security.key");
        properties.load(input);
    }
    
    @RequestMapping("/show")  
    public List<Player> showData(@RequestParam(value="team", defaultValue="nhl-car") String selectTeam) {
        PlayersByTeam pbt = new PlayersByTeam(securityToken);
        return pbt.getPlayerByTeam(selectTeam);
    }

}
