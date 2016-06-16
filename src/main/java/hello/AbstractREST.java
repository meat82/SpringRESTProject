package hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractREST {

    private static final Logger log = LoggerFactory.getLogger(AbstractREST.class);
    private String tokenID;
    private String contentType;
    private String accept;
    private String selectTeam;
    
    public AbstractREST(String token) {
        setTokenID(token);
        setContentType("application/json");
        setAccept("application/vnd.stattleship.com; version=1");
        setSelectTeam("");

    }
    public abstract void displayData();
    
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
