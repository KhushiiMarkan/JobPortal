package Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String Userid;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }
    public String getUserid() {
        return Userid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
       return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }



}
