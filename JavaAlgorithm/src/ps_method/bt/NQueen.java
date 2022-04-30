package ps_method.bt;

import java.util.ArrayList;

public class NQueen {

    public boolean available(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        for (int i = 0; i < currentRow; i++) {
            if(candidate.get(i) == currentCol || Math.abs(candidate.get(i) - currentCol)==currentRow-i){
                // 수직 || 대각선
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
                // 만약 재귀함수를 호출하고 파고 파고 들어가 결과를 출력하고 return 하였으면 여기까지 안왔겠지만
                // 출력을 못했으면 candidate에 삽입한 값을 삭제한다.
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
