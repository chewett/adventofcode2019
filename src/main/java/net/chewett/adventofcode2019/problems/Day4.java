package net.chewett.adventofcode2019.problems;

import net.chewett.adventofcode2019.passwords.PasswordFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Taken from: https://adventofcode.com/2019/day/4
 *
 * --- Day 4: Secure Container ---
 *
 * You arrive at the Venus fuel depot only to discover it's protected by a password. The Elves had written the password on a sticky note, but someone threw it out.
 *
 * However, they do remember a few key facts about the password:
 *
 * It is a six-digit number.
 * The value is within the range given in your puzzle input.
 * Two adjacent digits are the same (like 22 in 122345).
 * Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
 * Other than the range rule, the following are true:
 *
 * 111111 meets these criteria (double 11, never decreases).
 * 223450 does not meet these criteria (decreasing pair of digits 50).
 * 123789 does not meet these criteria (no double).
 * How many different passwords within the range given in your puzzle input meet these criteria?
 *
 * --- Part Two ---
 * An Elf just remembered one more important detail: the two adjacent matching digits are not part of a larger group of matching digits.
 *
 * Given this additional criterion, but still ignoring the range rule, the following are now true:
 *
 * 112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
 * 123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
 * 111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22).
 * How many different passwords within the range given in your puzzle input meet all of the criteria?
 *
 */
public class Day4 {

    public static void main(String[] args) {
        int START_NUM = 153517;
        int END_NUM = 630395;

        List<Integer> allPossiblePasswords = new ArrayList<>();
        List<Integer> allPossibleComplexPasswords = new ArrayList<>();
        for(int i = START_NUM; i <= END_NUM; i++) {
            if(PasswordFinder.isValidPassword(i)) {
                allPossiblePasswords.add(i);
                //Only passwords matching the first will match the second
                if(PasswordFinder.isValidPasswordMoreComplex(i)) {
                    allPossibleComplexPasswords.add(i);
                }
            }
        }

        System.out.println("Number of possible passwords: " + allPossiblePasswords.size());
        System.out.println("Number of possible passwords with more complex requirements: " + allPossibleComplexPasswords.size());
    }
}
