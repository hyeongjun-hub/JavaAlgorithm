package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {
    public static ArrayList<Integer> split(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr;
        ArrayList<Integer> rightArr;

        leftArr = split(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = split(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return merge(leftArr, rightArr);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;

        // CASE 1 : 둘다 값 존재(하나라도 다 소모되면 while문 빠져나감)
        while (leftArr.size() > leftPoint && rightArr.size() > rightPoint) {
            if (leftArr.get(leftPoint) > rightArr.get(rightPoint)) {
                mergedList.add(rightArr.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftArr.get(leftPoint));
                leftPoint++;
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

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        split(testData);
        System.out.println(testData);
    }
}
