// 펠린드롬 판별

package algorithm_basic_100.no21;

public class Main {
    public static void main(String[] args) {
        String n = "12321";

        int len = n.length();
        boolean flag = true;

        for(int i=0; i<len/2; i++){
            if(n.charAt(i) != n.charAt(len-i-1)){
                flag = false;
            }
        }

        System.out.println(flag);
    }

}
