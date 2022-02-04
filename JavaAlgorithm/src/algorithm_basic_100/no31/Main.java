// 재귀 팩토리얼 만들기

package algorithm_basic_100.no31;

public class Main {

    public static int factorial(int input){
        if(input == 1){
            return 1;
        }
        else{
            return input*factorial(input-1);
        }
    }

    public static void main(String[] args) {
        int inputNum = 5;

        int result = factorial(inputNum);
        System.out.println("result = " + result);

    }
}
