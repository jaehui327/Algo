import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 5014. 스타트링크
// https://www.acmicpc.net/problem/5014
public class Main {
	
	static int F, S, G, U, D, result;
	static boolean[] visited;
	static StringBuilder sb;
	
	static boolean bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			if (start == G) return true;
			int up = start + U;
			int down = start - D;
			if (start < G) {
				if(up <= F)
					start = up;
				else if (down > 0)
					start = down;
				result++;
			}
			else if (start > G) {
				if(down > 0)
					start = down;
				else if (up <= F)
					start = up;
				result++;
			}
			
			if(visited[start]) break;
			visited[start] = true;
			queue.add(start);
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken());
		visited = new boolean[F + 1];
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		if(bfs(S)) sb.append(result);
		else sb.append("use the stairs");
		
		br.close();
		System.out.println(sb);
	}
}
