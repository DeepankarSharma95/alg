package experiment.lambdapilot;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Created 4/3/2018 23:29
 *
 * @author Deepankar Sharma
 */
public class ArraysStream {

  public static void main(String[] args) {
    List<String> str = new ArrayList<>();
    String x = "a, b, c   ,d     , e ; f  ";
    String[] arr = x.split("[;,]");
    for(String a : arr) {
      a = a.trim();
      if(StringUtils.isNotBlank(a)) {
        str.add(a);
      }
    }
    System.out.println(str);
  }

}
