package ds.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ds.game.entities.Mage;
import ds.game.entities.PlayersHero;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @NotNull
    @Size(min = 6,max = 25)
    private String password;
    @NotNull
    @Size(min = 4,max = 16)
    @Column(unique = true)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private Mage playersHero;



    Account() { // jpa only
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addHero(){
        this.playersHero = new Mage();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Mage getPlayersHero() {
        return playersHero;
    }

    public void setPlayersHero(Mage playersHero) {
        this.playersHero = playersHero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return getUsername().equals(account.getUsername());

    }

    @Override
    public int hashCode() {
        return getUsername().hashCode();
    }
}