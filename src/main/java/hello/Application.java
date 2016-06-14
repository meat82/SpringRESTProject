package hello;

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
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static final String TOKEN_ID = "93de1ea75063ca3c270e17cc11d97897";
	private static final String CONTENT_TYPE = "application/json";
	private static final String ACCEPT = "application/vnd.stattleship.com; version=1";
	private static final String URL = "https://www.stattleship.com/hockey/nhl/players";
	private static final String SELECT_TEAM = "nhl-bos";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		if (args != null && args.length > 0) {
			for (String arg : args) {
				log.info("Display team: " + arg);
				getPlayers(arg);
			}
		}
		else {
			getPlayers(SELECT_TEAM);
		}

	}

	private void getPlayers(String selectTeam) {
		HttpHeaders requestHeaders = new HttpHeaders();
		StringBuilder url_builder = new StringBuilder(URL);
		url_builder.append("?").append("team_id").append("=").append(selectTeam);

		requestHeaders.set(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
		requestHeaders.set(HttpHeaders.AUTHORIZATION, TOKEN_ID);
		requestHeaders.set(HttpHeaders.ACCEPT, ACCEPT);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", requestHeaders);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Players> response = restTemplate.exchange(url_builder.toString(), HttpMethod.GET, entity,
				Players.class);
		Players players = response.getBody();

		// Just loop through player from selected team
		for (Player player : players.getPlayers()) {
			log.info(player.toString());
		}
		
	}

}
