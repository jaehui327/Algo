import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static int N;
  static String[] words;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    words = new String[N];

    for (int i = 0; i < N; i++) words[i] = br.readLine().replace("k", "c").replace("ng", "nz");;
    Arrays.sort(words);
    for (int i = 0; i < N; i++) words[i] = words[i].replace("c", "k").replace("nz", "ng");;

    for (int i = 0; i < N; i++) System.out.println(words[i]);

    br.close();
  }

}