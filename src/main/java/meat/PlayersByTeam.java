package meat;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PlayersByTeam extends AbstractREST{

    private static final Logger log = LoggerFactory.getLogger(PlayersByTeam.class);
    
    public Players players;
    
    
    public PlayersByTeam(String token) {
        super(token);
        setURL("https://api.stattleship.com/hockey/nhl/players");
        players = new Players();
    }
    
    public List<Player> getPlayerByTeam(String team) {
        setSelectTeam(team);
        StringBuilder url_builder = new StringBuilder(getURL());
        url_builder.append("?").append("team_id").append("=").append(getSelectTeam());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Players> response = restTemplate.exchange(url_builder.toString(), HttpMethod.GET, constructHTTPHeader(),
                Players.class);
        players = response.getBody();
        return players.getPlayers();
    }

    @Override
    public void displayData() {
        // Just loop through player from selected team
        for (Player player : players.getPlayers()) {
            log.info(player.toString());
        }
        
    }

}
