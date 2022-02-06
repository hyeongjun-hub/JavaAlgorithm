//백준 1463

package algorithm_basic_100.no40;

import java.util.Scanner;

public class Main {

    public static int min = 9999;

    public static void makeOne(int input, int way, int count){
        if (input % 3 == 0 && way == 3) {
            count++;
            for (int i = 1; i <= 3; i++) {
                makeOne(input/3, i, count);
            }
        } else if (input % 2 == 0 && way == 2) {
            count++;
            for (int i = 1; i <= 3; i++) {
                makeOne(input/2, i, count);
            }
        } else if (input >= 2){
            count++;
            for (int i = 1; i <= 3; i++) {
                makeOne(input - 1, i, count);
            }
        }

        if (input == 1){
            min = count;
            return;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            makeOne(inputNum, i, count);
        }
        System.out.println(min);

    }
}
