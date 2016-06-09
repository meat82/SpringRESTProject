package hello;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json");
        requestHeaders.set("Authorization", "Token token=93de1ea75063ca3c270e17cc11d97897");
        requestHeaders.set("Accept", "application/vnd.stattleship.com; version=1");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", requestHeaders);
        RestTemplate restTemplate = new RestTemplate();
        //Quote quote = restTemplate.getForObject("https://www.stattleship.com/hockey/nhl/players", Quote.class);
        Map<String, String> urlVariables = new HashMap<String,String>();
        urlVariables.put("team_id", "nhl-bos");
        //Quote quote = restTemplate.getForObject("https://www.stattleship.com/hockey/nhl/players", Quote.class, urlVariables);
        ResponseEntity<String> response = restTemplate.exchange("https://www.stattleship.com/hockey/nhl/players?team_id=nhl-bos", HttpMethod.GET, entity, String.class);
        log.info(response.toString());        
    }
    

}
