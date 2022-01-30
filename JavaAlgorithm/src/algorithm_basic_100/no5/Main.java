// 대소문자 변환
// 대문자 -> 소문자
// 소문자 -> 대문자

package algorithm_basic_100.no5;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "helloWorlD";

//        Pattern pattern = Pattern.compile("[A-Z]*");
//        input = input.replaceAll("[a-z]", "1");

//        char test;
//        int byteValue = 65;
//        test = (char) (byteValue + 1);
//        System.out.println("test = " + test);
//
//
//        int test2;
//        test2 = 'A';
//        System.out.println("test2 = " + test2);

        char[] arr;
        arr = input.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] + 'A' - 'a');
            }
            else{
                arr[i] = (char) (arr[i] - 'A' + 'a');
            }
        }

        System.out.println(arr);

    }
}
