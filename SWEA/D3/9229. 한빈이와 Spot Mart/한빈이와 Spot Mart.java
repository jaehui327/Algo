import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9229. 한빈이와 Spot Mart
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&
public class Solution {
	
	static int N, M;
	static int[] snack;
	
	static int maxWeight() {
		int result = -1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				int sum = snack[i] + snack[j];
				if(sum <= M) result = Math.max(result, sum);
			}
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException  {
//		System.setIn(new FileInputStream("input/9229.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			snack = new int[N];
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(s.nextToken());
			}
			
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(maxWeight());
			sb.append("\n");
		}

		br.close();
		System.out.println(sb);
	}

}
