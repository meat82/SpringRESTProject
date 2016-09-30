package meat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    private String first_name;

    private String last_name;
    
    private String humanized_salary;
    
    public Player() {   
        first_name = "";
        last_name = "";
        humanized_salary = "";
    }
    
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getHumanized_salary() {
        return humanized_salary;
    }

    public void setHumanized_salary(String humanized_salary) {
        this.humanized_salary = humanized_salary;
    }

    @Override
    public String toString() {
        return "Player [first_name=" + first_name + ", last_name=" + last_name + ", humanized_salary="
                + humanized_salary + "]";
    }

}
