import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Flower implements Comparable<Flower> {

        int start;
        int end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            return start == o.start ? o.end - end : start - o.start;
        }
    }

    static int N;
    static List<Flower> flower;

    private static int solution() {
        int answer = 0;

        int idx = 0;
        int start = 301;
        int end = 0;
        while (start < 1201) {
            end = 0;
            boolean isMax = false;

            for (int i = idx; i < N; i++) {
                Flower cur = flower.get(i);
                if (cur.start > start) break;
                if (cur.start <= start && end < cur.end) {
                    end = cur.end;
                    idx = i + 1;
                    isMax = true;
                }
            }

            if (isMax) {
                start = end;
                answer += 1;
            } else break;
        }

        if (end < 1201) return 0;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        flower = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            
            flower.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
        }

        Collections.sort(flower);
        System.out.println(solution());

        br.close();
    }

}