// 3 6 9 game

package algorithm_basic_100.no20;

public class Main {
    public static void main(String[] args) {
        int n = 100;

        for(int i = 1; i <= n; i++) {
            int count = 0;
            int iCopy = i;
            while(iCopy > 0){
               if(iCopy % 10 == 3 || iCopy % 10 == 6 || iCopy % 10 == 9){
                   count++;
               }
               iCopy /= 10;
            }
            if (count > 0) {
                while(count > 0){
                    System.out.print("짝");
                    count--;
                }
            }else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
