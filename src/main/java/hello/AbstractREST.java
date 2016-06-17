package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public abstract class AbstractREST {

    private static final Logger log = LoggerFactory.getLogger(AbstractREST.class);
    private String tokenID;
    private String contentType;
    private String accept;
    private String selectTeam;
    public String url;
    
    public AbstractREST(String token) {
        setTokenID(token);
        setContentType("application/json");
        setAccept("application/vnd.stattleship.com; version=1");
        setSelectTeam("");
        setURL("");
    }
    
    /**
     * 
     * @return
     */
    public final HttpEntity<String> constructHTTPHeader() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set(HttpHeaders.CONTENT_TYPE, getContentType());
        requestHeaders.set(HttpHeaders.AUTHORIZATION, getTokenID());
        requestHeaders.set(HttpHeaders.ACCEPT, getAccept());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", requestHeaders);
        return entity;
    }
    
    public abstract void displayData();
    
    public String getURL() {
        return url;
    }
    public void setURL(String url) {
        this.url = url;
    }
    
    public String getTokenID() {
        return tokenID;
    }
    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public String getAccept() {
        return accept;
    }
    public void setAccept(String accept) {
        this.accept = accept;
    }
    public String getSelectTeam() {
        return selectTeam;
    }
    public void setSelectTeam(String selectTeam) {
        this.selectTeam = selectTeam;
    }
    
}
