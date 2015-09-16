package s72743.htw.model;


public class Game {
    final private Player[] players;
    final private String name;
    final private Field field;

    public Game(Player[] players, String name, Field field) {
        this.players = players;
        this.name = name;
        this.field = field;
    }

    public Player[] getPlayers(){
        return players;
    }

    public String getName() {
        return name;
    }

    public Field getField() {
        return field;
    }
}
