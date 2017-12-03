//          Task:

//        Write a program that returns the largest number-palindrome, which is the product
//        of two prime five-digit numbers and returns the multipliers themselves.
//        A prime number is a natural number that is divisible only by 1 and itself (2, 3, 5, 7, 11, ...)
//        A palindrome is a string that is read equally in both directions (for example, ABBA)

package com.maniek;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        long iPalindrome = 0;
        long jPalindrome = 0;
        long maxPalindrome = 0;

        List<Long> ourPrimeNumbers = new LinkedList<>();
        for (long i = 10000; i < 99999; i++) {
            if(isPrimeNumber(i)) {
                ourPrimeNumbers.add(i);
            }
        }

        System.out.println("There is " + ourPrimeNumbers.size() + " prime numbers");
        System.out.println(ourPrimeNumbers);

        for (long i : ourPrimeNumbers) {
            for (long j : ourPrimeNumbers) {

                long equalsMulitiply = i * j;

                if(isPalindrome(equalsMulitiply)) {
                    if(equalsMulitiply>maxPalindrome) {
                        iPalindrome = i;
                        jPalindrome = j;
                        maxPalindrome = equalsMulitiply;
                    }
                }
            }
        }

        System.out.println(maxPalindrome);




    }

    private static boolean isPalindrome(long x) {
        String string = Long.toString(x);
        StringBuilder stringBuilder = new StringBuilder(string);
        String stringReverse = stringBuilder.reverse().toString();

        return string.equals(stringReverse);

    }

    private static boolean isPrimeNumber(long y) {
        if (y <=1 || y != 2 && y % 2 == 0) {
            return false;
        }

        long iSqrt = (long) Math.sqrt(y);

        for (long i = 3; i < iSqrt; i = i + 2 ) {
            if (y % i == 0) {
                return false;
            }
        }
        return true;




    }
}
