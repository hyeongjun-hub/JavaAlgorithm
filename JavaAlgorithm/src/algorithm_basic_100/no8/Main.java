// factorial 구하기

package algorithm_basic_100.no8;

public class Main {
    public static void main(String[] args) {
        int num = 7;
        int fact = 1;

        while(num > 1){
            fact *= num;
            num--;
        }
        System.out.println(fact);
    }
}
