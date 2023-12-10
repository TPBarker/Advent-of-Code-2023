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
     * Recursively check through a provided String and replace all fully spelled
     * out numeral words with numeric digits. Because of the way the challenge
     * works, we must only replace the first instance of each numeral and then
     * re-check the word (e.g. oneight must end up as 1ight, not 18).
     * @param haystack the String to be checked
     * @return the String with replacement performed.
     */
    public String removeNumerals(String haystack) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < haystack.length(); i++) {
            builder.append(Character.toString(haystack.charAt(i)));

            if (builder.toString().contains("one")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("one"), newStack.indexOf("one") + 3);
                newStack.append('1');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }
            if (builder.toString().contains("two")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("two"), newStack.indexOf("two") + 3);
                newStack.append('2');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }    
            if (builder.toString().contains("three")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("three"), newStack.indexOf("three") + 5);
                newStack.append('3');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("four")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("four"), newStack.indexOf("four") + 4);
                newStack.append('4');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("five")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("five"), newStack.indexOf("five") + 4);
                newStack.append('5');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("six")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("six"), newStack.indexOf("six") + 3);
                newStack.append('6');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("seven")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("seven"), newStack.indexOf("seven") + 5);
                newStack.append('7');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("eight")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("eight"), newStack.indexOf("eight") + 5);
                newStack.append('8');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
            if (builder.toString().contains("nine")) {
                StringBuilder newStack = new StringBuilder(haystack);
                newStack.delete(newStack.indexOf("nine"), newStack.indexOf("nine") + 4);
                newStack.append('9');
                haystack = newStack.toString();
                builder = new StringBuilder();
                haystack = removeNumerals(haystack);
            }     
        }
        return haystack; 
    }
}
