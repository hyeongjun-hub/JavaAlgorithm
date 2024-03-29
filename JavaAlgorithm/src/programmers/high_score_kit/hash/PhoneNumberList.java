package programmers.high_score_kit.hash;

/*
문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 Solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 Solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
같은 전화번호가 중복해서 들어있지 않습니다.
 */

import java.util.Arrays;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 배열을 정렬
        Arrays.sort(phone_book);
        // 다음내용이 지금 index 내용으로 시작한다면 false를 return
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        boolean solution = phoneNumberList.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println("Solution = " + solution);

    }
}
