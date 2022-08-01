import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		for(int j = 0; j < N; j++) {
			arr[j] = Integer.parseInt(st1.nextToken());
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st2.nextToken());
			int number = Integer.parseInt(st2.nextToken());
			
			if(gender==1) { // 남학생 
				for(int j = number - 1; j < N; j+=number) {
					arr[j] ^= 1;
				}
			} else { // 여학생
				arr[number - 1] ^= 1;
				for(int j = 1; j < N / 2; j++) {
					if(number - 1 - j < 0 || number - 1 + j >= N) break;
					if(arr[number - 1 - j] == arr[number - 1 + j]) {
						arr[number - 1 - j] ^= 1;
						arr[number - 1 + j] ^= 1;
					} else break;
				}
			}
			
		}
		for(int j = 0; j < N; j++) {
			System.out.print(arr[j]+" ");
            if((j+1) % 20 == 0) System.out.println();
		}
		br.close();
	}

}
