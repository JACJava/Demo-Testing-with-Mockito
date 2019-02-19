package com.pluralsight.testing.m2;

import static java.lang.Math.min;

public class WordWrap {

    public static String wrap(final String inputLine, final int lineLength) {

        // first, just returned input line
        // return inputLine;

        final StringBuilder accumulator = new StringBuilder();
        final int length = inputLine.length();

        //takes a character sequence, a starting position, a number of characters
        //append from zero to linelength of the input line

        accumulator.append(inputLine, 0, min(length,lineLength));
        //then put a line break

        int split = lineLength;
        while (length > split) {
            accumulator.append('\n');
            //then take the rest of the line from the initial line length to the length of the input string
            accumulator.append(inputLine, split, min(length, split + lineLength));
            //so part of the input, a new line, the rest of it
            split += lineLength;
        }


        return accumulator.toString();


    }

}
