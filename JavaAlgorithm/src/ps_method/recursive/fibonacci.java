package ps_method.recursive;

public class fibonacci {
    public static void main(String[] args) {
        int result = fibonacciRecursive(9);
        System.out.println("result = " + result);
    }

    public static int fibonacciRecursive(int inputNum){
        if(inputNum == 0) return 0;
        if(inputNum <= 2) return 1;
        return fibonacciRecursive(inputNum - 1) + fibonacciRecursive(inputNum - 2);
    }
}
