import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void bfs(int N, Map<Integer, Set<Integer>> map, Set<Integer> truth) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        for (int t: truth) {
            queue.offer(t);
            visited[t] = true;
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int n: map.get(cur)) {
                if (visited[n]) continue;
                queue.add(n);
                truth.add(n);
                visited[n] = true;
            }
        }
    }

    static int solution(List<List<Integer>> parties, Set<Integer> truth) {
        int answer = 0;
        boolean isAvailable;
        for (List<Integer> party: parties) {
            isAvailable = true;
            for (int n: party) {
                if (truth.contains(n)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());

        Set<Integer> truth = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < cnt; i++)
            truth.add(Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            parties.add(new ArrayList<>());
            for (int j = 0; j < cnt; j++)
                parties.get(i).add(Integer.parseInt(st.nextToken()));

            for (int j = 0; j < cnt; j++) {
                for (int k = 0; k < cnt; k++) {
                    map.get(parties.get(i).get(j)).add(parties.get(i).get(k));
                }
            }
        }

        bfs(N, map, truth);
        System.out.println(solution(parties, truth));

        br.close();
    }
}