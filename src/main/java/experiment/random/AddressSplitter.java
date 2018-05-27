package experiment.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created 5/17/2018 14:00
 *
 * @author Deepankar Sharma
 */
public class AddressSplitter {

  public static void main(String[] args)throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    String inputLine = buf.readLine();
    List<String> outputLines = new ArrayList<>();
    while(true) {
      int indexOfCommaSpace = inputLine.indexOf(", ");
      if(indexOfCommaSpace == -1) {
        outputLines.add(inputLine);
        break;
      }
      String addressLine = inputLine.substring(0, indexOfCommaSpace);
      inputLine = inputLine.substring(indexOfCommaSpace + 2, inputLine.length());
      outputLines.add(addressLine);
    }
    outputLines.stream().forEach(System.out::println);
  }

}
