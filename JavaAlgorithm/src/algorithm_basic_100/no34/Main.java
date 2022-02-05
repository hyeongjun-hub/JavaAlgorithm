//입력된 수를 높은 자릿수 부터 출력하시오(재귀)
//2312

package algorithm_basic_100.no34;

import java.util.Scanner;

public class Main {

    public void extract(int N){
        if(N/10 == 0){
            System.out.println(N);
            return;
        }

        extract(N / 10);
        System.out.println(N % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Main main = new Main();
        main.extract(input);

    }
}
