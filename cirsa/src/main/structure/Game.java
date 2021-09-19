package main.structure;

import main.structure.types.Name;
import main.structure.types.Period;
import main.structure.types.Score;


//https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/

public class Game
{
    //All final attributes
    private Name nameA;
    private Name nameB;
    private Score score;
    private Period period;


    private Game(GameBuilder builder) {
        this.nameA = builder.nameA;
        this.nameB = builder.nameB;
        this.score = builder.score;
        this.period = builder.period;

    }

    public Name getNameA() {
        return nameA;
    }

    public Name getNameB() {
        return nameB;
    }

    public Score getScore() {
        return score;
    }

    public Period getPeriod() {
        return period;
    }


    @Override
    public String toString() {
        if(this.period==null){
            return this.nameA.toString()+", "+this.score.toString()+", "+this.nameB.toString();
        }
        return this.nameA.toString()+", "+this.score.toString()+", "+this.nameB.toString()+", "+this.period.toString();
    }

    public static class GameBuilder
    {
        private Name nameA;
        private Name nameB;
        private Score score;
        private Period period;

        public GameBuilder() {
        }
        public GameBuilder nameA(Name nameA) {
            this.nameA = nameA;
            return this;
        }

        public GameBuilder nameB(Name nameB) {
            this.nameB = nameB;
            return this;
        }

        public GameBuilder score(Score score) {
            this.score = score;
            return this;
        }

        public GameBuilder period(Period period) {
            this.period = period;
            return this;
        }


        //Return the finally consrcuted Game object
        public Game build() {
            Game game =  new Game(this);
            validateUserObject(game);
            return game;
        }
        private void validateUserObject(Game game) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}