package ProblemSolving;
/*
Given an array of 0's and 1's find the number of subarrays having bitwise xor 1
Author : Shivanagouda S A
*/
// import java.util.*;
// import java.io.*;

class SubArraysWithXorOne{
    public static void main(String[] args){
        int[] arr = {1,0,1,0,1,1,0,0,1,1};
        xorOneSubarrayCount(arr);
    }

    private static void xorOneSubarrayCount(int arr[]) {
        int total = arr.length * (arr.length + 1) / 2; // total number of subarrays
        for(int i = 0; i < arr.length; i++){
            int j = i, count = 0;
            if(arr[i] == 0){
                while(j < arr.length && arr[j] != 1){
                    count++;
                    j++;
                }
                total -= count * (count + 1) / 2; // remove number of subarrays of xor 0 from total 
                i = j - 1;
            }
        }
        System.out.println(total);
    }
}
