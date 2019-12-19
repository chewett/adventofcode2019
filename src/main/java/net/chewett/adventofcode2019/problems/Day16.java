package net.chewett.adventofcode2019.problems;

import java.util.ArrayList;
import java.util.List;

public class Day16 {

    public static int[] getRepeatingPattern(int position) {
        int[] basePattern = new int[] {0, 1, 0, -1};
        List<Integer> lists = new ArrayList<>();
        for(int i: basePattern) {
            for(int num = 0; num < position; num++) {
                lists.add(i);
            }
        }

        int[] actualPattern = new int[lists.size()];
        for(int indexInts = 0; indexInts < lists.size(); indexInts++) {
            actualPattern[indexInts] = lists.get(indexInts);
        }

        return actualPattern;
    }


    public static void main(String[] args) {
        String input = "59719896749391372935980241840868095901909650477974922926863874668817926756504816327136638260644919270589305499504699701736406883012172909202912675166762841246709052187371758225695359676410279518694947094323466110604412184843328145082858383186144864220867912457193726817225273989002642178918584132902751560672461100948770988856677526693132615515437829437045916042287792937505148994701494994595404345537543400830028374701775936185956190469052693669806665481610052844626982468241111349622754998877546914382626821708059755592288986918651172943415960912020715327234415148476336205299713749014282618817141515873262264265988745414393060010837408970796104077";
        int inputLength = input.length();
        for(int iii = 0; iii < 100; iii++) {
            String newInput = "";
            for(int indexInput = 0; indexInput < input.length(); indexInput++) {
                int[] repeatingPattern = Day16.getRepeatingPattern(indexInput + 1);
                long newValue = 0;
                int patternIndex = 1;
                for(int insideInputIndex = 0; insideInputIndex < input.length(); insideInputIndex++) {
                    long newCalculatedValue = (Integer.parseInt(input.substring(insideInputIndex, insideInputIndex+1)) * repeatingPattern[patternIndex]);
                    newValue += newCalculatedValue;
                    patternIndex++;
                    if(patternIndex >= repeatingPattern.length) {
                        patternIndex = 0;
                    }
                }

                long newPatternInput = Math.abs(newValue % 10);
                newInput += newPatternInput;
            }

            input = newInput;
        }


        System.out.println("New input: " + input);

    }
}
