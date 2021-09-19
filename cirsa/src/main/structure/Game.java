package main.structure;

import main.structure.types.Name;
import main.structure.types.Period;
import main.structure.types.Score;


public class Game {

    private Name nameA;
    private Name nameB;
    private Score scoreA;
    private Score scoreB;
    private Period period;


    private Game(GameBuilder builder) {
        this.nameA = builder.nameA;
        this.nameB = builder.nameB;
        this.scoreA = builder.scoreA;
        this.scoreB = builder.scoreB;
        this.period = builder.period;

    }


    @Override
    public String toString() {
        if (this.period == null) {
            return this.nameA.toString() + ", " + this.scoreA.toString() + ", " + this.nameB.toString() + ", " + this.scoreB.toString();
        }
        return this.nameA.toString() + ", " + this.scoreA.toString() + ", " + this.nameB.toString() + ", " + this.scoreB.toString() + ", " + this.period.toString();
    }

    /**
     * Game Builder - Builder Creational Patterns
     */
    public static class GameBuilder {
        private Name nameA;
        private Score scoreA;
        private Name nameB;
        private Score scoreB;
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

        public GameBuilder scoreA(Score score) {
            this.scoreA = score;
            return this;
        }

        public GameBuilder scoreB(Score score) {
            this.scoreB = score;
            return this;
        }

        public GameBuilder period(Period period) {
            this.period = period;
            return this;
        }


        //Return the finally constructed Game object
        public Game build() {
            Game game = new Game(this);
            validateUserObject(game);
            return game;
        }

        private void validateUserObject(Game game) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}