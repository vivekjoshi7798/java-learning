package LongestSubString;

class Soution{

    public static void main(String[] args) {


        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));


    }

    public static  int lengthOfLongestSubstring(String s){
        StringBuilder substr;
        int[] charset ;
        int maxlength=0;
        for ( int i = 0; i < s.length(); i++) {
            substr = new StringBuilder();
            charset =new int[256];
            for (int j = i; j < s.length(); j++) {
               if(charset[s.charAt(j)]==1){
                   break;
               }
               else {
                   substr.append(s.charAt(j));
                   charset[s.charAt(j)]=1;
               }
            }
            maxlength= Math.max(maxlength, substr.length());
        }
        return maxlength;
    }


}