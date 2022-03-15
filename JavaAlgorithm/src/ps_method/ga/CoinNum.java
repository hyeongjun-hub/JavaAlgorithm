package ps_method.ga;

// 그리디 알고리즘
// 지불해야하는 값이 4720원일 때 1원, 50원, 100원, 500원 동전의 수가 가장 적게 지불하시오.

import java.util.ArrayList;
import java.util.Arrays;

public class CoinNum {
    public static void coinFunc(int price, ArrayList<Integer> coinList) {
        int totalCoinCount = 0;
        int coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();

        for (int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            details.add(coinNum);
            System.out.println(coinList.get(i) + "원: " + coinNum + "개");
        }
        System.out.println("totalCoinCount = " + totalCoinCount);
    }
    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500, 100, 50, 1));
        coinFunc(4720, coinList);
    }
}
