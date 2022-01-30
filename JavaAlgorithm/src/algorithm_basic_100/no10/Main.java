// 입력된 수(N)만큼 N행 N열의 형태로 연속되어 출력되는 숫자사각형 만들기

package algorithm_basic_100.no10;

public class Main {
    public static void main(String[] args) {
        int inputNum = 5;
        int squaredNum = inputNum * inputNum;

        for(int i=1; i<=squaredNum; i++){
            System.out.printf("%3d", i);
            if(i % inputNum == 0){
                System.out.println();
            }
        }
    }
}
