package baekjoon._2522;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        for(int i=1; i<=inputNum; i++){
            for (int j = inputNum; j > i; j--) {
                System.out.print(" ");
            }
            for (int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1; i<=inputNum-1; i++){
            for (int j=1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k=inputNum-1; k>=i; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
