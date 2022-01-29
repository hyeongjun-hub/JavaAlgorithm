// 최빈수 구하기
// 10개의 0~9 랜덤 정수 입력 후 가장 많이 쓰인 수를 출력 + 최대빈도가 여러개일 때 모두 출력해보기

package algorithm_basic_100.no3;

import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> intMap = new HashMap<>(10);

        for(int i=0; i<10; i++){
            int input = sc.nextInt();
            int acc; // 빈도
            if(intMap.get(input)==null){
                acc = 1;
            } else{
                acc = intMap.get(input) + 1;
            }
            intMap.put(input, acc);
     }

//        Set<Map.Entry<Integer, Integer>> entrySet = intMap.entrySet();
//        int max = 1;
//        int maxIndex = 0;
//        for(Map.Entry<Integer, Integer> entry: entrySet){
//            if(entry.getValue() > max) {
//                max = entry.getValue();
//                maxIndex = entry.getKey();
//            }
//        }
//        System.out.println("숫자: " + maxIndex + " 빈도: " + max);
        // 최대값이 중복일 때 여러 숫자를 출력할 수 가 없다 (여러숫자를 출력하기 위해 Map을 쓰는 것, 다시 for문 돌리면 되긴 함)

        // 최대값을 쉽게 뽑는 법
        int maxValueInMap = Collections.max(intMap.values());
        for(Entry<Integer, Integer> entry : intMap.entrySet()){
            if(entry.getValue() == maxValueInMap) System.out.println("숫자: " + entry.getKey() + " 빈도: " + entry.getValue());
        }


        // Map에 있는 key와 value모두 출력해보기
        intMap.forEach((key, value) -> System.out.println(key + ":" + value));

    }
}
