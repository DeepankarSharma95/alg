package experiment.random;

import java.io.UnsupportedEncodingException;

/**
 * Created 9/15/2017 13:09
 *
 * @author Deepankar Sharma
 */
public class URLEncoder {

  private static final String DEEP_LINK = "DEEP LINK URL GOES HERE";

  public static String encode(String a, String b)throws UnsupportedEncodingException {
    return java.net.URLEncoder.encode(a,b);
  }

  public static void main(String[] args) throws UnsupportedEncodingException {
    System.out.println(getDeepLinkURLForLinkAndIFLAppended(DEEP_LINK, "&rx=email_message|member|body_reply||"));
  }

  public static String getDeepLinkURLForLinkAndIFLAppended(String deepLink, String args) {
    String linkString = deepLink.indexOf("link") != -1 ? deepLink.substring(deepLink.indexOf("link"), deepLink.length()) : "";
    String linkURL = linkString.indexOf("&") == -1 ? linkString : linkString.substring(0, linkString.indexOf("&"));
    String iflString = deepLink.indexOf("ifl") != -1 ? deepLink.substring(deepLink.indexOf("ifl"), deepLink.length()) : "";
    String iflURL = iflString.indexOf("&") == -1 ? iflString : iflString.substring(0, iflString.indexOf("&"));
    String encodedArgs;
    try {
      encodedArgs = URLEncoder.encode(args, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    deepLink = deepLink.replace(linkURL, linkURL + encodedArgs);
    deepLink = deepLink.replace(iflURL, iflURL + encodedArgs);
    return deepLink;
  }
}
