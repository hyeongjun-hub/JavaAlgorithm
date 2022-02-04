//입력된 숫자까지 + - 를 차례대로 반복하시오
//예제 입력: 9
//출력 1+2-3+4-5+6-7+8-9

package algorithm_basic_100.no30;

public class Main {
    public static void main(String[] args) {
        int inputNum = 10;
        int startNum = 2;
        String result = "1";


        while (startNum <= inputNum) {
            if(startNum % 2 == 0){
                result += "+" + startNum;
            }else{
                result += "-" + startNum;
            }
            startNum++;
        }

        System.out.println("result = " + result);

    }
}
