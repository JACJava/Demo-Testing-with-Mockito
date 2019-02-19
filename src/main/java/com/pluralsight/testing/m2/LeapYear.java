package com.pluralsight.testing.m2;

public class LeapYear {

    // a year is a leap year if it is divisible by four
    // but, years divisible by 100 are not leap years.
    // except years divisible by 400

    public static boolean isLeapYear(final int year) {

        //return false;

        //return true;

        //year divided by 4 has no remainder and it's not evenly divisible by 100
        //return year % 4 == 0 && !(year % 100 == 0);

        //refactor "year % 4 == 0" and extract to a method

        return isDivisible(year, 4)
                && (!isDivisible(year, 100)
                || isDivisible(year, 400));

    }

    private static boolean isDivisible(final int year, final int denominator) {
        return year % denominator == 0;
    }
}
