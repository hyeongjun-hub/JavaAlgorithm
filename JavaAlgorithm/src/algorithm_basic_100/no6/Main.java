package algorithm_basic_100.no6;

public class Main {
    public static void main(String[] args) {
        int num1, num2;
        num1 = 16;
        num2 = 8;

        int smallNum = num1 < num2 ? num1 : num2;
        int gcd = 1;

        for(; smallNum>0 ; smallNum--){
            if(num1 % smallNum == 0 && num2 % smallNum == 0){
                gcd = smallNum;
                break;
            }
        }

        System.out.println("gcd = " + gcd);
    }
}
