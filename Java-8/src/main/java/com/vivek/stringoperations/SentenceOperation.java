package com.vivek.stringoperations;

import java.util.Arrays;
import java.util.Comparator;

public class SentenceOperation {
    public static void main(String[] args) {
        System.out.println("1 longest string from a list : " + findLongestString("I am interested123455 to grow in my organization"));
        System.out.println("2 longest string from a list : " + findSecondLongestString("I am interested123455 to grow in my organization"));
        System.out.println("3 longest string lenth from a list : " + findLengthLongestString("I am interested123455 to grow in my organization"));
        System.out.println("4 longest string nth length a list : " + findSecondLengthLongestString("I am interested123455 to grow in my organization"));
        System.out.println("5 longest string from a list : " + findSecondLongestString("I am interested123455 to grow in my organization"));
    }


    //    /*
//    2)  Given a sentence find the word that has the highest length. The solution is:
//
//String s = "I am interested123455 to grow in my organization";
//
//     String maxString = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();
//    System.out.println("The maxString is: " + maxString);
//
//3) Given a sentence find the word that has the 2nd (Nth) highest length.
//
//	Answer is below: skip(N). N =0 (highest) N =1 (2nd Highest) N =2 (3rd Highest...)
//
//String a =  Arrays.stream(s.split("")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
//
// System.out.println(a);
//
//This question asked in SNP. They will tweak the same question with list of Employee Objects. But this is the base logic.
//
// */
    private static int findLongestString(String longest) {
        return Arrays.stream(longest.split("")).max(Comparator.naturalOrder()).get().length();
    }

    private static String findSecondLongestString(String longest) {
        return Arrays.stream(longest.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(2).findFirst().get();
    }


    /*
    Q4) Find the length of the longest word

Q5). Find the 2nd highest length word in the given sentence
Find the longest string from a list using Stream API.
}

     */

    private static int  findLengthLongestString(String longest) {
//        return Arrays.stream(longest.split(" ")).max(Comparator.comparing(String::length)).get();
    return  Arrays.stream(longest.split(" ")).mapToInt(s->s.length()).max().getAsInt();
    }

    private static int findSecondLengthLongestString(String longest) {
//        return Arrays.stream(longest.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(2).findFirst().get().length();
        return  Arrays.stream(longest.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
    }

/*

Q6) Given a sentence, find the number of occurrence of each word.

Q9) Given a string, find the words with the maximum number of vowels.

       "The quick brown fox jumps right over the little lazy dog."
        Maximum Number of Vowels: 2
        output Words: quick, over, little  ( because each word has maximum of 2 vowels)

*/


}