package experiment.random;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Created 3/8/2018 20:29
 *
 * @author Deepankar Sharma
 */
public class Unescape {

  public static void main(String[] args) {
    //System.out.println(StringEscapeUtils.unescapeHtml("\x1F4E9"));
    String unicode = "&#x2728;";
    System.out.println(unicode(unicode));
    unicode = "&#x10437;";
    System.out.println(unicode(unicode));
    unicode = "&#x1F4E9;";
    System.out.println(unicode(unicode));
    unicode = "&#x1f64b;";
    System.out.println(unicode(unicode));
    unicode = "&#x1F4E9;";
    System.out.println(unicode(unicode));

  }

  public static String unicode(String unicode) {
    int initCode = unicode.indexOf("&#x") + 3;
    int endCode = unicode.indexOf(";");
    String hexString = unicode.substring(initCode, endCode == -1 ? unicode.length() : endCode);
    int number = Integer.parseInt(hexString, 16);
    if(hexString.length() <= 4) {
      return Character.toString((char) number);
    } else {
      int subNum = number - 0x10000;
      int high = subNum / 0x400;
      int low = subNum % 0x400;
      int highAdder = 0xD800;
      int lowAdder = 0xDC00;
      int highSurrogate = high + highAdder;
      int lowSurrogate = low + lowAdder;
      return Character.toString((char) highSurrogate) + Character.toString((char) lowSurrogate);
    }
  }

}
