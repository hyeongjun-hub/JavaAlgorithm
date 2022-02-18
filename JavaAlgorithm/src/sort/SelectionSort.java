package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;
        for (int stand = 0; stand < dataList.size() - 1; stand++) { // 마지막 stand는 바꿔져 있으므로
            lowest = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {
                if(dataList.get(lowest) > dataList.get(index)){
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        sort(testData);
        System.out.println(testData);
    }
}
