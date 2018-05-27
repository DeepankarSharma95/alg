package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created 5/13/2018 15:08
 *
 * @author Deepankar Sharma
 */
public class ContainingCharacters {

  public static void main(String[] args)throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(buf.readLine());
    int y = Integer.parseInt(buf.readLine());
    int z = Integer.parseInt(buf.readLine());
    int count = 0;
    outer:
    for(int i = y; i <= z; i++) {
      int prod = x*i;
      String n = i + "";
      String prodStr = prod + "";
      for(char c : n.toCharArray()) {
        if(prodStr.contains(c + "")) {
          continue outer;
        }
      }
      count ++;
    }
    System.out.println(count);

  }

}
