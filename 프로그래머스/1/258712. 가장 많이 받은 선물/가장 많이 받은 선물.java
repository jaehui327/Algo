import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> friend = new HashMap<>();
        int[][] gift = new int[friends.length][friends.length];
        int[] giftIdx = new int[friends.length];
        ArrayList<Integer> cnt = new ArrayList<>();
        StringTokenizer st;
        
        for (int i = 0; i < friends.length; i++) friend.put(friends[i], i);
        for (int i = 0; i < friends.length; i++) cnt.add(0);
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            String a = st.nextToken();
            String b = st.nextToken();
            gift[friend.get(a)][friend.get(b)] += 1;
            giftIdx[friend.get(a)] += 1;
            giftIdx[friend.get(b)] -= 1;
        }
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (gift[i][j] > gift[j][i]) cnt.set(i, cnt.get(i) + 1);
                else if (gift[i][j] < gift[j][i]) cnt.set(j, cnt.get(j) + 1);
                else if (giftIdx[i] > giftIdx[j]) cnt.set(i, cnt.get(i) + 1);
                else if (giftIdx[i] < giftIdx[j]) cnt.set(j, cnt.get(j) + 1);
            }
        }
        
        return Collections.max(cnt);
    }
}