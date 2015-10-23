package za.ac.cput.project.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/10/23.
 */
@Embeddable
public class Login implements Serializable{

    private String username;
    private String password;

    public Login(){}

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Login(Builder builder){
        username=builder.username;
        password=builder.password;

    }
    public static class Builder{
        private String username;
        private String password;


        public Builder(String username) {
            this.username = username;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }

        public Login build(){
            return new Login(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;

        Login login = (Login) o;

        if (password != null ? !password.equals(login.password) : login.password != null) return false;
        if (username != null ? !username.equals(login.username) : login.username != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
