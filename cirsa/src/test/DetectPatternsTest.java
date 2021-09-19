package test;

import main.services.DetectPatterns;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectPatternsTest {

    DetectPatterns detectPatterns;

    public static final String CORRECT_FOOTBALL_INPUT = "F.C. Barcelona 3-2 Real Madrid";
    public static final String CORRECT_TENNIS_INPUT = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
    public static final String CORRECT_AMERICAN_FOOTBALL_INPUT = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";

    public static final String INVALID_REGEX_FORMAT = "asdfghjkl";

    public static final String ERROR_MESSAGE = "Format not detected! Verify the input text.";

    public static final String EXPECTED_FOOTBALL_RESULT = "{ \"teamAName\":\" F.C. Barcelona\",  \"teamAScore\":\"3\",  \"teamBName\":\" Real Madrid\",  \"teamBScore\":\"2\"}";
    public static final String EXPECTED_TENNIS_RESULT = "{ \"teamAName\":\" Anna Karolina Schmiedlova \",  \"teamASets\":\"1\",\"teamAGames\":\" 1\",\"teamAScore\":\"40\",  \"teamBName\":\" Varvara Lepchenko\",  \"teamBSets\":\"0\",\"teamBGames\":\" 1 \",\"teamBScore\":\"Adv\",\"teamBserving\":\"true\"}";
    public static final String EXPECTED_AMERICAN_FOOTBALL_RESULT = "{ \"teamAName\":\" Pittsburgh Steelers\",  \"teamAScore\":\"3\",  \"teamBName\":\" Minnesota Vikings \",  \"teamBScore\":\"7\",  \"currentPeriod\":\"3rd Quarter\"}";


    @BeforeEach
    void setUp() {
        detectPatterns = new DetectPatterns();
    }

    @Test
    void testValidateWrongRegexFormat() {
        String result = detectPatterns.validateRegexFormat(INVALID_REGEX_FORMAT);
        assertEquals(result, ERROR_MESSAGE);
    }

    @Test
    void testValidateGetFootballResult() {

        String result = detectPatterns.getFootballResult(CORRECT_FOOTBALL_INPUT);
        assertEquals(result, EXPECTED_FOOTBALL_RESULT);

    }

    @Test
    void testValidateGetTennisResult() {

        String result = detectPatterns.getTennisResult(CORRECT_TENNIS_INPUT);
        assertEquals(result, EXPECTED_TENNIS_RESULT);
    }

    @Test
    void testValidateGetAmericanFootballResult() {

        String result = detectPatterns.getAmericanFootballResult(CORRECT_AMERICAN_FOOTBALL_INPUT);
        assertEquals(result, EXPECTED_AMERICAN_FOOTBALL_RESULT);
    }
}
