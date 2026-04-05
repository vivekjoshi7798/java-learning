package LongestSubString;

import java.util.Arrays;

public class LongestNonRepeatingSubstringTwoPointer {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    private static int lengthOfLongestSubstring(String s) {
    int maxlength=0,right=0,left=0;
    int[] charset = new int[256];
        Arrays.fill(charset,-1);
    while(right<s.length()){
           if(charset[s.charAt(right)]!=-1 && charset[s.charAt(right)]>=left){
               left=charset[s.charAt(right)]+1;
           }
        maxlength= Math.max((right - left + 1), maxlength);
        charset[s.charAt(right)]=right;
        right++;

    }


    return maxlength;
    }
}
