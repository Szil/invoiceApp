package model;

/**
 * Created by Szil on 2014.05.10..
 */
import com.avaje.ebean.annotation.EnumMapping;
import com.avaje.ebean.validation.Email;
import com.avaje.ebean.validation.Length;
import com.avaje.ebean.validation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "i_user")
public class user implements Serializable {

    @EnumMapping(nameValuePairs = "ADMINISZTRATOR=A,KONYVELO=K,SZAMLAZO=S")
    public enum Szint {
        ADMINISZTRATOR,
        KONYVELO,
        SZAMLAZO,
    }

    Szint role;

    @Id
    @Email
    private String email;

    @Length(max = 40)
    private String name;

    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // -- Contructor
    public user(String email, String name, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
    }

    public user(){}

    @Override
    public String toString() {
        return "User(" + email + ")";
    }
}