package advent;

import java.util.ArrayList;

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
            line = removeNumerals(line);
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
        System.out.println("Part Two. The total sum is: " + totalSum);
    }
    
    /**
     * @param haystack the String to be checked
     * @return the String with replacement performed.
     */
    public String removeNumerals(String haystack) {
        haystack = haystack.replaceAll("one", "one1one");
        haystack = haystack.replaceAll("two", "two2two");
        haystack = haystack.replaceAll("three", "three3three");
        haystack = haystack.replaceAll("four", "four4four");
        haystack = haystack.replaceAll("five", "five5five");
        haystack = haystack.replaceAll("six", "six6six");
        haystack = haystack.replaceAll("seven", "seven7seven");
        haystack = haystack.replaceAll("eight", "eight8eight");
        haystack = haystack.replaceAll("nine", "nine9nine");
        return haystack; 
    }
}
