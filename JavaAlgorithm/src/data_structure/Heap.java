package data_structure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data){
        heapArray = new ArrayList<>();

        heapArray.add(null);
        heapArray.add(data);
    }

    // parent 노드의 값과 비교하는 함수 (True 라면 올라가야 함)
    public boolean moveUp(Integer insertedIdx){
        if (insertedIdx <= 1) {
            return false;
        }
        int insertedValue = heapArray.get(insertedIdx);
        int parentValue = heapArray.get(insertedIdx / 2);
        return insertedValue > parentValue;
    }

    public boolean moveDown(Integer poppedIdx) {
        Integer leftChildPoppedIdx = poppedIdx * 2;
        Integer rightChildPoppedIdx = poppedIdx * 2 + 1;
        // CASE 1: 왼쪽 자식 노드도 없을 때(자식노드가 하나도 없을 때)
        if (leftChildPoppedIdx >= heapArray.size()) {
            return false;
        }
        // CASE 2: 오른쪽 자식 노드만 없을 때(왼쪽 자식노드만 있을 때)
        else if (rightChildPoppedIdx >= heapArray.size()) {
            return heapArray.get(leftChildPoppedIdx) > heapArray.get(poppedIdx);
        }
        // CASE 3: 자식 둘 다 있을 때
        else{
            return Math.max(heapArray.get(leftChildPoppedIdx), heapArray.get(rightChildPoppedIdx)) > heapArray.get(poppedIdx);
        }

    }

    public boolean insert(int data) {
        int insertedIdx, parentIdx;

        if (heapArray == null) {
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);

            heapArray.add(data);
        } else {
            heapArray.add(data);
            insertedIdx = heapArray.size() - 1;
            while(this.moveUp(insertedIdx)){
                parentIdx = insertedIdx / 2;
                Collections.swap(heapArray, insertedIdx, parentIdx);
                insertedIdx = parentIdx;
            }
        }
        return true;
    }

    public Integer pop(){
        Integer returnData, poppedIdx, leftChildPoppedIdx, rightChildPoppedIdx;

        if (this.heapArray == null) {
            return null;
        } else {
            returnData = heapArray.get(1);
            heapArray.set(1, heapArray.get(heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);
            poppedIdx = 1;
            while (this.moveDown(poppedIdx)) {
                leftChildPoppedIdx = poppedIdx * 2;
                rightChildPoppedIdx = poppedIdx * 2 + 1;
                // CASE 2: 오른쪽 자식 노드만 없을 때(왼쪽 자식노드만 있을 때)
                if (rightChildPoppedIdx >= heapArray.size()) {
                    Collections.swap(heapArray, poppedIdx, leftChildPoppedIdx);
                    poppedIdx = leftChildPoppedIdx;
                }
                // CASE 3: 자식 둘 다 있을 때
                else {
                    // CASE 3-1 : 왼쪽 자식이 더 클 때
                    if (heapArray.get(leftChildPoppedIdx) > heapArray.get(rightChildPoppedIdx)) {
                        Collections.swap(heapArray, poppedIdx, leftChildPoppedIdx);
                        poppedIdx = leftChildPoppedIdx;
                    }
                    // CASE 3-2 : 오른쪽 자식이 더 클 떄
                    else {
                        Collections.swap(heapArray, poppedIdx, rightChildPoppedIdx);
                        poppedIdx = rightChildPoppedIdx;
                    }
                }
            }
            return returnData;
        }
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);

        System.out.println(heapTest.heapArray);

        int max1 = heapTest.pop();
        System.out.println("max1 = " + max1);
        int max2 = heapTest.pop();
        System.out.println("max2 = " + max2);

    }

}
