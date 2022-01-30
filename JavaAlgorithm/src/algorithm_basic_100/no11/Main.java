// 입력된 수(N)만큼 N행 N열 형태로 출력하는데 짝수 행은 내림차순으로 출력하도록

package algorithm_basic_100.no11;

public class Main {
    public static void main(String[] args) {
        int inputNum = 5;

        for(int i=1; i<=inputNum; i++){
            if(i % 2 == 1){
                for(int j=1; j<=inputNum; j++){
                    System.out.printf("%3d", j + (i-1)*inputNum);
                }
            }else{
                for(int j=inputNum; j>=1; j--){
                    System.out.printf("%3d", j + (i-1)*inputNum);
                }
            }
            System.out.println();
        }

    }
}
