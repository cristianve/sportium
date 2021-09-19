package main.structure.types;

public class Score {

    String player;
    String score;
    String game;
    String set;
    boolean serving;

    public Score(String player, String score) {
        this.player = player;
        this.score = score;
    }

    public Score(String player, String score, String game, String set, Boolean serving) {
        this.player = player;
        this.score = score;
        this.game = game;
        this.set = set;
        this.serving = serving;

    }

    @Override
    public String toString() {
        if (game == null && set == null) {
            return " \"team" + player + "Score\":\"" + score + "\"";
        } else if (serving == true) {
            return " \"team" + player + "Sets\":\"" + set + "\"," +
                    "\"team" + player + "Games\":\"" + game + "\"," +
                    "\"team" + player + "Score\":\"" + score + "\"," +
                    "\"team" + player + "serving\":\"" + serving + "\"";
        } else {
            return " \"team" + player + "Sets\":\"" + set + "\"," +
                    "\"team" + player + "Games\":\"" + game + "\"," +
                    "\"team" + player + "Score\":\"" + score + "\"";
        }

    }
}
