import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pqueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int temp = o1[0] - o2[0];
				return temp == 0 ? o1[1] - o2[1] : temp;
			}
			
		});
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (!pqueue.isEmpty()) {
					sb.append(pqueue.poll()[1]).append("\n");
				}
				else sb.append("0\n");
			} else {
				pqueue.offer(new int[] {Math.abs(x), x});
			}
		}

		br.close();
		System.out.println(sb);
	}
}
