package main.structure.types;

public class Name {
    String player;
    String name;

    public Name(String player, String name) {
        this.player = player;
        this.name = name;
    }

    @Override
    public String toString() {
        return " \"team" + player + "Name\":\"" + name + "\"";
    }
}
