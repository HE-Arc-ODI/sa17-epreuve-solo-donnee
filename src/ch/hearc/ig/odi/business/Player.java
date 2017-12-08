
package ch.hearc.ig.odi.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Player implements Serializable {

    /**
    * Compteur pour la gestion de l'id de la réponse
    */
    private Long nextId = (long)0;
    
    /**
     * Id du joueur
     */
    private Long id;
    
    /**
     * Pseudo du joueur
     */
    private String alias;

    private Map<Long, Game> games;

    /**
     * Constructeur de la classe Player
     * @param alias représente l'alias du joueur pour la session
     */
    public Player(String alias) {
        nextId ++;
        id = this.nextId;
        this.alias = alias;
        games = new HashMap();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Map<Long, Game> getGames() {
        return games;
    }


}
