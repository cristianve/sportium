package main.structure.types;

public class Period {

    String period;

    public Period(String quarter) {
        this.period = quarter;
    }

    @Override
    public String toString() {
        if (period != null) {
            return " \"currentPeriod\":\"" + period + " Quarter\"";
        }
        return "";
    }
}
