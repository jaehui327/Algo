import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static boolean[][] board;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void DFS(int v) {
		sb.append(v);
		sb.append(" ");
		visited[v] = true;
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && board[v][i]) {
				DFS(i);
			}
		}
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			v = queue.peek();
			sb.append(v);
			sb.append(" ");
			queue.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && board[v][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		board = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer node = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(node.nextToken());
			int b = Integer.parseInt(node.nextToken());
			board[a][b] = board[b][a] = true;
		}
		
		DFS(V);
		sb.append("\n");
		visited = new boolean[N+1];
		BFS(V);
		
		br.close();
		System.out.println(sb);
	}
}
