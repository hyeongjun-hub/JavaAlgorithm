//입력된 수를 이진수로 변환하세요
//입력: 17
//정답: 1 0001

package algorithm_basic_100.no36;

import java.util.Scanner;

public class Main {

    public static void decToBin(int N) {
        if (N/2 == 0) {
            System.out.println(N);
            return;
        }
        decToBin(N / 2);
        System.out.println(N % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        decToBin(input);

    }
}
