package com.dsa.ValidParentheses;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String expression = "(a+b) * {c+d}";

        if (isBalanced(expression))
            System.out.println("Balanced Expression");
        else
            System.out.println("Not Balanced");
    }
}