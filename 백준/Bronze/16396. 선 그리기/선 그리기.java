import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Position implements Comparable<Position> {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        List<Position> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Position(x, y));
        }

        Collections.sort(list);
        int start = list.get(0).x, end = list.get(0).y;
        for (int i = 1; i < N; i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            if (start <= x && x <= end) {
                end = Math.max(end, y);
            } else {
                answer += end - start;
                start = x;
                end = y;
            }
        }

        answer += end - start;

        System.out.println(answer);
        br.close();
    }

}