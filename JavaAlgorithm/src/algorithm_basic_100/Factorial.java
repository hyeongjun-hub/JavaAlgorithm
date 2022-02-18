package algorithm_basic_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorial {
    public static int factorial(int num){
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(factorialList(list1));
    }

    //숫자가 들어 있는 배열이 주어졌을 때, 배열의 합을 리턴하는 코드를 작성해보세요 (재귀용법을 써보세요)

    public static int factorialList(ArrayList<Integer> dataList){
        if (dataList.size() <= 0) {
            return 0;
        } else {
//           int current = dataList.get(0);
//           dataList.remove(0);
//            return current + factorialList(dataList);
            return dataList.get(0) + factorialList(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
        }
    }
}
