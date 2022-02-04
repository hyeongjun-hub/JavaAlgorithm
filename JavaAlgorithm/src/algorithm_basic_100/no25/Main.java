//N이 주어졌을 때 N의 사이클의 길이를 구하시오
//
//입력 : 26
//
//정답: 4   (26시작 2+6 = 8 , 68 6+8 = 14  84,  8+4=12  42,  4+2 = 6 26)
//
//Tag 반복문 (while, for)
//출처: 백준 (1110번)

package algorithm_basic_100.no25;

public class Main {
    public static void main(String[] args) {
        int inputNum = 26;
        int length = 1;
        int testNum = 0;
        int firstNum = 2;
        int secondNum = 6;
        while (true) {
            int temp = secondNum;
            secondNum = (firstNum + secondNum) > 10 ? (firstNum+secondNum) % 10 : firstNum + secondNum;
            firstNum = temp;
            testNum = firstNum*10 + secondNum;
            if (testNum == inputNum) {
                System.out.println("length = " + length);
                break;
            }
            length++;
        }

    }
}
