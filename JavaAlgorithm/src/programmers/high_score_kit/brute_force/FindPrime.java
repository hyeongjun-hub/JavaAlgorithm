package programmers.high_score_kit.brute_force;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
public class FindPrime {
    static Set<Integer> allNumber = new HashSet<>();
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void permutation(int[] inputNum, int current, int r){
        // current : 현재 바꾸려고 하는 배열의 index
        // r: 결과 배열의 길이(뽑으려는 순열의 수)
        if(current == r) {
            addList(inputNum, r);
            return;
        }

        for(int i=current; i < inputNum.length; i++){
            // 자리에 들어갈 수 있는 숫자 반복
            swap(inputNum, current, i);
            permutation(inputNum, current+1, r);
            swap(inputNum, current, i);
        }
    }

    public static void swap(int[] inputNum, int current, int i) {
        int temp = inputNum[current];
        inputNum[current] = inputNum[i];
        inputNum[i] = temp;
    }

    public static void addList(int[] inputNum, int r){
        int tempNum = 0;
        for(int i=0; i<r; i++){
            tempNum += inputNum[i] * pow(10, i);
        }
        if(tempNum != 1 && tempNum != 0) allNumber.add(tempNum);
    }

    public int solution(String numbers) {
        // 1. numbers의 모든 숫자 조합들을 갖는 리스트 만들기
        // String을 int 배열로
        int[] inputNum = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            inputNum[i] = numbers.charAt(i) - '0';
        }

        // for문 돌리면서 1~numbers.length까지 모든 순열 숫자만들어서 넣기
        for(int i=0; i<numbers.length(); i++){
            permutation(inputNum, 0, i+1) ;
        }

        // 2. for 문으로 소수판별
        for(int num : allNumber){
            boolean check = true;
            for (int i = 2; i <= sqrt(num); i++) {
               if (num % i == 0) {
                    check = false;
                    break;
               }
            }
            if(check) answerList.add(num);
        }

        // 3. 출력
        int answer = answerList.size();
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        findPrime.solution("011");
    }
}
