package data_structure;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {

        HashMap<Integer, String> map1 = new HashMap();
        //데이터 추가
        map1.put(1, "사과");
        map1.put(2, "바나나");
        map1.put(3, "포도");
        //데이터 읽기
        System.out.println("map1.get(2) = " + map1.get(2));
        //데이터 수정
        map1.put(1, "오렌지");
        //데이터 삭제
        map1.remove(2);

        System.out.println("map1 = " + map1);

        HashMap<String, String> map2 = new HashMap();
        //데이터 추가
        map2.put("DaveLee", "01033334444");
        map2.put("Dave", "01032221111");
        map2.put("David", "0104445555");

        System.out.println("map2.get(2) = " + map2.get("Dave"));

    }

}
