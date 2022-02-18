package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            boolean swapped = false;

            for (int index2 = 0; index2 < dataList.size() - 1 - index; index2++) { // index 진행될 수록 끝이 정렬되므로
                if (dataList.get(index2) > dataList.get(index2 + 1)) {
                    Collections.swap(dataList, index2, index2 + 1);
                    swapped = true;
                }
            }

            // index 한 번 수행할 때 한 번도 swap이 일어나지 않으면 list 정렬 끝
            if(!swapped){
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        sort(testData);
        System.out.println(testData);
    }

}
