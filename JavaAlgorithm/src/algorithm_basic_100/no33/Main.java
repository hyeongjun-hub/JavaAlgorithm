//0을 모두 2로 색칠하시오.(재귀)
//(단, 0은 어떻게든 모두 연결됨)
//입력
//00000
//00110
//00001
//00000
//00100
//정답:
//22222
//22112
//22221
//22222
//22122

package algorithm_basic_100.no33;

public class Main {
    static final int SIZE = 5;
    static final int COLOR = 2;

    static int [][]map =
            {
                    {0,0,0,0,0},
                    {0,0,1,1,0},
                    {0,0,0,0,1},
                    {0,0,0,0,0},
                    {0,0,1,0,0}
            };

    public static void color(int x, int y){
        if(map[x][y] != 1){
            map[x][y] = COLOR;
        }
        if (x == SIZE-1 || y == SIZE-1) {
            return;
        }else{
            color(x + 1, y);
            color(x, y + 1);
            color(x + 1, y + 1);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        color(0, 0);

        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
