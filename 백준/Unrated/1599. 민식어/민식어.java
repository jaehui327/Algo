import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static class Minsik implements Comparable<Minsik> {
    String word;
    String compareWord;

    Minsik(String word, String compareWord) {
      this.word = word;
      this.compareWord = compareWord;
    }

    @Override
    public int compareTo(Minsik o) {
      return this.compareWord.compareTo(o.compareWord);
    }
  }

  static int N;
  static List<Minsik> words;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    words = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String word = br.readLine();
      String compareWord = word.replaceAll("k", "c");
      compareWord = compareWord.replaceAll("ng", "nz");
      words.add(new Minsik(word, compareWord));
    }

    Collections.sort(words);

    for (int i = 0; i < N; i++) {
      sb.append(words.get(i).word).append("\n");
    }
    System.out.println(sb.toString());

    br.close();
  }

}