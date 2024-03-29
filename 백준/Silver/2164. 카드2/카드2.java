import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2164. 카드2
// https://www.acmicpc.net/problem/2164
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) queue.offer(i);
		
		while(true) {
			if(queue.size() == 1) break;
			queue.poll();
			if(queue.size() == 1) break;
			queue.offer(queue.poll());
		}

		br.close();
		System.out.println(queue.poll());
	}

}