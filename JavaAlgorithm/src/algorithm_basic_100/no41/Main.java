package algorithm_basic_100.no41;
//
//import java.util.Scanner;
//
//public class Solution {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        int[] numArray = new int[100001];
//        numArray[1] = 1;
//        numArray[2] = 1;
//        numArray[3] = 1;
//        for (int i = 4; i < numArray.length; i++) {
//            int countA = 9999; int countB = 9999; int countC = 9999;
//            if (i % 3 == 0) {
//                countA = numArray[i / 3] + 1;
//            }
//            if (i % 2 == 0) {
//                countB = numArray[i / 2] + 1;
//            }
//            countC = numArray[i - 1] + 1 ;
//
//            int min = Math.min((Math.min(countA, countB)), countC);
//            numArray[i] = min;
//        }
//
//        int answer = numArray[input];
//        System.out.println("answer = " + answer);
//
//
//    }
//}

import java.io.*;

public class Main {

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bottomUp(n));
    }

    static int bottomUp(int num) {
        int[] dp = new int[num+1];

        for(int i=2; i<num+1; i++) {
            dp[i] = dp[i-1]+1; // -1
            if(i%2==0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            if(i%3==0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        return dp[num];
    }
}