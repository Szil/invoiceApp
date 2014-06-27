package model;

/**
 * Created by Szil on 2014.05.10..
 */

import com.avaje.ebean.annotation.EnumMapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "i_user")
public class User implements Serializable {

    @Id
    String email;

    String name;

    String password;
    szKor u_role;

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

    public szKor getU_role() {
        return u_role;
    }

    public void setU_role(szKor u_role) {
        this.u_role = u_role;
    }

    @Override
    public String toString() {
        return "user{" +
                "u_role=" + u_role +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @EnumMapping(nameValuePairs = "ADMINISZTRATOR=A,KONYVELO=K,SZAMLAZO=S")
    protected enum szKor {
        ADMINISZTRATOR,
        KONYVELO,
        SZAMLAZO,
    }
}