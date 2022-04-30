package ps_method.bt;

import java.util.ArrayList;

public class NQueen {

    public boolean available(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        for (int i = 0; i < currentRow; i++) {
            if(candidate.get(i) == currentCol || Math.abs(candidate.get(i) - currentCol)==currentRow-i){
                return false;
            }
        }
        return true;
    }

    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {
        // N : 입력값 N, currentRow : 현재 탐색하는 row, currentCandidate : 현재까지 탐색한 노드의 col들
        if(currentRow == N){
            // 조건을 만족시켜 모든 노드를 찾았으니 결과를 출력
            System.out.println(currentCandidate);
            return;
        }

        for(int i=0; i<N; i++){
            if(this.available(currentCandidate, i)){
                currentCandidate.add(i);
                dfsFunc(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
