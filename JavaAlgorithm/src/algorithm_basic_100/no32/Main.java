package algorithm_basic_100.no32;

import java.util.Scanner;

public class Main {

    public static int recursiveSum(int startNum, int endNum) {
        if (startNum == endNum) {
            return startNum;
        }
        else{
            return startNum + recursiveSum(startNum + 1, endNum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();
        int result = recursiveSum(startNum, endNum);
        System.out.println("result = " + result);

    }
}
