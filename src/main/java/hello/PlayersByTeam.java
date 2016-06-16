package hello;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PlayersByTeam extends AbstractREST{

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public String url;
    public List<Player> players;
    
    
    public PlayersByTeam(String token) {
        super(token);
        setURL("https://www.stattleship.com/hockey/nhl/players");
        players = new ArrayList<Player>();
    }
    
    public String getURL() {
        return url;
    }
    public void setURL(String url) {
        this.url = url;
    }
    public List<Player> getPlayerByTeam(String team) {
        setSelectTeam(team);
        HttpHeaders requestHeaders = new HttpHeaders();
        StringBuilder url_builder = new StringBuilder(getURL());
        url_builder.append("?").append("team_id").append("=").append(getSelectTeam());

        requestHeaders.set(HttpHeaders.CONTENT_TYPE, getContentType());
        requestHeaders.set(HttpHeaders.AUTHORIZATION, getTokenID());
        requestHeaders.set(HttpHeaders.ACCEPT, getAccept());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", requestHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Players> response = restTemplate.exchange(url_builder.toString(), HttpMethod.GET, entity,
                Players.class);
        Players players = response.getBody();

        return players.getPlayers();
    }

    @Override
    public void displayData() {
        // Just loop through player from selected team
        for (Player player : players) {
            log.info(player.toString());
        }
        
    }

}
