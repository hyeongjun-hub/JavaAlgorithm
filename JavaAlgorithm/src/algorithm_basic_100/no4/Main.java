// 2진수로 바꾸기

package algorithm_basic_100.no4;

public class Main {
    public static void main(String[] args) {
        int inputNum = 19;
        int term;
        String binaryNum = "";

        while(inputNum > 0){
            term = inputNum % 2;
            inputNum /= 2;
            binaryNum = term + binaryNum;
        }

        System.out.println(binaryNum);
    }
}
