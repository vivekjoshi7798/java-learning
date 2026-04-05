package com.dsa.nextGreaterElement;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 10, 8};

        int[] result = nextGreater(arr);

        System.out.println("Input Array  : " + Arrays.toString(arr));
        System.out.println("Next Greater : " + Arrays.toString(result));
    }
}