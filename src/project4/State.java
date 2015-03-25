package project4;

import static java.lang.Integer.parseInt;

/**
 *
 * @author eric
 */
public class State {
    //String and int variables representing the various aspects of a State that are 
    //read in from the input file
    private String stateName, capital, abbreviation, region;
    private int population, regionNumber;

    /**
     * Constructor for State.
     * @param readLine This contains the string data in the form of a String
     * It is parsed by the constructor and variables are set based up on it.
     */
    public State(String readLine) {
        if (readLine.length() > 55) {
            stateName = readLine.substring(0, 15).trim();
            capital = readLine.substring(15, 30).trim();
            abbreviation = readLine.substring(30, 32).trim();
            population = parseInt(readLine.substring(32, 40).trim());
            region = readLine.substring(40, 55).trim();
            regionNumber = parseInt(readLine.substring(55));
        } else {
            stateName = readLine;
        }
    }

    /**
     * 
     * @return stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * 
     * @return toString If all variables of the State instance are set, all will be returned as String,
     * otherwise just the stateName is returned.
     */
    public String toString() {
        String toString;
        if (capital == null) {
            toString = stateName;
        } else {
            toString = String.format("%-15s %-15s %-2s %-8s %-15s %-1s", stateName, capital, abbreviation, population, region, regionNumber);
        }
        return toString;
    } 
}
