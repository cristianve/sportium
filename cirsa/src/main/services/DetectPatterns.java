package main.services;

import main.structure.Game;
import main.structure.types.Name;
import main.structure.types.Period;
import main.structure.types.Score;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Service class - Validate regex input format and return the JSON ouput
 */
public class DetectPatterns {

    public DetectPatterns() {
    }

    public String validateRegexFormat(String input) {

        // Regex to check valid football game.
        String regexFootball = "^(.+?)(\\d+)-(\\d+)(.+?)$";
        // Regex to check valid tennis game.
        String regexTennis = "^(.+?) (\\W)(\\d+)(\\W) (\\d+) (.{2,})-(.{2,}) (\\W)(\\d+)(\\W) (.+?)$";
        // Regex to check valid american football game.
        String regexAmericanFootball = "^(.+?) (\\d+)-(\\d+) (.+) (.+(?= Quarter)) (Quarter)$";


        if (input.matches(regexAmericanFootball)) {
            return this.getAmericanFootballResult(input);
        } else if (input.matches(regexTennis)) {
            return this.getTennisResult(input);
        } else if (input.matches(regexFootball)) {
            return this.getFootballResult(input);
        } else {
            return "Format not detected! Verify the input text.";
        }

    }


    public String getFootballResult(String input) {

        List<String> list = Arrays.asList(input.split(" "));
        //System.out.println("List: " + list);
        String score = list.stream().filter(values -> values.contains("-")).findFirst().orElse(null);
        //System.out.println("Score: " + score);

        int indexOpt = IntStream.range(0, list.size())
                .filter(i -> (score).equals(list.get(i)))
                .findFirst().orElse(-1);

        //First part Split
        String firstPart = "";
        for (int i = 0; i < indexOpt; i++) {

            firstPart += " " + list.get(i);
        }
        //System.out.println("First Part: " + firstPart);

        //Second part Split
        String secondPart = "";
        for (int i = indexOpt + 1; i < list.size(); i++) {

            secondPart += " " + list.get(i);
        }
        //System.out.println("Second Part: " + secondPart);

        //Name A
        String nameA = firstPart;
        //System.out.println("Name A: " + nameA);
        //Score A
        String scoreA = score.substring(0, score.indexOf("-"));
        //System.out.println("Score A: " + scoreA);

        //Score B
        String scoreB = score.substring(score.indexOf("-") + 1);
        //System.out.println("Score B: " + scoreB);

        //Name B
        String nameB = secondPart;
        //System.out.println("Name B: " + nameB);


        Game football = new Game.GameBuilder().nameA(new Name("A", nameA)).nameB(new Name("B", nameB)).scoreA(new Score("A", scoreA)).scoreB(new Score("B", scoreB)).build();

        return "{" + football.toString() + "}";
    }

    public String getAmericanFootballResult(String input) {

        List<String> list = Arrays.asList(input.split(" "));
        //System.out.println("List: " + list);
        String score = list.stream().filter(values -> values.contains("-")).findFirst().orElse(null);
        //System.out.println("Score: " + score);

        int indexOpt = IntStream.range(0, list.size())
                .filter(i -> (score).equals(list.get(i)))
                .findFirst().orElse(-1);

        //First part Split
        String firstPart = "";
        for (int i = 0; i < indexOpt; i++) {

            firstPart += " " + list.get(i);
        }
        //System.out.println("First Part: " + firstPart);

        //Second part Split
        String secondPart = "";
        for (int i = indexOpt + 1; i < list.size(); i++) {

            secondPart += " " + list.get(i);
        }
        //System.out.println("Second Part: " + secondPart);

        //Name A
        String nameA = firstPart;
        //System.out.println("Name A: " + nameA);

        //Name B
        String nameB = secondPart.substring(0, secondPart.indexOf(score.substring(0, 1)));
        //System.out.println("Name B: " + nameB);

        //Score A
        String scoreA = score.substring(0, score.indexOf("-"));
        //System.out.println("Score A: " + scoreA);

        //Score B
        String scoreB = score.substring(score.indexOf("-") + 1);
        //System.out.println("Score B: " + scoreB);

        //Quarter
        String quarter = list.get(list.toArray().length - 2);
        //System.out.println("Quarter: " + quarter);


        Game americanFootball = new Game.GameBuilder().nameA(new Name("A", nameA)).nameB(new Name("B", nameB)).scoreA(new Score("A", scoreA)).scoreB(new Score("B", scoreB)).period(new Period(quarter)).build();

        return "{" + americanFootball.toString() + "}";

    }

    public String getTennisResult(String input) {

        List<String> list = Arrays.asList(input.split(" "));
        //System.out.println("List: " + list);
        String score = list.stream().filter(values -> values.contains("-")).findFirst().orElse(null);
        //System.out.println("Score: " + score);

        int indexOpt = IntStream.range(0, list.size())
                .filter(i -> (score).equals(list.get(i)))
                .findFirst().orElse(-1);

        //First part Split
        String firstPart = "";
        for (int i = 0; i < indexOpt; i++) {

            firstPart += " " + list.get(i);
        }
        //System.out.println("First Part: " + firstPart);

        //Second part Split
        String secondPart = "";
        for (int i = indexOpt + 1; i < list.size(); i++) {

            secondPart += " " + list.get(i);
        }

        //Name Player A
        int firstIndexScore = firstPart.indexOf("(");
        String nameTennisA = firstPart.substring(0, firstIndexScore);
        nameTennisA = nameTennisA.replace("*", "");
        //System.out.println("Name Player A: " + nameTennisA);

        //Name Player B
        int secondIndexScore = secondPart.indexOf(")");
        String nameTennisB = secondPart.substring(secondIndexScore + 1, secondPart.length());
        nameTennisB = nameTennisB.replace("*", "");
        //System.out.println("Name Player B: " + nameTennisB);

        //Score A
        String scoreA = score.substring(0, score.indexOf("-"));
        //System.out.println("Score A: " + scoreA);

        //Score B
        String scoreB = score.substring(score.indexOf("-") + 1);
        //System.out.println("Score B: " + scoreB);

        //Games A
        String gamesA = firstPart.substring(firstPart.indexOf(")") + 1);
        //System.out.println("Games A: " + gamesA);

        //Games B
        String gamesB = secondPart.substring(0, secondPart.indexOf("("));
        //System.out.println("Games B: " + gamesB);

        //SERVING
        boolean isServingA = false;
        boolean isServingB = false;
        if (firstPart.contains("*")) {
            //System.out.println("Serving A: " + "true");
            isServingA = true;
        } else if (secondPart.contains("*")) {
            //System.out.println("Serving B: " + "true");
            isServingB = true;
        }

        //SETS A
        String setsA = firstPart.substring(firstPart.indexOf("(") + 1, firstPart.indexOf(")"));
        //System.out.println("Sets A: " + setsA);

        //SETS B
        String setsB = secondPart.substring(secondPart.indexOf("(") + 1, secondPart.indexOf(")"));
        //System.out.println("Sets B: " + setsB);

        Game tennis = new Game.GameBuilder().nameA(new Name("A", nameTennisA)).nameB(new Name("B", nameTennisB)).scoreA(new Score("A", scoreA, gamesA, setsA, isServingA)).scoreB(new Score("B", scoreB, gamesB, setsB, isServingB)).build();

        return "{" + tennis.toString() + "}";

    }


}
