import java.util.*;

class Solution {
    
    static int answer;
    static int[] selected;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        selected = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        permutation(k, dungeons, 0);
        
        return answer;
    }
    
    public void permutation(int k, int[][] dungeons, int idx) {
        if (idx == dungeons.length) {
            explore(k, dungeons);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            selected[idx] = i;
            visited[i] = true;
            permutation(k, dungeons, idx + 1);
            visited[i] = false;
        }
    }
    
    public void explore(int k, int[][] dungeons) {
        int cnt = 0;
        for (int i = 0; i < selected.length; i++) {
            int[] dungeon = dungeons[selected[i]];
            if (k >= dungeon[0]) {
                k -= dungeon[1];
                cnt += 1;
            } else break;
        }
        answer = Math.max(answer, cnt);
    }
}