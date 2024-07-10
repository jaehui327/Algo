import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[H][W];
        int[] heights = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) heights[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (heights[j] > i) map[i][j] = 1;
                else continue;
            }
        }
        
        int cnt = 0;
        int answer = 0;
        int wall = 0;
        for (int i = 0; i < H; i++) {
            wall = 0;
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) cnt++;
                else {
                    wall++;
                    if (wall >= 2) answer += cnt;
                    cnt = 0;
                }
            }
        }
        
        System.out.println(answer);
        br.close();
    }
}