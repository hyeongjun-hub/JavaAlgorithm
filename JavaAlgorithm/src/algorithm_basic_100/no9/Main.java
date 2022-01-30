// 각 자릿수 합을 구하기

package algorithm_basic_100.no9;

public class Main {
    public static void main(String[] args) {
        int num = 1242;
//        String numString = String.valueOf(num);
//        char[] numChars = numString.toCharArray();
//        int result = 0;
//
//        for(int i=0; i<numChars.length; i++){
//            char numChar = numChars[i];
//            result += numChar - '0';
//        }

        int result = 0;
        while(num > 0){
            result += num % 10;
            num /= 10;
        }

        System.out.println("result = " + result);

    }


}
