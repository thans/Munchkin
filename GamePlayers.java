import java.util.HashSet;
import java.util.Set;

/*
 * A class for managing the players in a game.  Also tracks the winner of the game.  All players must
 * be unique!
 * @author Tore Hanssen
 */
public class GamePlayers {
    private Set<String> players;
    private String winner;
    
    public GamePlayers() {
        this.players = new HashSet<String>();
    }
    
    public GamePlayers(String winner) {
        this.players = new HashSet<String>();
        this.winner = winner;
    }
    
    public void setWinner(String winner) {
        if (players.contains(winner)) {
            throw new IllegalArgumentException("Cannot add a winner who is already set as a player. Must add unique players");
        }
        this.winner = winner;
    }
    
    public void addPlayer(String name) {
        if (name.equals(winner)) {
            throw new IllegalArgumentException("Cannot add a player who is already set as the winner. Must add unique players");
        }
        players.add(name);
    }
    
    public Set<String> getLosers() {
        Set<String> newSet = new HashSet<String>();
        return addAndReturnPlayers(newSet);
    }
    
    public String getWinner() {
        return winner;
    }
    
    public Set<String> getPlayers() {
        Set<String> newSet = new HashSet<String>();
        newSet.add(winner);
        return addAndReturnPlayers(newSet);
    }

    private Set<String> addAndReturnPlayers(Set<String> newSet) {
        newSet.addAll(players);
        return newSet;
    }
}
