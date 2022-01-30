// 숫자사각형(3)
// 열을 기준으로 숫자가 증가

package algorithm_basic_100.no12;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int inputNum = 4;

        for(int i=1; i<=inputNum; i++){
            for(int j=0; j<inputNum; j++){
                System.out.printf("%3d", i + j * inputNum);
            }
            System.out.println();
        }
    }
}
