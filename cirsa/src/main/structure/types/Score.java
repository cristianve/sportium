package main.structure.types;

public class Score {
    String score;

    public Score(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return " \"score\":\"" + score + "\"" ;
    }
}
