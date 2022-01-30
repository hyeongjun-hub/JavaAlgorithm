/*
숫자 사각형(4)
123
246
369
*/

package algorithm_basic_100.no13;

public class Main {
    public static void main(String[] args) {
        int inputNum = 4;

        for(int i=1; i<=inputNum; i++){
            for(int j=1; j<=inputNum; j++){
                System.out.printf("%3d", j * i);
            }
            System.out.println();
        }
    }
}
