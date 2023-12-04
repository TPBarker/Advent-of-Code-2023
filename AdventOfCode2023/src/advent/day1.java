package advent;

import java.util.ArrayList;
import advent.myReader;

/**
 * This class completes the Advent of Code 2023 challenge for day one.
 * @see: https://adventofcode.com/2023/day/1
 */
public class day1 {

    public static void main(String[] args) {
        day1 today = new day1();
        today.partOne("src/advent/inputs/day1.txt");
        today.partTwo("src/advent/inputs/day1.txt");
    }

    /**
     * A helper function which tells if a provided String contains a
     * spelled out numeral or not. For example "smdujoneasr" would return
     * "one", as it contains the word "one".
     * @param matchMe the String to be checked.
     * @return an integer containing the numeral, if any was found.
     */
    private int findDigitInString(String matchMe) {
        if (matchMe.contains("one")) {
            return 1;
        }
        if (matchMe.contains("two")) {
            return 2;
        }
        if (matchMe.contains("three")) {
            return 3;
        }
        if (matchMe.contains("four")) {
            return 4;
        }
        if (matchMe.contains("five")) {
            return 5;
        }
        if (matchMe.contains("six")) {
            return 6;
        }
        if (matchMe.contains("seven")) {
            return 7;
        }
        if (matchMe.contains("eight")) {
            return 8;
        }
        if (matchMe.contains("nine")) {
            return 9;
        }
        return 0;
    }

    /**
     * Part one of the challenge.
     * @param filePath a String containing the path to the input text file.
     */
    public void partOne(String filePath) {
        // Startup.
        myReader reader = new myReader(filePath);
        ArrayList<String> lines = reader.arrayOfStrings();
        int totalSum = 0;

        // Loop through each line of the input.
        for(String line : lines) {
            // Loop through the characters. Identify digits.
            ArrayList<Character> digits = new ArrayList<Character>();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    digits.add(line.charAt(i));
                }
            }

            // This line's code is the first and last digits.
            Character first = digits.get(0);
            Character last = digits.get(digits.size() - 1);
            String sum = Character.toString(first) + Character.toString(last);
            totalSum += Integer.parseInt(sum);
        }
        System.out.println("Part One. The total sum is: " + totalSum);
    }

    /**
     * Part two of the challenge.
     * @param filePath a String containing the path to the input text file.
     */
    public void partTwo(String filePath) {
        // Startup.
        myReader reader = new myReader(filePath);
        ArrayList<String> lines = reader.arrayOfStrings();
        int totalSum = 0;

        // Loop through each line of the input.
        for(String line : lines) {
            // Loop through the characters. Identify digits, but also numbers
            // spelled out in full.
            ArrayList<Character> digits = new ArrayList<Character>();
            StringBuilder spelledOut = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    digits.add(line.charAt(i));
                    // Clear the StringBuilder since a digit is a break in
                    // a valid spelled out numeral.
                    spelledOut = new StringBuilder();
                }
                else {
                    spelledOut.append(line.charAt(i));
                    // Check to see if we have spelled a numeral.
                    int check = findDigitInString(spelledOut.toString());
                    if (check > 0) {
                        digits.add(Integer.toString(check).charAt(0));
                        // Clear the StringBuilder since we have found a
                        // spelled out word and need to reset.
                        spelledOut = new StringBuilder();
                    }
                }
            }

            // This line's code is the first and last digits.
            Character first = digits.get(0);
            Character last = digits.get(digits.size() - 1);
            String sum = Character.toString(first) + Character.toString(last);
            totalSum += Integer.parseInt(sum);
        }
        System.out.println("Part Two. The total sum is: " + totalSum);
    }

}
