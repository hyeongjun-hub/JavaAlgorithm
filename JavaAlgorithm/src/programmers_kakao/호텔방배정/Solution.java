package programmers_kakao.호텔방배정;

import java.util.HashMap;

class Solution {
    HashMap<Long, Long> hotel = new HashMap();

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getRoom(room_number[i]);
        }

        return answer;
    }

    private long getRoom(long room) {
        if (!hotel.containsKey(room)) {
            hotel.put(room, room + 1);
            return room;
        }
        long nextRoomNum = hotel.get(room);
        long emptyRoomNum = getRoom(nextRoomNum);
        hotel.put(room, emptyRoomNum);
        return emptyRoomNum;
    }

}