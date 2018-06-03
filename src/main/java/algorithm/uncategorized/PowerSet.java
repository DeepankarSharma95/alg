package algorithm.uncategorized;

public class PowerSet {

  public static void main(String[] args) {
    String[] elements = new String[]{"C", "B", "A"};
    Integer numberOfSubsets = 1 << elements.length;
    System.out.println("{");
    for (int i = 0; i < numberOfSubsets; i++) {
      System.out.print("{");
      Integer bitmask = i;
      Integer pos = elements.length - 1;
      while (bitmask != 0) {
        boolean extend = false;
        if((bitmask & 1) == 1) {
          System.out.print(elements[pos]);
          extend = true;
        }
        bitmask >>= 1;
        pos--;
        if(bitmask != 0 && extend) {
          System.out.print(", ");
        }
      }
      System.out.println("}");
    }
    System.out.println("}");
  }
}
