package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {
    static ArrayList<Integer> dataList = new ArrayList<>(Arrays.asList(1, 23, 4, 56, 67, 21));

    public static ArrayList<Integer> split(ArrayList<Integer> dataList) {
        if (mergeSort.dataList.size() <= 1) {
            return dataList;
        }
        int medium = mergeSort.dataList.size() / 2;

        ArrayList<Integer> leftArr;
        ArrayList<Integer> rightArr;

        leftArr = split(new ArrayList<>(mergeSort.dataList.subList(0, medium)));
        rightArr = split(new ArrayList<>(mergeSort.dataList.subList(medium, mergeSort.dataList.size())));

        return merge(leftArr, rightArr);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0, rightPoint = 0;

        // CASE 1 : 둘다 값 존재(하나라도 다 소모되면 while문 빠져나감)
        while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            if (leftArr.get(leftPoint) > rightArr.get(rightPoint)) {

            }
        }
        // CASE 2: 왼쪽 값만 존재
        while (leftArr.size() > leftPoint){
            mergedList.add(leftArr.get(leftPoint));
            leftPoint++;
        }

        // CASE 3: 오른쪽 값만 존재
        while (rightArr.size() > rightPoint) {
            mergedList.add(rightArr.get(rightPoint));
            rightPoint++;
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = split(dataList);
        System.out.println("result = " + result);
    }
}
