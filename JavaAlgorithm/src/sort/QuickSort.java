package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> arrayList) {
        if (arrayList.size() < 1) {
            return arrayList;
        }

        Integer pivot = arrayList.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < arrayList.size(); i++) {
            if (pivot > arrayList.get(i)) {
                leftArr.add(arrayList.get(i));
            }
            else {
                rightArr.add(arrayList.get(i));
            }
        }

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(sort(leftArr));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(sort(rightArr));
        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        testData = sort(testData);
        System.out.println(testData);

    }
}
