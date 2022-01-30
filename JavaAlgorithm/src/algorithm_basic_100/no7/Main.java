// 소수 판별하기

package algorithm_basic_100.no7;

public class Main {
    public static void main(String[] args) {
        int num = 13;

        for (int i = 2; i < num; i++){
            if(num % 1 == 0){
                System.out.println(num + "은 소수");
                break;
            }
        }
    }
}
